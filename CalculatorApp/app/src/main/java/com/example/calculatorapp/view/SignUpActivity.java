package com.example.calculatorapp.view;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculatorapp.R;
import com.example.calculatorapp.controller.SignUpController;
import com.example.calculatorapp.enumeration.ErrorType;
import com.example.calculatorapp.exception.AuthException;
import com.example.calculatorapp.model.SignUpData;
import com.example.calculatorapp.repository.UserRepo;
import com.example.calculatorapp.utils.DatabaseHelper;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignUpActivity extends AppCompatActivity {
    private SignUpController signUpController = new SignUpController();
    private TextInputLayout usernameLayout, emailLayout, passwordLayout, confirmPasswordLayout;
    private TextInputEditText usernameEditText, emailEditText, passwordEditText, confirmPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
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
            SignUpData signUpData = new SignUpData(
                    usernameEditText.getText().toString(),
                    emailEditText.getText().toString(),
                    passwordEditText.getText().toString(),
                    confirmPasswordEditText.getText().toString()
            );
            resetFields();
            signUpController.validateUsername(signUpData);
            signUpController.validateEmail(signUpData);
            signUpController.validatePassword(signUpData);
            //signUpController.validateConfirmPassword(signUpData);

            UserRepo userRepo = new UserRepo(new DatabaseHelper(this));
            userRepo.registerUser(signUpData);

//            Intent intent = new Intent(this, SplashScreenWelcomeActivity.class);
//            startActivity(intent);
        } catch(AuthException ex) {
            Log.e("SQL", "ОШИБКА");
            handleAuthError(ex.getErrorType(), ex.getMessage());
        }
    }

    private void resetFields() {
        usernameLayout.setError(null);
        emailLayout.setError(null);
        passwordLayout.setError(null);
        confirmPasswordLayout.setError(null);
    }

    private void handleAuthError(ErrorType errorType, String message) {
        switch(errorType) {
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
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
    }
}
