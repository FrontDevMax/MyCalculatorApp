package com.example.calculatorapp.validator;

import com.example.calculatorapp.enumeration.AuthError;
import com.example.calculatorapp.exception.AuthException;
import com.example.calculatorapp.model.Credentials;
import com.example.calculatorapp.model.LoginRequest;

public class LoginValidator implements FieldAuthValidator<LoginRequest> {
    private FieldAuthValidator<Credentials> emailValidator, passwordValidator;

    public LoginValidator() {
        this.emailValidator = new EmailValidator();
        this.passwordValidator = new PasswordValidator();
    }

    @Override
    public void validate(LoginRequest loginRequest) throws AuthException {
        Credentials credentials = loginRequest.getCredentials();
        emailValidator.validate(credentials);
        passwordValidator.validate(credentials);
        if(!credentials.getEmail().equals("example123@gmail.com") || !credentials.getPassword().equals("admin")) {
            throw new AuthException(AuthError.INVALID_LOGIN, "Нет такого пользователя");
        }
    }
}
