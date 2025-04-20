package com.example.calculatorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
//        TextView linkTextLogin = findViewById(R.id.linkTextLogin);
//        linkTextLogin.setOnClickListener(v -> {
//            Intent intent = new Intent(this, LoginActivity.class);
//            startActivity(intent);
//        });
    }

    public void showCalculator(View view) {
        Intent intent = new Intent(this, CalculatorActivity.class);
        startActivity(intent);
    }

    public void backToLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
