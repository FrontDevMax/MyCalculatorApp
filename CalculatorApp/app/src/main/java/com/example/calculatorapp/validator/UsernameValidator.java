package com.example.calculatorapp.validator;

import android.util.Patterns;

import com.example.calculatorapp.enumeration.AuthError;
import com.example.calculatorapp.exception.AuthException;

public class UsernameValidator implements FieldValidator {
    private String message;

    @Override
    public boolean isValid(String username) {
        if(username.equals("")) {
            message = "Поле имя пользователя пустое!";
            return true;
        }  else if(username.length() > 20) {
            message = "Превышена длина символов!";
            return true;
        }
        return false;
    }

    @Override
    public String getErrorMessage() {
        return message;
    }
}
