package com.example.calculatorapp.presentation.view;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculatorapp.R;
import com.example.calculatorapp.data.repository.HistoryRepositoryImpl;
import com.example.calculatorapp.domain.repository.HistoryRepository;
import com.example.calculatorapp.presentation.util.Logger;

public class HistoryActivity extends AppCompatActivity implements BackPressHandler {
    private HistoryRepository historyRepository;
    private TextView logs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);
        setupBackPress(this, true);
        initViews();
        initData();
    }

    private void initViews() {
        logs = findViewById(R.id.logs);
    }

    private void initData() {
        historyRepository = new HistoryRepositoryImpl();
        Logger.init(historyRepository);
        Logger.updateLogsView(logs);
    }

    public void clearLogs(View view) {
        Logger.deleteLogsView(logs);
    }

    public void backToCalculator(View view) {
        finish();
    }
}
