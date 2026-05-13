package com.turkcell.spring_cqrs.core.exceptions;

public class AuthorizationException
        extends RuntimeException {

    public AuthorizationException(String message) {
        super(message);
    }
}