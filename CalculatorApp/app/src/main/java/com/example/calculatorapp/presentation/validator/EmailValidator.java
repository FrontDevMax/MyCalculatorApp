package com.example.calculatorapp.presentation.validator;

import android.util.Patterns;

import com.example.calculatorapp.domain.model.Credentials;

public class EmailValidator<T extends CredentialsHolder> implements Validator<T> {
    @Override
    public ValidationResult validate(T request) {
        String email = request.getCredentials().getEmail();
        if(email.equals("")) {
            return ValidationResult.invalid("Эл. почта пустая");
        } else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return ValidationResult.invalid("Неверный формат эл. почты!");
        }
        return ValidationResult.valid();
    }
}
