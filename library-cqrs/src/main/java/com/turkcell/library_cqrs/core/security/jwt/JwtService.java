package com.turkcell.library_cqrs.core.security.jwt;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import com.turkcell.library_cqrs.core.security.authorization.Role;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
@EnableConfigurationProperties(JwtProperties.class)
public class JwtService {

    private final JwtProperties jwtProperties;
    private final SecretKey signingKey;

    public JwtService(JwtProperties jwtProperties) {

        this.jwtProperties = jwtProperties;

        byte[] keyBytes =
                Decoders.BASE64.decode(
                        jwtProperties.getSecret());
        this.signingKey =Keys.hmacShaKeyFor(keyBytes);
    }
    public String generate(UUID userId, String email,List<Role> roles) {
        Instant now = Instant.now();
// JWT oluşturma işlemi burada gerçekleşir. Kullanıcı ID'si, email ve roller gibi bilgileri token'a ekleriz.
//claims: token içindeki bilgileri tutan yapıdır. subject: token'ın sahibi, claim: token'a eklenen özel bilgiler, expiration: token'ın geçerlilik süresi.
        return Jwts.builder()
                .issuer(jwtProperties.getIssuer())
                .subject(userId.toString())
                .claim("email", email)
                .claim(
                        "roles",
                        roles.stream()
                                .map(Role::name)
                                .toList())
                                .issuedAt(Date.from(now))
                                .expiration(
                                Date.from(now.plusSeconds(jwtProperties
                                .getExpirationInSeconds())))
                                .signWith(signingKey)
                                 .compact();
    }
    public String extractUserId(String token) {

        return extractClaim(token,
                Claims::getSubject );
    }

    public String extractEmail(String token) {

        return extractClaim(
                token,
                claims -> claims.get( "email",
                                String.class));
    }

    public List<Role> extractRoles(String token) {

        List<String> roles =
                extractClaim(
                        token,
                        claims ->
                                claims.get(
                                        "roles",
                                        List.class
                                )
                );

        return roles.stream()
                .map(Role::valueOf)
                .toList();
    }
    public boolean isTokenValid(String token) {
        try {
            return !extractClaim(
                    token,
                    Claims::getExpiration
            ).before(new Date());

        } catch (Exception e) {

            return false;
        }
    }
    private <T> T extractClaim(
            String token,
            Function<Claims, T> resolver) {
        Claims claims = Jwts.parser()
                .verifyWith(signingKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return resolver.apply(claims);
    }
}