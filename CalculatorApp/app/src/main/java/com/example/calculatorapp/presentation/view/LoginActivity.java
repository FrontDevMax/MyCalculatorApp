package com.example.calculatorapp.presentation.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculatorapp.R;
import com.example.calculatorapp.data.remote.FirebaseAuthService;
import com.example.calculatorapp.domain.exception.ErrorHandler;
import com.example.calculatorapp.domain.model.LoginRequest;
import com.example.calculatorapp.domain.repository.AuthRepository;
import com.example.calculatorapp.presentation.controller.LoginController;
import com.example.calculatorapp.domain.model.Credentials;
import com.example.calculatorapp.presentation.util.AutoValidation;
import com.example.calculatorapp.presentation.util.LoginPrefsManager;
import com.example.calculatorapp.presentation.validator.LoginValidator;
import com.example.calculatorapp.presentation.validator.ValidationResult;
import com.example.calculatorapp.presentation.validator.Validator;
import com.example.calculatorapp.presentation.validator.PasswordValidator;
import com.example.calculatorapp.presentation.util.ClearTextWatcher;
import com.example.calculatorapp.presentation.util.FieldError;
import com.example.calculatorapp.presentation.util.Field;
import com.example.calculatorapp.presentation.util.ResetInput;
import com.example.calculatorapp.presentation.util.Router;
import com.example.calculatorapp.presentation.validator.EmailValidator;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity implements BackPressHandler {
    private LoginController loginController;
    private Validator<LoginRequest> emailValidator = new EmailValidator<LoginRequest>();
    private Validator<LoginRequest> passwordValidator = new PasswordValidator<LoginRequest>();
    private Validator<LoginRequest> loginValidator = new LoginValidator();
    private ValidationResult email, password, login;
    private ErrorHandler errorHandler;
    private Credentials credentials;
    private ValidationResult result;
    private LoginRequest loginRequest;
    private LoginPrefsManager loginPrefsManager;
    private Router router = new Router(this);
    private TextView textError;
    private TextInputLayout emailInputLayout, passwordInputLayout;
    private TextInputEditText emailInputEditText, passwordInputEditText;
    private CheckBox rememberMe;
    private ImageView passwordToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        initViews();
        initData();
        setupValidation();
        setupTextWatchers();
        setupBackPress(this, true);
        setupLoginPrefsManager();
    }

    private void initViews() {
        emailInputLayout = findViewById(R.id.emailLayout);
        passwordInputLayout = findViewById(R.id.passwordLayout);
        emailInputEditText = findViewById(R.id.emailEditText);
        passwordInputEditText = findViewById(R.id.passwordEditText);
        textError = findViewById(R.id.textError);
        passwordToggle = passwordInputLayout.findViewById(
                com.google.android.material.R.id.text_input_end_icon
        );
        rememberMe = findViewById(R.id.rememberMe);
    }

    private void initData() {
        loginRequest = new LoginRequest("", "");
        credentials = loginRequest.getCredentials();
        AuthRepository authRepo = new FirebaseAuthService();
        loginController = new LoginController(authRepo);
    }

    private void setupLoginPrefsManager() {
        loginPrefsManager = new LoginPrefsManager(this);
        if (loginPrefsManager.isRememberMeChecked()) {
            emailInputEditText.setText(loginPrefsManager.getSavedEmail());
            passwordInputEditText.setText(loginPrefsManager.getSavedPassword());
            rememberMe.setChecked(true);
        }
    }

    private void setupValidation() {
        AutoValidation.<LoginRequest>setup(
                emailInputLayout,
                (value) -> loginRequest.getCredentials().setEmail(value),
                () -> loginRequest,
                emailValidator
        );
        AutoValidation.<LoginRequest>setup(
                passwordInputLayout,
                (value) -> loginRequest.getCredentials().setPassword(value),
                () -> loginRequest,
                passwordValidator
        );
    }

    private void setupTextWatchers() {
        emailInputEditText.addTextChangedListener(new ClearTextWatcher(emailInputLayout, textError, passwordToggle));
        passwordInputEditText.addTextChangedListener(new ClearTextWatcher(passwordInputLayout, textError, passwordToggle));
    }

    private void resetAllErrors() {
        ResetInput.reset(emailInputLayout);
        ResetInput.reset(passwordInputLayout);
        ResetInput.reset(textError);
        ResetInput.reset(passwordToggle);
    }

    private void validateFields() {
        email = emailValidator.validate(loginRequest);
        password = passwordValidator.validate(loginRequest);
        login = loginValidator.validate(loginRequest);
        email.applyResult(emailInputLayout, email);
        password.applyResult(passwordInputLayout, password);
    }

    private void validateLogin() {

        isSuccess();
    }

    private void isSuccess() {
        loginController.login(loginRequest, new AuthRepository.AuthCallback() {
            @Override
            public void onSuccess() {
                loginPrefsManager.saveFields(loginRequest, rememberMe.isChecked());
                router.navigateTo(ScreenWelcomeActivity.class);
            }

            @Override
            public void onError() {
                FieldError.showError(textError, "Нет такого пользователя!");
            }
        });
    }

    public void showCalculator(View view) {
        resetAllErrors();
        loginRequest = new LoginRequest(
                Field.getField(emailInputEditText),
                Field.getField(passwordInputEditText)
        );
        validateFields();
        validateLogin();
            /*loginController.login(loginRequest, new LoginController.AuthCallback() {
                @Override
                public void onSuccess() {
                    router.navigateTo(ScreenWelcomeActivity.class);
                    finish();
                }

                @Override
                public void onError(AuthException exception) {
                    runOnUiThread(() -> {
                        if (exception.getErrorType() == AuthError.LOGIN_FAILED) {
                            DisplayError.showError(textError, "Неверный email или пароль");
                        } else {
                            handleAuthError(exception.getErrorType(), exception.getMessage());
                        }
                    });
                }
            });*/
    }

    public void showRegister(View view) {
        router.navigateTo(RegisterActivity.class);
    }

    public void authGoogle(View view) { /*РЕАЛИЗОВАТЬ */ }

}
