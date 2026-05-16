package com.turkcell.library_cqrs.core.security.filter;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.turkcell.library_cqrs.core.security.authorization.Role;
import com.turkcell.library_cqrs.core.security.context.UserContext;
import com.turkcell.library_cqrs.core.security.jwt.JwtService;
// bu sınıfta jwt doğrulama işlemleri yapılacak. Token'ı alıp doğrulayacak ve kullanıcı bilgilerini güvenlik bağlamına ekleyecek.
@Component
public class JwtAuthFilter extends OncePerRequestFilter 
{
    private final JwtService jwtService;
    private final UserContext userContext;

    public JwtAuthFilter(JwtService jwtService, UserContext userContext) {
        this.jwtService = jwtService;
        this.userContext = userContext;
    }
     @Override
     // Her istekte çalışacak olan bu metod, gelen istekteki JWT'yi doğrular ve kullanıcı bilgilerini güvenlik bağlamına ekler.
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String jwtHeader =
                request.getHeader("Authorization");

        if (jwtHeader != null
                && jwtHeader.startsWith("Bearer ")) {

            String token = jwtHeader.substring(7);

            try {

                if (jwtService.isTokenValid(token)) {

                    String userId =
                            jwtService.extractUserId(token);

                    String email =
                            jwtService.extractEmail(token);

                    List<Role> roles =
                            jwtService.extractRoles(token);

                    userContext.setUser(
                            userId,
                            email,
                            roles
                    );
                }

            } catch (Exception e) {

                userContext.clear();

            }
        }

        filterChain.doFilter(request, response);
    }
}