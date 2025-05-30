package com.example.calculatorapp.presentation.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculatorapp.R;
import com.example.calculatorapp.data.remote.FirebaseAuthService;
import com.example.calculatorapp.domain.model.Credentials;
import com.example.calculatorapp.domain.repository.AuthRepository;
import com.example.calculatorapp.presentation.controller.LoginController;
import com.example.calculatorapp.presentation.controller.RegisterController;
import com.example.calculatorapp.domain.model.RegisterRequest;
import com.example.calculatorapp.presentation.util.AutoValidation;
import com.example.calculatorapp.presentation.util.FieldError;
import com.example.calculatorapp.presentation.validator.ConfirmPasswordValidator;
import com.example.calculatorapp.presentation.validator.EmailValidator;
import com.example.calculatorapp.presentation.validator.ValidationResult;
import com.example.calculatorapp.presentation.validator.Validator;
import com.example.calculatorapp.presentation.validator.PasswordValidator;
import com.example.calculatorapp.presentation.validator.UsernameValidator;
import com.example.calculatorapp.presentation.util.ClearTextWatcher;
import com.example.calculatorapp.presentation.util.Field;
import com.example.calculatorapp.presentation.util.ResetInput;
import com.example.calculatorapp.presentation.util.Router;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity implements BackPressHandler {
    private RegisterController registerController;
    private RegisterRequest registerRequest;
    private Credentials credentials;
    private Validator<RegisterRequest> usernameValidator = new UsernameValidator();
    private Validator<RegisterRequest> emailValidator = new EmailValidator<RegisterRequest>();
    private Validator<RegisterRequest> passwordValidator = new PasswordValidator<RegisterRequest>();
    private Validator<RegisterRequest> confirmPasswordValidator = new ConfirmPasswordValidator();
    private ValidationResult username, email, password, confirmPassword, register;
    private Router router = new Router(this);
    private TextInputLayout usernameInputLayout, emailInputLayout, passwordInputLayout, confirmPasswordInputLayout;
    private TextInputEditText usernameInputEditText, emailInputEditText, passwordInputEditText, confirmPasswordInputEditText;
    private ImageView passwordToggle, confirmPasswordToggle;
    private TextView textError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        initViews();
        initData();
        setupTextWatchers();
        setupValidation();
        setupBackPress(this, true);
    }

    private void initViews() {
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
    }

    private void initData() {
        registerRequest = new RegisterRequest("", "", "", "");
        credentials = registerRequest.getCredentials();
        AuthRepository authRepo = new FirebaseAuthService();
        registerController = new RegisterController(authRepo);
    }

    private void setupValidation() {
        AutoValidation.<RegisterRequest>setup(
                usernameInputLayout,
                (value) -> registerRequest.setUsername(value),
                () -> registerRequest,
                usernameValidator
        );
        AutoValidation.<RegisterRequest>setup(
                emailInputLayout,
                (value) -> registerRequest.getCredentials().setEmail(value),
                () -> registerRequest,
                emailValidator
        );
        AutoValidation.<RegisterRequest>setup(
                passwordInputLayout,
                (value) -> registerRequest.getCredentials().setPassword(value),
                () -> registerRequest,
                passwordValidator
        );
        AutoValidation.<RegisterRequest>setup(
                confirmPasswordInputLayout,
                (value) -> registerRequest.setConfirmPassword(value),
                () -> registerRequest,
                confirmPasswordValidator
        );
    }

    private void setupTextWatchers() {
        usernameInputEditText.addTextChangedListener(new ClearTextWatcher(usernameInputLayout, textError, passwordToggle));
        emailInputEditText.addTextChangedListener(new ClearTextWatcher(emailInputLayout, textError, passwordToggle));
        passwordInputEditText.addTextChangedListener(new ClearTextWatcher(passwordInputLayout, textError, passwordToggle));
        confirmPasswordInputEditText.addTextChangedListener(new ClearTextWatcher(confirmPasswordInputLayout, textError, confirmPasswordToggle));
    }

    private void validateFields() {
        username = usernameValidator.validate(registerRequest);
        email = emailValidator.validate(registerRequest);
        password = passwordValidator.validate(registerRequest);
        confirmPassword = confirmPasswordValidator.validate(registerRequest);
        username.applyResult(usernameInputLayout, username);
        email.applyResult(emailInputLayout, email);
        password.applyResult(passwordInputLayout, password);
        confirmPassword.applyResult(confirmPasswordInputLayout, confirmPassword);
    }

    private void validateRegister() {
        if(username.isValid() && email.isValid() && password.isValid() && confirmPassword.isValid()) {
            isSuccess();
        }
    }

    private void isSuccess() {
        registerController.register(registerRequest, new AuthRepository.AuthCallback() {
            @Override
            public void onSuccess() {
                router.navigateTo(ScreenWelcomeActivity.class);
            }

            @Override
            public void onError() {
                FieldError.showError(textError, "Этот аккаунт существует");
            }
        });
    }

    public void showCalculator(View view) {
        resetAllErrors();
        registerRequest = new RegisterRequest(
                Field.getField(usernameInputEditText),
                Field.getField(emailInputEditText),
                Field.getField(passwordInputEditText),
                Field.getField(confirmPasswordInputEditText)
        );
        validateFields();
        validateRegister();
        /*registerController.register(registerRequest, new RegisterController.AuthCallback() {
            @Override
            public void onSuccess() {
                runOnUiThread(() -> {
                    router.navigateTo(ScreenWelcomeActivity.class);
                    resetData();
                });
            }

            @Override
            public void onError(AuthException exception) {
                runOnUiThread(() -> handleAuthError(exception.getErrorType(), exception.getMessage()));
            }
        });*/
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
