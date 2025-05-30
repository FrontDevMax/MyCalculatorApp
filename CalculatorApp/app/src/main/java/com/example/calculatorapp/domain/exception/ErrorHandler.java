package com.example.calculatorapp.domain.exception;

public class ErrorHandler {
    /*private final Context context;

    public ErrorHandler(Context context) {
        this.context = context;
    }

    public static class Builder {
        private AuthError error;
        private AuthException exception;
        private TextInputLayout usernameLayout, emailLayout, passwordLayout, confirmPasswordLayout;
        private TextView errorText;
        private ImageView passwordToggle;
        private final ErrorHandler handler;

        public Builder(ErrorHandler handler) {
            this.handler = handler;
        }

        public Builder setUsernameLayout(TextInputLayout usernameLayout) {
            this.usernameLayout = usernameLayout;
            return this;
        }

        public Builder setEmailLayout(TextInputLayout emailLayout) {
            this.emailLayout = emailLayout;
            return this;
        }

        public Builder setPasswordLayout(TextInputLayout passwordLayout) {
            this.passwordLayout = passwordLayout;
            return this;
        }

        public Builder setConfirmPasswordLayout(TextInputLayout confirmPasswordLayout) {
            this.confirmPasswordLayout = confirmPasswordLayout;
            return this;
        }

        public Builder setPasswordToggle(ImageView passwordToggle) {
            this.passwordToggle = passwordToggle;
            return this;
        }

        public Builder setTextView(TextView errorText) {
            this.errorText = errorText;
            return this;
        }

        public void handleLogin() {
            handler.handleLoginError(
                    error,
                    exception.getMessage(),
                    emailLayout,
                    passwordLayout,
                    passwordToggle,
                    errorText
            );
        }

        public void handleRegister() {
            handler.handleRegisterError(
                    error,
                    exception.getMessage(),
                    usernameLayout,
                    emailLayout,
                    passwordLayout,
                    confirmPasswordLayout,
                    passwordToggle,
                    errorText
            );
        }
    }

    public Builder builder() {
        return new Builder(this);
    }

    private void handleLoginError(
            AuthError error,
            String message,
            TextInputLayout emailLayout,
            TextInputLayout passwordLayout,
            ImageView passwordToggle,
            TextView errorText
    ) {
        switch(error) {
            case INVALID_EMAIL:
                DisplayError.showError(emailLayout, message);
                break;
            case INVALID_PASSWORD:
                DisplayError.showError(passwordLayout, passwordToggle, message);
                break;
            case LOGIN_FAILED:
                DisplayError.showError(errorText, message);
                break;
        }
    }

    private void handleRegisterError(
            AuthError error,
            String message,
            TextInputLayout usernameLayout,
            TextInputLayout emailLayout,
            TextInputLayout passwordLayout,
            TextInputLayout confirmPasswordLayout,
            ImageView passwordToggle,
            TextView errorText
    ) {
        switch(error) {
            case INVALID_USERNAME:
                DisplayError.showError(usernameLayout, message);
                break;
            case INVALID_EMAIL:
                DisplayError.showError(emailLayout, message);
                break;
            case INVALID_PASSWORD:
                DisplayError.showError(passwordLayout, passwordToggle, message);
                break;
            case INVALID_CONFIRM_PASSWORD:
                DisplayError.showError(confirmPasswordLayout, passwordToggle, message);
                break;
            case REGISTRATION_FAILED:
                DisplayError.showError(errorText, message);
                break;
        }
    }*/
}
