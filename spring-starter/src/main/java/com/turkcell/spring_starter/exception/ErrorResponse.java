package com.turkcell.spring_starter.exception;

public record ErrorResponse(String title, String type, String message) {
}
