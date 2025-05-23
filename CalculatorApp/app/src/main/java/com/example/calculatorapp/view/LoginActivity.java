package com.example.calculatorapp.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculatorapp.R;
import com.example.calculatorapp.controller.LoginController;
import com.example.calculatorapp.enumeration.AuthError;
import com.example.calculatorapp.exception.AuthException;
import com.example.calculatorapp.model.Credentials;
import com.example.calculatorapp.model.LoginRequest;
import com.example.calculatorapp.util.ClearTextWatcher;
import com.example.calculatorapp.util.DisplayError;
import com.example.calculatorapp.util.Field;
import com.example.calculatorapp.util.ResetInput;
import com.example.calculatorapp.util.Router;
import com.example.calculatorapp.validator.EmailValidator;
import com.example.calculatorapp.validator.FieldAuthValidator;
import com.example.calculatorapp.validator.PasswordValidator;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity implements BackPressHandler {
    private LoginController loginController = new LoginController();
    private LoginRequest loginRequest = new LoginRequest();
    private FieldAuthValidator<Credentials> emailValidator = new EmailValidator();
    private FieldAuthValidator<Credentials> passwordValidator = new PasswordValidator();
    private Credentials credentials;
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
        setupValidation();
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
        credentials = loginRequest.getCredentials();
        credentials.setEmail("");
        credentials.setPassword("");
    }

    private void setupValidation() {
        setupTextWatchers();
        emailInputEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if(!hasFocus) {
                credentials.setEmail(Field.getField(emailInputEditText));
                ResetInput.reset(emailInputLayout);
                validateField(emailValidator, credentials);
            }
        });
        passwordInputEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if(!hasFocus) {
                credentials.setPassword(Field.getField(passwordInputEditText));
                ResetInput.reset(passwordInputLayout, passwordToggle);
                validateField(passwordValidator, credentials);
            }
        });
    }

    private void setupTextWatchers() {
        emailInputEditText.addTextChangedListener(new ClearTextWatcher(emailInputLayout, textError, passwordToggle));
        passwordInputEditText.addTextChangedListener(new ClearTextWatcher(passwordInputLayout, textError, passwordToggle));
    }

    private void validateField(FieldAuthValidator<Credentials> validator, Credentials credentials) {
        try {
            validator.validate(credentials);
        } catch (AuthException ex) {
            handleAuthError(ex.getErrorType(), ex.getMessage());
        }
    }

    private void handleAuthError(AuthError error, String message) {
        switch(error) {
            case INVALID_EMAIL:
                DisplayError.showError(emailInputLayout, message);
                break;
            case INVALID_PASSWORD:
                DisplayError.showError(passwordInputLayout, passwordToggle, message);
                break;
            case INVALID_LOGIN:
                DisplayError.showError(textError, message);
                break;
            default:
                DisplayError.showError(textError, "Ошибка авторизации");
                break;
        }
    }

    public void showCalculator(View view) {
        ResetInput.reset(emailInputLayout);
        ResetInput.reset(passwordInputLayout);
        ResetInput.reset(textError);
        ResetInput.reset(passwordToggle);
        try {
            credentials.setEmail(Field.getField(emailInputEditText));
            credentials.setPassword(Field.getField(passwordInputEditText));
            loginController.login(loginRequest);
            router.navigateTo(ScreenWelcomeActivity.class);
        } catch (AuthException ex) {
            handleAuthError(ex.getErrorType(), ex.getMessage());
        }
    }

    public void showRegister(View view) {
        router.navigateTo(RegisterActivity.class);
    }

    public void rememberAccount(View view) {}

    public void authGoogle(View view) { /*РЕАЛИЗОВАТЬ */ }

}
