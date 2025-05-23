package com.example.calculatorapp.validator;

import android.util.Patterns;

import com.example.calculatorapp.enumeration.AuthError;
import com.example.calculatorapp.exception.AuthException;
import com.example.calculatorapp.model.Credentials;

public class EmailValidator implements FieldAuthValidator<Credentials> {
    @Override
    public void validate(Credentials credentials) throws AuthException {
        if(credentials.getEmail().equals("")) {
            throw new AuthException(AuthError.INVALID_EMAIL, "Эл. почта не должна быть пустая!");
        } else if(!Patterns.EMAIL_ADDRESS.matcher(credentials.getEmail()).matches()) {
            throw new AuthException(AuthError.INVALID_EMAIL, "Отсутствует @");
        }
    }
}
