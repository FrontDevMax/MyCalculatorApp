package com.example.calculatorapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculatorapp.R;

public class ScreenMainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_main);
        new Handler().postDelayed(() -> {
           startActivity(new Intent(this, LoginActivity.class));
           finish();
        }, 2000);
    }
}
