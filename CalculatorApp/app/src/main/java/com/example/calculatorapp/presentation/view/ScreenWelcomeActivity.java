package com.example.calculatorapp.presentation.view;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculatorapp.R;
import com.example.calculatorapp.presentation.util.Router;

public class ScreenWelcomeActivity extends AppCompatActivity {
    private Router router = new Router(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_welcome);
        new Handler().postDelayed(() -> {
            router.navigateTo(CalculatorActivity.class);
        }, 1500);
    }
}
