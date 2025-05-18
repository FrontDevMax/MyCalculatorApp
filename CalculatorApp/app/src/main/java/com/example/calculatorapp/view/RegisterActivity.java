package com.example.calculatorapp.view;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.calculatorapp.R;
import com.example.calculatorapp.controller.RegisterController;
import com.example.calculatorapp.enumeration.AuthError;
import com.example.calculatorapp.exception.AuthException;
import com.example.calculatorapp.model.RegisterRequest;
import com.example.calculatorapp.util.Router;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity implements BackPressHandler {
    private RegisterController registerController = new RegisterController();
    private Router router = new Router(this);
    private TextInputLayout usernameInputLayout, emailInputLayout, passwordInputLayout, confirmPasswordInputLayout;
    private TextInputEditText usernameInputEditText, emailInputEditText, passwordInputEditText, confirmPasswordInputEditText;
    private ImageView passwordToggle, confirmPasswordToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        init();
    }

    private void init() {
        usernameInputLayout = findViewById(R.id.usernameInputLayout);
        emailInputLayout = findViewById(R.id.emailInputLayout);
        passwordInputLayout = findViewById(R.id.passwordInputLayout);
        confirmPasswordInputLayout = findViewById(R.id.confirmPasswordInputLayout);
        usernameInputEditText = findViewById(R.id.usernameInputEditText);
        emailInputEditText = findViewById(R.id.emailInputEditText);
        passwordInputEditText = findViewById(R.id.passwordInputEditText);
        confirmPasswordInputEditText = findViewById(R.id.confirmPasswordInputEditText);
        passwordToggle = passwordInputLayout.findViewById(com.google.android.material.R.id.text_input_end_icon);
        confirmPasswordToggle = confirmPasswordInputLayout.findViewById(com.google.android.material.R.id.text_input_end_icon);
    }

    public void showCalculator(View view) {
        try {
            RegisterRequest registerRequest = new RegisterRequest(
                    usernameInputEditText.getText().toString(),
                    emailInputEditText.getText().toString(),
                    passwordInputEditText.getText().toString(),
                    confirmPasswordInputEditText.getText().toString()
            );
            resetFields();
            registerController.validateRegister(registerRequest);
            router.navigateTo(ScreenWelcomeActivity.class);
            resetData();
        } catch(AuthException ex) {
            handleAuthError(ex.getErrorType(), ex.getMessage());
        }
    }

    private void resetFields() {
        usernameInputLayout.setError(null);
        emailInputLayout.setError(null);
        passwordInputLayout.setError(null);
        confirmPasswordInputLayout.setError(null);
        usernameInputLayout.setErrorEnabled(false);
        emailInputLayout.setErrorEnabled(false);
        passwordInputLayout.setErrorEnabled(false);
        confirmPasswordInputLayout.setErrorEnabled(false);
        passwordToggle.setColorFilter(ContextCompat.getColor(this, R.color.darkGreen));
        confirmPasswordToggle.setColorFilter(ContextCompat.getColor(this, R.color.darkGreen));
    }

    private void handleAuthError(AuthError authError, String message) {
        switch(authError) {
            case USERNAME:
                usernameInputLayout.setError(message);
                break;
            case EMAIL:
                emailInputLayout.setError(message);
                break;
            case PASSWORD:
                passwordInputLayout.setError(message);
                passwordToggle.setColorFilter(
                        ContextCompat.getColor(this, R.color.red)
                );
                break;
            case CONFIRM_PASSWORD:
                confirmPasswordInputLayout.setError(message);
                confirmPasswordToggle.setColorFilter(
                        ContextCompat.getColor(this, R.color.red)
                );
                break;
        }
    }

    public void resetData() {
        usernameInputEditText.setText("");
        emailInputEditText.setText("");
        passwordInputEditText.setText("");
        confirmPasswordInputEditText.setText("");
    }

    public void backToLogin(View view) {
        router.navigateTo(LoginActivity.class);
    }
}
