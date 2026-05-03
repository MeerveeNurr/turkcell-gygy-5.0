package com.turkcell.spring_starter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

// Kütüphane projenizde:
// Ödev: Bilindik hata türleri için yönetimi düzgünleştir.
// RuntimeException çok genel olduğu için, kendimize özel Exception türleri yaratıp onları yakalamak. (BusinessException)
// ErrorResponse -> {title, type, message}
// ValidationErrorResponse -> {arguments: []}
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(Exception exception) {
        return new ErrorResponse("Sunucu Hatası", "Exception", "Beklenmedik bir hata oluştu: " + exception.getMessage());
    }

    @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST) // api isteği atarken hata mesajı geldiğinde köşede 200 ok yerine burada belirttiğimiz 
    // hata kodunu verir.
    public ErrorResponse handleRuntimeException(RuntimeException exception){
        return new ErrorResponse("Sistem Hatası", "RuntimeException", exception.getMessage());
    }

    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBusinessException(BusinessException exception) {
        return new ErrorResponse("Business Rule Violation", "BusinessException", exception.getMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationErrorResponse handleValidationException(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return new ValidationErrorResponse("Validation Error", "ValidationException", "One or more validation errors occurred", errors);
    }
}
