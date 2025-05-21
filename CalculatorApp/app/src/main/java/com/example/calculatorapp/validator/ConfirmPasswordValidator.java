package com.example.calculatorapp.validator;

import com.example.calculatorapp.R;
import com.example.calculatorapp.enumeration.AuthError;
import com.example.calculatorapp.exception.AuthException;
import com.example.calculatorapp.model.RegisterRequest;

public class ConfirmPasswordValidator extends PasswordValidator {
    private String message;
    private RegisterRequest registerRequest = new RegisterRequest();

    @Override
    public boolean isValid(String confirmPassword) {
        if(confirmPassword.equals("")) {
            message = "Поле повторите пароля пустое!";
            return true;
        } else if(!confirmPassword.equals(registerRequest.getPassword())) {
            message = "Поле повторите пароля не совпадает с паролем!";
            return true;
        }
        return false;
    }

    @Override
    public String getErrorMessage() {
        return message;
    }
}
