package com.example.calculatorapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculatorapp.R;
import com.example.calculatorapp.controller.LoginController;
import com.example.calculatorapp.enumeration.AuthError;
import com.example.calculatorapp.exception.AuthException;
import com.example.calculatorapp.model.LoginRequest;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    private LoginController loginController = new LoginController();
    private TextView textError;
    private TextInputLayout emailLayout, passwordLayout;
    private TextInputEditText emailEditText, passwordEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        init();
    }

    private void init() {
        emailLayout = findViewById(R.id.emailLayout);
        passwordLayout = findViewById(R.id.passwordLayout);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        textError = findViewById(R.id.textError);
    }

    public void showCalculator(View view) {
        try {
            LoginRequest loginRequest = new LoginRequest(
                    emailEditText.getText().toString(),
                    passwordEditText.getText().toString()
            );
            clearFields();
            loginController.validateSignIn(loginRequest);
            Intent intent = new Intent(this, SplashScreenWelcomeActivity.class);
            startActivity(intent);
        } catch(AuthException ex) {
            handleAuthError(ex.getErrorType(), ex.getMessage());
        }
    }

    private void clearFields() {
        emailLayout.setError(null);
        passwordLayout.setError(null);
    }

    private void handleAuthError(AuthError error, String message) {
        switch(error) {
            case EMAIL:
                emailLayout.setError(message);
                break;
            case PASSWORD:
                passwordLayout.setError(message);
                break;
            case LOGIN:
                textError.setText(message);
                break;
        }
    }

    public void backToRegistration(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void rememberAccount(View view) {

    }

    public void authGoogle(View view) {
        //РЕАЛИЗОВАТЬ
    }
}
