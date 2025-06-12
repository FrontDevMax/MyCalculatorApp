package com.example.calculatorapp.presentation.validator;

@FunctionalInterface
public interface Validator<T> {
    ValidationResult validate(T request);
}
