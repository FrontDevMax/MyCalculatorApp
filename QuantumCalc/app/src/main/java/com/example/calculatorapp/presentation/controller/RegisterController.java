package com.example.calculatorapp.presentation.controller;

import com.example.calculatorapp.domain.model.RegisterRequest;
import com.example.calculatorapp.domain.repository.AuthRepository;

public class RegisterController {
    private final AuthRepository authRepository;

    public RegisterController(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public void register(RegisterRequest registerRequest, AuthRepository.AuthCallback callback) {
        authRepository.register(registerRequest, callback);
    }
}
