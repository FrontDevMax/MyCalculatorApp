package com.example.calculatorapp.validator;

import com.example.calculatorapp.enumeration.AuthError;
import com.example.calculatorapp.exception.AuthException;

public class PasswordValidator implements FieldValidator {
    private String message;

    @Override
    public boolean isValid(String password) {
        if(password.equals("")) {
            message = "Пароль не должен быть пустым!";
            return true;
        } else if(password.length() > 8) {
            message = "Длина пароля должна быть не более 8 символов";
            return true;
        }
        return false;
    }

    @Override
    public String getErrorMessage() {
        return message;
    }
}
