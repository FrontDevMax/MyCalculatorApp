package com.example.calculatorapp.domain.repository;

import com.example.calculatorapp.domain.model.LoginRequest;
import com.example.calculatorapp.domain.model.RegisterRequest;

public interface AuthRepository {
    void login(LoginRequest request, AuthCallback callback);
    void register(RegisterRequest request, AuthCallback callback);

    interface AuthCallback {
        void onSuccess();
        void onError();
    }
}
