package com.example.calculatorapp.presentation.validator;

import com.example.calculatorapp.domain.model.RegisterRequest;

public class UsernameValidator implements Validator<RegisterRequest> {
    @Override
    public ValidationResult validate(RegisterRequest registerRequest) {
        String username = registerRequest.getUsername();
        if(username.equals("")) {
            return ValidationResult.invalid("Введите имя");
        } else if(username.length() > 20 || username.length() < 5) {
            return ValidationResult.invalid("Имя должно быть от 5 до 20 символов");
        }
        return ValidationResult.valid();
    }
}
