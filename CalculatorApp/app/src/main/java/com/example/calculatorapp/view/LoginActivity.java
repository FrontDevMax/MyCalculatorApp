package com.example.calculatorapp.view;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.calculatorapp.R;
import com.example.calculatorapp.controller.LoginController;
import com.example.calculatorapp.enumeration.AuthError;
import com.example.calculatorapp.exception.AuthException;
import com.example.calculatorapp.model.LoginRequest;
import com.example.calculatorapp.util.Router;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity implements BackPressHandler {
    private LoginController loginController = new LoginController();
    private Router router = new Router(this);
    private TextView textError;
    private TextInputLayout emailInputLayout, passwordInputLayout;
    private TextInputEditText emailInputEditText, passwordInputEditText;
    private ImageView passwordToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        init();
        setupBackPress(this, true);
    }

    private void init() {
        emailInputLayout = findViewById(R.id.emailLayout);
        passwordInputLayout = findViewById(R.id.passwordLayout);
        emailInputEditText = findViewById(R.id.emailEditText);
        passwordInputEditText = findViewById(R.id.passwordEditText);
        textError = findViewById(R.id.textError);
        passwordToggle = passwordInputLayout.findViewById(
                com.google.android.material.R.id.text_input_end_icon
        );
    }

    public void showCalculator(View view) {
        try {
            resetFields();
            LoginRequest loginRequest = new LoginRequest(
                    emailInputEditText.getText().toString(),
                    passwordInputEditText.getText().toString()
            );
            loginController.validateLogin(loginRequest);
            router.navigateTo(ScreenWelcomeActivity.class);
        } catch(AuthException ex) {
            handleAuthError(ex.getErrorType(), ex.getMessage());
        }
    }

    private void resetFields() {
        emailInputLayout.setError(null);
        passwordInputLayout.setError(null);
        emailInputLayout.setErrorEnabled(false);
        passwordInputLayout.setErrorEnabled(false);
        passwordToggle.setColorFilter(ContextCompat.getColor(this, R.color.darkGreen));
        textError.setText("");
    }

    private void handleAuthError(AuthError error, String message) {
        switch(error) {
            case EMAIL:
                emailInputLayout.setError(message);
                break;
            case PASSWORD:
                passwordInputLayout.setError(message);
                passwordToggle.setColorFilter(
                        ContextCompat.getColor(this, R.color.red)
                );
                break;
            case LOGIN:
                textError.setText(message);
                break;
        }
    }

    public void showRegister(View view) {
        router.navigateTo(RegisterActivity.class);
    }

    public void rememberAccount(View view) {

    }

    public void authGoogle(View view) {
        //РЕАЛИЗОВАТЬ
    }
}
