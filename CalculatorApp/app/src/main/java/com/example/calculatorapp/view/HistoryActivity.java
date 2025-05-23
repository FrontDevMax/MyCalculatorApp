package com.example.calculatorapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculatorapp.R;
import com.example.calculatorapp.util.Router;

public class HistoryActivity extends AppCompatActivity implements BackPressHandler {
    private Router router = new Router(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);
        setupBackPress(this, true);
    }

    public void backToCalculator(View view) {
        router.navigateToWithSavedActivity(CalculatorActivity.class);
    }
}
