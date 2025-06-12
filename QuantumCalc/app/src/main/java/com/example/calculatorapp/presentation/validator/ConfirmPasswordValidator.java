package com.example.calculatorapp.presentation.validator;

import com.example.calculatorapp.domain.model.RegisterRequest;

public class ConfirmPasswordValidator implements Validator<RegisterRequest> {
    @Override
    public ValidationResult validate(RegisterRequest registerRequest) {
        String confirmPassword = registerRequest.getConfirmPassword();
        String password = registerRequest.getCredentials().getPassword();
        if(confirmPassword.equals("")) {
            return ValidationResult.invalid("Повторите пароль");
        } else if(!confirmPassword.equals(password)) {
            return ValidationResult.invalid("Пароли не совпадают");
        }
        return ValidationResult.valid();
    }
}
