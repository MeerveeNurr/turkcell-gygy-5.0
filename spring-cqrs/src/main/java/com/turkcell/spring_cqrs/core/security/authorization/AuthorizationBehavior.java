package com.turkcell.spring_cqrs.core.security.authorization;

import java.util.List;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.turkcell.spring_cqrs.core.exceptions.AuthenticationException;
import com.turkcell.spring_cqrs.core.exceptions.AuthorizationException;
import com.turkcell.spring_cqrs.core.mediator.pipeline.PipelineBehavior;
import com.turkcell.spring_cqrs.core.mediator.pipeline.RequestHandlerDelegate;
import com.turkcell.spring_cqrs.core.security.context.UserContext;

@Component
@Order(10)
public class AuthorizationBehavior
        implements PipelineBehavior {

    private final UserContext userContext;

    public AuthorizationBehavior(
            UserContext userContext ) {
        this.userContext = userContext;
    }

    @Override
    public boolean supports(Object request) {

        return request instanceof AuthorizableRequest;
    }

    @Override
    public <R> R handle(
            Object request,
            RequestHandlerDelegate<R> next ) {

        AuthorizableRequest authRequest =
                (AuthorizableRequest) request;

        // LOGIN kontrolü
        if (!userContext.isAuthenticated()) {

            throw new AuthenticationException(
                    "Giriş yapmalısın");
        }
        List<Role> requiredRoles =
                authRequest.requiredRoles();

        if (requiredRoles == null
                || requiredRoles.isEmpty()) {

            return next.invoke();
        }

        List<Role> userRoles =
                userContext.getRoles();

        boolean hasRole =
                requiredRoles.stream()
                        .anyMatch(userRoles::contains);

        if (!hasRole) {
            throw new AuthorizationException(
                    "Bu işlem için yetkin yok" );  }

        return next.invoke();
    }
}