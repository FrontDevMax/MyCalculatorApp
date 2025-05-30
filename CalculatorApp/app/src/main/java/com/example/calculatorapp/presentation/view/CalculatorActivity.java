package com.example.calculatorapp.presentation.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculatorapp.R;
import com.example.calculatorapp.data.repository.HistoryRepositoryImpl;
import com.example.calculatorapp.presentation.controller.CalculatorController;
import com.example.calculatorapp.domain.model.CalculatorModel;
import com.example.calculatorapp.presentation.util.TaskHandler;
import com.example.calculatorapp.domain.repository.HistoryRepository;
import com.example.calculatorapp.domain.task.Task;
import com.example.calculatorapp.domain.task.Task1;
import com.example.calculatorapp.domain.task.Task2;
import com.example.calculatorapp.domain.task.Task6;
import com.example.calculatorapp.domain.task.Task8;
import com.example.calculatorapp.presentation.util.Field;
import com.example.calculatorapp.presentation.util.Logger;
import com.example.calculatorapp.presentation.util.ResetInput;
import com.example.calculatorapp.presentation.util.Router;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Arrays;
import java.util.List;

public class CalculatorActivity extends AppCompatActivity implements BackPressHandler {
    private CalculatorController calculatorController = new CalculatorController();
    private CalculatorModel calculatorModel;
    private Router router = new Router(this);
    private HistoryRepository historyRepository;
    private Spinner spinnerTasks;
    private TextInputEditText startInputEditText, endInputEditText;
    private TextInputLayout startInputLayout, endInputLayout;
    private TextView textError, logs;
    private List<Task> listTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        initViews();
        initData();
        setupBackPress(this, true);
    }

    private void initViews() {
        spinnerTasks = findViewById(R.id.spinnerTasks);
        startInputEditText = findViewById(R.id.startInputEditText);
        endInputEditText = findViewById(R.id.endInputEditText);
        startInputLayout = findViewById(R.id.startInputLayout);
        endInputLayout = findViewById(R.id.endInputLayout);
        textError = findViewById(R.id.textError);
        logs = findViewById(R.id.logs);
    }

    private void initData() {
        historyRepository = new HistoryRepositoryImpl();
        Logger.init(historyRepository);
        Logger.updateLogsView(logs);
    }

    private List<Task> getListTasks() {
        return Arrays.asList(
                new Task1(),
                new Task2(),
                new Task6(),
                new Task8()
        );
    }

    public void showHistory(View view) {
        router.navigateToWithSavedActivity(HistoryActivity.class);
    }

    public void startMethod(View view) {
        resetAllErrors();
            calculatorModel = new CalculatorModel(
                    Field.getField(startInputEditText),
                    Field.getField(endInputEditText)
            );
            calculatorController.validateInput(calculatorModel);
            listTasks = getListTasks();
            int selectedItem = spinnerTasks.getSelectedItemPosition();
            Logger.add("Запуск " + TaskHandler.handleTask(selectedItem));
            Logger.add("Диапазон от " + calculatorModel.getStartNum() + " до " + calculatorModel.getEndNum());
            Logger.add("Поиск запущен");
            showTask(listTasks.get(selectedItem));
            Logger.add("Поиск завершен");
            Logger.updateLogsView(logs);
    }

    private void resetAllErrors() {
        ResetInput.reset(textError);
        ResetInput.reset(startInputLayout);
        ResetInput.reset(endInputLayout);
    }

    private void showTask(Task task) {
        String first = Field.getField(startInputEditText);
        String last = Field.getField(endInputEditText);
        task.runTask(first, last);
    }

    public void clearFields(View view) {
        ResetInput.reset(startInputEditText);
        ResetInput.reset(endInputEditText);
    }

}
