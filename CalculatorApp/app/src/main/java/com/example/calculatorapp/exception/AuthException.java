package com.example.calculatorapp.exception;

import com.example.calculatorapp.enumeration.ErrorType;

public class AuthException extends Exception {
    private final ErrorType errorType;
    public AuthException(ErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }

    public ErrorType getErrorType() {
        return errorType;
    }
}
