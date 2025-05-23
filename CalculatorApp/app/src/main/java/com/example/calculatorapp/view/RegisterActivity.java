package com.example.calculatorapp.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculatorapp.R;
import com.example.calculatorapp.controller.RegisterController;
import com.example.calculatorapp.enumeration.AuthError;
import com.example.calculatorapp.exception.AuthException;
import com.example.calculatorapp.model.Credentials;
import com.example.calculatorapp.model.RegisterRequest;
import com.example.calculatorapp.util.ClearTextWatcher;
import com.example.calculatorapp.util.DisplayError;
import com.example.calculatorapp.util.Field;
import com.example.calculatorapp.util.ResetInput;
import com.example.calculatorapp.util.Router;
import com.example.calculatorapp.validator.ConfirmPasswordValidator;
import com.example.calculatorapp.validator.EmailValidator;
import com.example.calculatorapp.validator.FieldAuthValidator;
import com.example.calculatorapp.validator.PasswordValidator;
import com.example.calculatorapp.validator.UsernameValidator;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity implements BackPressHandler {
    private RegisterController registerController = new RegisterController();
    private RegisterRequest registerRequest = new RegisterRequest();
    private Credentials credentials;
    private FieldAuthValidator<RegisterRequest> usernameValidator = new UsernameValidator();
    private FieldAuthValidator<Credentials> emailValidator = new EmailValidator();
    private FieldAuthValidator<Credentials> passwordValidator = new PasswordValidator();
    private FieldAuthValidator<RegisterRequest> confirmPasswordValidator = new ConfirmPasswordValidator();
    private Router router = new Router(this);
    private TextInputLayout usernameInputLayout, emailInputLayout, passwordInputLayout, confirmPasswordInputLayout;
    private TextInputEditText usernameInputEditText, emailInputEditText, passwordInputEditText, confirmPasswordInputEditText;
    private ImageView passwordToggle, confirmPasswordToggle;
    private TextView textError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        init();
        setupValidation();
        setupBackPress(this, true);
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
        textError = findViewById(R.id.textError);
        credentials = registerRequest.getCredentials();
        credentials.setEmail("");
        credentials.setPassword("");
        registerRequest.setUsername("");
        registerRequest.setConfirmPassword("");
    }

    private void setupValidation() {
        setupTextWatchers();
        usernameInputLayout.setOnFocusChangeListener((v, hasFocus) -> {
            if(!hasFocus) {
                registerRequest.setUsername(Field.getField(usernameInputEditText));
                ResetInput.reset(usernameInputLayout);
                validateField(usernameValidator, registerRequest);
            }
        });
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
        confirmPasswordInputEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if(!hasFocus) {
                registerRequest.setConfirmPassword(Field.getField(confirmPasswordInputEditText));
                ResetInput.reset(confirmPasswordInputLayout, confirmPasswordToggle);
                validateField(confirmPasswordValidator, registerRequest);
            }
        });
    }

    private void setupTextWatchers() {
        usernameInputEditText.addTextChangedListener(new ClearTextWatcher(usernameInputLayout, textError, passwordToggle));
        emailInputEditText.addTextChangedListener(new ClearTextWatcher(emailInputLayout, textError, passwordToggle));
        passwordInputEditText.addTextChangedListener(new ClearTextWatcher(passwordInputLayout, textError, passwordToggle));
        confirmPasswordInputEditText.addTextChangedListener(new ClearTextWatcher(confirmPasswordInputLayout, textError, confirmPasswordToggle));
    }

    private void validateField(FieldAuthValidator<Credentials> validator, Credentials credentials) {
        try {
            validator.validate(credentials);
        } catch (AuthException ex) {
            handleAuthError(ex.getErrorType(), ex.getMessage());
        }
    }

    private void validateField(FieldAuthValidator<RegisterRequest> validator, RegisterRequest registerRequest) {
        try {
            validator.validate(registerRequest);
        } catch (AuthException ex) {
            handleAuthError(ex.getErrorType(), ex.getMessage());
        }
    }

    public void showCalculator(View view) {
        resetAllErrors();
        try {
            registerRequest.setUsername(Field.getField(usernameInputEditText));
            credentials.setEmail(Field.getField(emailInputEditText));
            credentials.setPassword(Field.getField(passwordInputEditText));
            registerRequest.setConfirmPassword(Field.getField(confirmPasswordInputEditText));
            registerController.register(registerRequest);
            router.navigateTo(ScreenWelcomeActivity.class);
            resetData();
        } catch(AuthException ex) {
            handleAuthError(ex.getErrorType(), ex.getMessage());
        }
    }

    private void resetAllErrors() {
        ResetInput.reset(usernameInputLayout);
        ResetInput.reset(emailInputLayout);
        ResetInput.reset(passwordInputLayout);
        ResetInput.reset(confirmPasswordInputLayout);
        ResetInput.reset(textError);
        ResetInput.reset(passwordToggle);
        ResetInput.reset(confirmPasswordToggle);
    }

    private void handleAuthError(AuthError authError, String message) {
        switch(authError) {
            case INVALID_USERNAME:
                DisplayError.showError(usernameInputLayout, message);
                break;
            case INVALID_EMAIL:
                DisplayError.showError(emailInputLayout, message);
                break;
            case INVALID_PASSWORD:
                DisplayError.showError(passwordInputLayout, passwordToggle, message);
                break;
            case INVALID_CONFIRM_PASSWORD:
                DisplayError.showError(confirmPasswordInputLayout, confirmPasswordToggle, message);
                break;
            default:
                DisplayError.showError(textError, "Что-то пошло не так");
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
