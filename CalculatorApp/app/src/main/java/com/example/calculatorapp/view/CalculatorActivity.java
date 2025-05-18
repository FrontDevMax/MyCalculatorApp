package com.example.calculatorapp.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.calculatorapp.R;
import com.example.calculatorapp.controller.CalculatorController;
import com.example.calculatorapp.enumeration.NumError;
import com.example.calculatorapp.exception.NumException;
import com.example.calculatorapp.model.CalculatorModel;
import com.example.calculatorapp.task.Task;
import com.example.calculatorapp.task.Task1;
import com.example.calculatorapp.task.Task2;
import com.example.calculatorapp.task.Task6;
import com.example.calculatorapp.task.Task8;
import com.example.calculatorapp.util.Router;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Arrays;
import java.util.List;

public class CalculatorActivity extends AppCompatActivity implements BackPressHandler {
    private CalculatorController calculatorController = new CalculatorController();
    private Router router = new Router(this);
    private Spinner spinnerTasks;
    private TextInputEditText startInputEditText, endInputEditText;
    private TextInputLayout startInputLayout, endInputLayout;
    private TextView textError, logs;
    private List<Task> listTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        init();
    }

    private void init() {
        spinnerTasks = findViewById(R.id.spinnerTasks);
        startInputEditText = findViewById(R.id.startInputEditText);
        endInputEditText = findViewById(R.id.endInputEditText);
        startInputLayout = findViewById(R.id.startInputLayout);
        endInputLayout = findViewById(R.id.endInputLayout);
        textError = findViewById(R.id.textError);
        logs = findViewById(R.id.logs);
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
        try {
            CalculatorModel calculatorModel = new CalculatorModel(
                    String.valueOf(startInputEditText.getText()),
                    String.valueOf(endInputEditText.getText())
            );
            calculatorController.validateInput(calculatorModel);
            listTasks = getListTasks();
//            int selectItem = spinnerTasks.getSelectedItemPosition();
//            showTask(listTasks.get(selectItem - 1));
        } catch(NumException ex) {
            handleNumError(ex.getNumError(), ex.getMessage());
        }
    }

    private void resetFields() {
        textError.setText("");
        startInputLayout.setBoxStrokeColor(ContextCompat.getColor(this, R.color.darkGreen));
        endInputLayout.setBoxStrokeColor(ContextCompat.getColor(this, R.color.darkGreen));
    }

    private void handleNumError(NumError numError, String message) {
        switch(numError) {
            case EMPTY_START:
                textError.setText(message);
                startInputLayout.setErrorEnabled(true);
            case LIMIT_START:
                textError.setText(message);
            case EMPTY_END:
                textError.setText(message);
            case LIMIT_END:
                textError.setText(message);
        }
    }

    private void showTask(Task task) {
        int start = Integer.parseInt(String.valueOf(startInputEditText.getText()));
        int end = Integer.parseInt(String.valueOf(endInputEditText.getText()));
        task.runTask(start, end);
    }

    public void clearFields(View view) {
        startInputEditText.setText("");
        endInputEditText.setText("");
    }

}
