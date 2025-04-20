package com.example.calculatorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class HistoryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);
    }

    public void backToCalculator(View view) {
        Intent intent = new Intent(this, CalculatorActivity.class);
        startActivity(intent);
    }
}
