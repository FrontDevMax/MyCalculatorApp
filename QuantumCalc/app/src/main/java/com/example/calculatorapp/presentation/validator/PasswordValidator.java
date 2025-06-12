package com.example.calculatorapp.presentation.validator;

public class PasswordValidator<T extends CredentialsHolder> implements Validator<T> {
    @Override
    public ValidationResult validate(T request) {
        String password = request.getCredentials().getPassword();
        if(password.equals("")) {
            return ValidationResult.invalid("Введите пароль");
        } else if(password.length() < 6) {
            return ValidationResult.invalid("Пароль должен содержать минимум 6 символов");
        } else if(password.length() > 8) {
            return ValidationResult.invalid("Пароль должен содержать максимум 8 символов");
        }
        return ValidationResult.valid();
    }
}
