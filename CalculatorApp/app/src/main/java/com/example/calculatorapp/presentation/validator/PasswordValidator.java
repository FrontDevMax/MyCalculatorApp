package com.example.calculatorapp.presentation.validator;

import com.example.calculatorapp.domain.model.Credentials;

public class PasswordValidator<T extends CredentialsHolder> implements Validator<T> {
    @Override
    public ValidationResult validate(T request) {
        String password = request.getCredentials().getPassword();
        if(password.equals("")) {
            return ValidationResult.invalid("Пароль пустой");
        } else if(password.length() > 8) {
            return ValidationResult.invalid("Пароль не должен быть больше 8");
        }
        return ValidationResult.valid();
    }
}
