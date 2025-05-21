package com.example.calculatorapp.view;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
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
import com.example.calculatorapp.util.ResetAuthInput;
import com.example.calculatorapp.util.Router;
import com.example.calculatorapp.validator.LoginValidator;
import com.example.calculatorapp.validator.FieldValidator;
import com.example.calculatorapp.util.Router;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity implements BackPressHandler {
    private LoginController loginController = new LoginController();
    private LoginValidator loginValidator = new LoginValidator();
    private LoginRequest loginRequest = new LoginRequest();
    private Router router = new Router(this);
    private TextView textError;
    private TextInputLayout emailInputLayout, passwordInputLayout;
    private TextInputEditText emailInputEditText, passwordInputEditText;
    private ImageView passwordToggle;
    private Button btnAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        init();
        setupValidation();
        setupBackPress(this, true);
        setupButtonState();
    }

    private void setupValidation() {
        emailInputEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if(!hasFocus) {
                ResetAuthInput.resetEmail(emailInputLayout);
                loginRequest.setEmail(emailInputEditText.getText().toString().trim());
                //loginController.validateLogin();
            }
        });
        passwordInputEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if(!hasFocus) {
                ResetAuthInput.resetPassword(passwordInputLayout, passwordToggle);
                loginRequest.setPassword(passwordInputEditText.getText().toString().trim());
                //validateCurrentField(AuthError.PASSWORD, loginRequest.getPassword(), passwordValidator);
            }
        });
        setupBackPress(this, true);
    }

//    private void validateCurrentField() {
//        try {
//            loginValidator.validateEmail();
//        } catch (AuthException ex) {
//            resetFields();
//            loginController.validateLogin(loginRequest);
//            router.navigateTo(ScreenWelcomeActivity.class);
//        }
//    }

    private void init() {
        emailInputLayout = findViewById(R.id.emailLayout);
        passwordInputLayout = findViewById(R.id.passwordLayout);
        emailInputEditText = findViewById(R.id.emailEditText);
        passwordInputEditText = findViewById(R.id.passwordEditText);
        textError = findViewById(R.id.textError);
        passwordToggle = passwordInputLayout.findViewById(
                com.google.android.material.R.id.text_input_end_icon
        );
        btnAuth = findViewById(R.id.btnAuth);
    }

    private void setupButtonState() {
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //btnAuth.setEnabled(isLoginValid());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };
        emailInputEditText.addTextChangedListener(textWatcher);
        passwordInputEditText.addTextChangedListener(textWatcher);
    }

    public void showCalculator(View view) {
        setupValidation();
        router.navigateTo(ScreenWelcomeActivity.class);
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
