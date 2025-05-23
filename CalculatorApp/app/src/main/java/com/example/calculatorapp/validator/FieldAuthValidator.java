package com.example.calculatorapp.validator;

import com.example.calculatorapp.exception.AuthException;

public interface FieldAuthValidator<T> {
    public void validate(T request) throws AuthException;
}
