package com.example.calculatorapp.exception;

import com.example.calculatorapp.enumeration.AuthError;

public class AuthException extends Exception {
    private final AuthError authError;
    public AuthException(AuthError authError, String message) {
        super(message);
        this.authError = authError;
    }

    public AuthError getErrorType() {
        return authError;
    }
}
