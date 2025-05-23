package com.example.calculatorapp.validator;

import com.example.calculatorapp.enumeration.AuthError;
import com.example.calculatorapp.exception.AuthException;
import com.example.calculatorapp.model.RegisterRequest;

public class UsernameValidator implements FieldAuthValidator<RegisterRequest> {
    @Override
    public void validate(RegisterRequest registerRequest) throws AuthException {
        if(registerRequest.getUsername().equals("")) {
            throw new AuthException(AuthError.INVALID_USERNAME, "Поле имя пользователя пустое!");
        } else if(registerRequest.getUsername().length() > 20) {
            throw new AuthException(AuthError.INVALID_USERNAME, "Превышена длина символов!");
        }
    }
}
