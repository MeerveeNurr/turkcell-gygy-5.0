package com.turkcell.spring_cqrs.core.exceptions;

public class AuthenticationException
        extends RuntimeException {

    public AuthenticationException(String message) {
        super(message);
    }
}