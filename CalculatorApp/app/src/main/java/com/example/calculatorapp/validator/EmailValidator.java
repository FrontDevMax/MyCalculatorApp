package com.example.calculatorapp.validator;

import android.util.Patterns;

import com.example.calculatorapp.enumeration.AuthError;
import com.example.calculatorapp.exception.AuthException;

public class EmailValidator implements FieldValidator {
    private String message;

    @Override
    public boolean isValid(String email) {
        if(email.equals("")) {
            message = "Эл. почта не должна быть пустая!";
            return true;
        } else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            message = "Отсутствует @ или неправильно ввели что-то";
            return true;
        }
        return false;
    }

    @Override
    public String getErrorMessage() {
        return message;
    }
}
