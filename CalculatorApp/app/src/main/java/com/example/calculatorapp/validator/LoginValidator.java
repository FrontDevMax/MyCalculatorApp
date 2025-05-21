package com.example.calculatorapp.validator;

import com.example.calculatorapp.enumeration.AuthError;
import com.example.calculatorapp.exception.AuthException;

public class LoginValidator {
    private FieldValidator emailValidator, passwordValidator;

    public LoginValidator() {
        this.emailValidator = new EmailValidator();
        this.passwordValidator = new PasswordValidator();
    }

    public void validateEmail(String email) throws AuthException {
        if(emailValidator.isValid(email)) {
            throw new AuthException(AuthError.EMAIL, emailValidator.getErrorMessage());
        }
    }

    public void validatePassword(String password) throws AuthException {
        if(passwordValidator.isValid(password)) {
            throw new AuthException(AuthError.PASSWORD, passwordValidator.getErrorMessage());
        }
    }
}
