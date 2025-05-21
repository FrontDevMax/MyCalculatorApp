package com.example.calculatorapp.controller;

import com.example.calculatorapp.exception.AuthException;
import com.example.calculatorapp.model.RegisterRequest;
<<<<<<< HEAD

public class RegisterController {
    public void validateRegister(RegisterRequest registerRequest) throws AuthException {
//        AuthValidator.validateUsername(registerRequest.getUsername());
//        AuthValidator.validateEmail(registerRequest.getEmail());
//        AuthValidator.validatePassword(registerRequest.getPassword());
//        AuthValidator.validateConfirmPassword(
//                registerRequest.getPassword(),
//                registerRequest.getConfirmPassword()
//        );
=======
import com.example.calculatorapp.validator.AuthValidator;

public class RegisterController {
    public void validateRegister(RegisterRequest registerRequest) throws AuthException {
        AuthValidator.validateUsername(registerRequest.getUsername());
        AuthValidator.validateEmail(registerRequest.getEmail());
        AuthValidator.validatePassword(registerRequest.getPassword());
        AuthValidator.validateConfirmPassword(
                registerRequest.getPassword(),
                registerRequest.getConfirmPassword()
        );
>>>>>>> 762fa47b2cdb5880465c82ad77ed8758b6f7307f
    }
}
