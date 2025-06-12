package com.example.calculatorapp.presentation.validator;

import android.util.Patterns;

public class EmailValidator<T extends CredentialsHolder> implements Validator<T> {
    @Override
    public ValidationResult validate(T request) {
        String email = request.getCredentials().getEmail();
        if(email.equals("")) {
            return ValidationResult.invalid("Введите email");
        } else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return ValidationResult.invalid("Неверный формат email");
        }
        return ValidationResult.valid();
    }
}
