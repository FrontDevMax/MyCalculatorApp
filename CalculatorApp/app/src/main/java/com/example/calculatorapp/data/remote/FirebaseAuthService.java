package com.example.calculatorapp.data.remote;

import com.example.calculatorapp.domain.model.LoginRequest;
import com.example.calculatorapp.domain.model.RegisterRequest;
import com.example.calculatorapp.domain.repository.AuthRepository;
import com.google.firebase.auth.FirebaseAuth;

public class FirebaseAuthService implements AuthRepository {
    private final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    @Override
    public void login(LoginRequest loginRequest, AuthCallback callback) {
        firebaseAuth.signInWithEmailAndPassword(
                loginRequest.getCredentials().getEmail(),
                loginRequest.getCredentials().getPassword()
        ).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                callback.onSuccess();
            } else {
                callback.onError();
            }
        });
    }

    @Override
    public void register(RegisterRequest registerRequest, AuthCallback callback) {
        firebaseAuth.createUserWithEmailAndPassword(
                registerRequest.getCredentials().getEmail(),
                registerRequest.getCredentials().getPassword()
        ).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                callback.onSuccess();
            } else {
                callback.onError();
            }
        });
    }
}