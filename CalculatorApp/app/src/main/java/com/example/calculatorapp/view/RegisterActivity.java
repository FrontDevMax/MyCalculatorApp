package com.example.calculatorapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculatorapp.R;
import com.example.calculatorapp.controller.RegisterController;
import com.example.calculatorapp.enumeration.AuthError;
import com.example.calculatorapp.exception.AuthException;
import com.example.calculatorapp.model.RegisterRequest;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {
    private RegisterController registerController = new RegisterController();
    private TextInputLayout usernameLayout, emailLayout, passwordLayout, confirmPasswordLayout;
    private TextInputEditText usernameEditText, emailEditText, passwordEditText, confirmPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        init();
    }

    private void init() {
        usernameLayout = findViewById(R.id.usernameLayout);
        emailLayout = findViewById(R.id.emailLayout);
        passwordLayout = findViewById(R.id.passwordLayout);
        confirmPasswordLayout = findViewById(R.id.confirmPasswordLayout);
        usernameEditText = findViewById(R.id.usernameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
    }

    public void showCalculator(View view) {
        try {
            RegisterRequest registerRequest = new RegisterRequest(
                    usernameEditText.getText().toString(),
                    emailEditText.getText().toString(),
                    passwordEditText.getText().toString(),
                    confirmPasswordEditText.getText().toString()
            );
            clearFields();
            registerController.validateRegister(registerRequest);
            Intent intent = new Intent(this, SplashScreenWelcomeActivity.class);
            startActivity(intent);
        } catch(AuthException ex) {
            handleAuthError(ex.getErrorType(), ex.getMessage());
        }
    }

    private void clearFields() {
        usernameLayout.setError(null);
        emailLayout.setError(null);
        passwordLayout.setError(null);
        confirmPasswordLayout.setError(null);
    }

    private void handleAuthError(AuthError authError, String message) {
        switch(authError) {
            case USERNAME:
                usernameLayout.setError(message);
                break;
            case EMAIL:
                emailLayout.setError(message);
                break;
            case PASSWORD:
                passwordLayout.setError(message);
                break;
            case CONFIRM_PASSWORD:
                confirmPasswordLayout.setError(message);
                break;
        }
    }

    public void backToLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
