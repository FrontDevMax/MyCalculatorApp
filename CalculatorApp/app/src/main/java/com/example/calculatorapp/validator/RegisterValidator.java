package com.example.calculatorapp.validator;

import com.example.calculatorapp.enumeration.AuthError;
import com.example.calculatorapp.exception.AuthException;

public class RegisterValidator {
    private FieldValidator usernameValidator, emailValidator, passwordValidator, confirmPasswordValidator;

    public RegisterValidator()
    {
        this.usernameValidator = new UsernameValidator();
        this.emailValidator = new EmailValidator();
        this.passwordValidator = new PasswordValidator();
        this.confirmPasswordValidator = new ConfirmPasswordValidator();
    }

    public void validateUsername(String username) throws AuthException {
        if(usernameValidator.isValid(username)) {
            throw new AuthException(AuthError.USERNAME, usernameValidator.getErrorMessage());
        }
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

    public void validateConfirmPassword(String confirmPassword) throws AuthException {
        if(confirmPasswordValidator.isValid(confirmPassword)) {
            throw new AuthException(AuthError.CONFIRM_PASSWORD, confirmPasswordValidator.getErrorMessage());
        }
    }
}
