package com.example.calculatorapp.validator;

import com.example.calculatorapp.exception.AuthException;
import com.example.calculatorapp.model.Credentials;
import com.example.calculatorapp.model.RegisterRequest;

public class RegisterValidator implements FieldAuthValidator<RegisterRequest> {
    private FieldAuthValidator<Credentials> emailValidator, passwordValidator;
    private FieldAuthValidator<RegisterRequest> usernameValidator, confirmPasswordValidator;

    public RegisterValidator() {
        this.usernameValidator = new UsernameValidator();
        this.emailValidator = new EmailValidator();
        this.passwordValidator = new PasswordValidator();
        this.confirmPasswordValidator = new ConfirmPasswordValidator();
    }

    @Override
    public void validate(RegisterRequest registerRequest) throws AuthException {
        Credentials credentials = registerRequest.getCredentials();
        usernameValidator.validate(registerRequest);
        emailValidator.validate(credentials);
        passwordValidator.validate(credentials);
        confirmPasswordValidator.validate(registerRequest);
    }
}
