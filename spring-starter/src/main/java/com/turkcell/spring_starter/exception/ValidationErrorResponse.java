package com.turkcell.spring_starter.exception;

import java.util.Map;

public record ValidationErrorResponse(String title, String type, String message, Map<String, String> arguments) {
}
