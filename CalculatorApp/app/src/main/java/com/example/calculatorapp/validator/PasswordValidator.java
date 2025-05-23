package com.example.calculatorapp.validator;

import com.example.calculatorapp.enumeration.AuthError;
import com.example.calculatorapp.exception.AuthException;
import com.example.calculatorapp.model.Credentials;

public class PasswordValidator implements FieldAuthValidator<Credentials> {
    @Override
    public void validate(Credentials credentials) throws AuthException {
        if(credentials.getPassword().equals("")) {
            throw new AuthException(AuthError.INVALID_PASSWORD, "Пароль не должен быть пустым!");
        } else if(credentials.getPassword().length() > 8) {
            throw new AuthException(AuthError.INVALID_PASSWORD, "Длина пароля должна быть не более 8 символов");
        }
    }
}
