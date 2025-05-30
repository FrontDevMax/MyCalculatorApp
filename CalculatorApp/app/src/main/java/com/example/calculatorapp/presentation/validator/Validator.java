package com.example.calculatorapp.presentation.validator;

import com.example.calculatorapp.domain.model.Credentials;

public interface Validator<T> {
    ValidationResult validate(T request);
}
