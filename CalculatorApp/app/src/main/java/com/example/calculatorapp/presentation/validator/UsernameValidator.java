package com.example.calculatorapp.presentation.validator;

import com.example.calculatorapp.domain.model.RegisterRequest;

public class UsernameValidator implements Validator<RegisterRequest> {
    @Override
    public ValidationResult validate(RegisterRequest registerRequest) {
        String username = registerRequest.getUsername();
        if(username.equals("")) {
            return ValidationResult.invalid("Имя пустое");
        } else if(username.length() > 20) {
            return ValidationResult.invalid("Имя не должно быть больше 20");
        }
        return ValidationResult.valid();
    }
}
