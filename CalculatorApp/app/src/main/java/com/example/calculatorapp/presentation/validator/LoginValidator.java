package com.example.calculatorapp.presentation.validator;

import android.util.Log;

import com.example.calculatorapp.domain.model.LoginRequest;

public class LoginValidator implements Validator<LoginRequest> {
    @Override
    public ValidationResult validate(LoginRequest loginRequest) {
        String email = loginRequest.getCredentials().getEmail();
        String password = loginRequest.getCredentials().getPassword();
        if(!email.equals("example123@gmail.com") || !password.equals("admin")) {
            return ValidationResult.invalid("Нет такого пользователя");
        }
        return ValidationResult.valid();
    }
}
