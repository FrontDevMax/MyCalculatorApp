package com.example.calculatorapp.presentation.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculatorapp.R;

public class ScreenWelcomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_welcome);
        new Handler().postDelayed(() -> {
            startActivity(new Intent(this, CalculatorActivity.class));
            finish();
        }, 1500);
    }
}
