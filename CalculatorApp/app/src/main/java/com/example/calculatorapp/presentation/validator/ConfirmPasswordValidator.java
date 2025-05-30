package com.example.calculatorapp.presentation.validator;

import com.example.calculatorapp.domain.model.RegisterRequest;

public class ConfirmPasswordValidator implements Validator<RegisterRequest> {
    @Override
    public ValidationResult validate(RegisterRequest registerRequest) {
        String confirmPassword = registerRequest.getConfirmPassword();
        String password = registerRequest.getCredentials().getPassword();
        if(confirmPassword.equals("")) {
            return ValidationResult.invalid("Повторите пароль пустой");
        } else if(confirmPassword.length() > 8) {
            return ValidationResult.invalid("Повторите пароль не должен быть больше 8");
        } else if(!confirmPassword.equals(password)) {
            return ValidationResult.invalid("Повторите пароль не совпадает с предыдущим");
        }
        return ValidationResult.valid();
    }
}
