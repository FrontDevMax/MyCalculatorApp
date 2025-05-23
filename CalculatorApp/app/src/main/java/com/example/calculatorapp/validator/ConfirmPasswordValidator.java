package com.example.calculatorapp.validator;

import com.example.calculatorapp.enumeration.AuthError;
import com.example.calculatorapp.exception.AuthException;
import com.example.calculatorapp.model.Credentials;
import com.example.calculatorapp.model.RegisterRequest;

public class ConfirmPasswordValidator implements FieldAuthValidator<RegisterRequest> {
    @Override
    public void validate(RegisterRequest registerRequest) throws AuthException {
        Credentials credentials = registerRequest.getCredentials();
        if(registerRequest.getConfirmPassword().equals("")) {
            throw new AuthException(AuthError.INVALID_CONFIRM_PASSWORD, "Поле повторите пароля пустое!");
        } else if(!registerRequest.getConfirmPassword().equals(credentials.getPassword())) {
            throw new AuthException(AuthError.INVALID_CONFIRM_PASSWORD, "Поле повторите пароля не совпадает с паролем!");
        }
    }
}
