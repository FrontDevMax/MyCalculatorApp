package com.example.calculatorapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculatorapp.R;
import com.example.calculatorapp.controller.SignInController;
import com.example.calculatorapp.enumeration.ErrorType;
import com.example.calculatorapp.exception.AuthException;
import com.example.calculatorapp.model.SignInData;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignInActivity extends AppCompatActivity {
    private SignInController signInController = new SignInController();
    private TextInputLayout emailLayout, passwordLayout;
    private TextInputEditText emailEditText, passwordEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
        init();
    }

    private void init() {
        emailLayout = findViewById(R.id.emailLayout);
        passwordLayout = findViewById(R.id.passwordLayout);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
    }

    public void showCalculator(View view) {
        try {
            SignInData signInData = new SignInData(
                    emailEditText.getText().toString(),
                    passwordEditText.getText().toString()
            );
            emailLayout.setError(null);
            passwordLayout.setError(null);
            signInController.validateFields(signInData);
            Intent intent = new Intent(this, CalculatorActivity.class);
            startActivity(intent);
        } catch(AuthException ex) {
            handleAuthError(ex.getErrorType(), ex.getMessage());
        }
    }

    private void handleAuthError(ErrorType error, String message) {
        switch(error) {
            case EMAIL:
                emailLayout.setError(message);
                break;
            case PASSWORD:
                passwordLayout.setError(message);
                break;
            case SIGNIN:

        }
    }

    public void backToRegistration(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    public void rememberAccount(View view) {

    }

    public void authGoogle(View view) {
        //РЕАЛИЗОВАТЬ
    }
}
