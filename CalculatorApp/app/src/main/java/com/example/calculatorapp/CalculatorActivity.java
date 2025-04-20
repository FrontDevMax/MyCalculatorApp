package com.example.calculatorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
    }

    public void showHistory(View view) {
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }

    public void startMethod(View view) {

    }

    public void cleanFields(View view) {

    }

    public void selectTask1(View view) {

    }

    public void selectTask2(View view) {

    }

    public void selectTask3(View view) {

    }

    public void selectTask4(View view) {

    }
}
