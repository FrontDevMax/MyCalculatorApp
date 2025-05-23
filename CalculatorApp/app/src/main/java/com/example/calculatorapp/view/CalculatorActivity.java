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
import com.example.calculatorapp.util.DisplayError;
import com.example.calculatorapp.util.Field;
import com.example.calculatorapp.util.Logger;
import com.example.calculatorapp.util.ResetInput;
import com.example.calculatorapp.util.Router;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class CalculatorActivity extends AppCompatActivity implements BackPressHandler {
    private CalculatorController calculatorController = new CalculatorController();
    private CalculatorModel calculatorModel = new CalculatorModel();
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
        setupBackPress(this, true);
    }

    private void init() {
        spinnerTasks = findViewById(R.id.spinnerTasks);
        startInputEditText = findViewById(R.id.startInputEditText);
        endInputEditText = findViewById(R.id.endInputEditText);
        startInputLayout = findViewById(R.id.startInputLayout);
        endInputLayout = findViewById(R.id.endInputLayout);
        textError = findViewById(R.id.textError);
        logs = findViewById(R.id.logs);
        calculatorModel.setStartNum("");
        calculatorModel.setEndNum("");
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
        try {
            calculatorModel.setStartNum(Field.getField(startInputEditText));
            calculatorModel.setEndNum(Field.getField(endInputEditText));
            calculatorController.validateInput(calculatorModel);
            listTasks = getListTasks();
            int selectedItem = spinnerTasks.getSelectedItemPosition();
            showTask(listTasks.get(selectedItem));
        } catch(NumException ex) {
            handleNumError(ex.getNumError(), ex.getMessage());
        }
    }

    private void resetAllErrors() {
        ResetInput.reset(textError);
        ResetInput.reset(startInputLayout);
        ResetInput.reset(endInputLayout);
    }

    private void handleNumError(NumError numError, String message) {
        switch(numError) {
            case INVALID_START_NUM:
                DisplayError.showError(textError, message);
                DisplayError.showError(startInputLayout, " ");
                break;
            case INVALID_END_NUM:
                DisplayError.showError(textError, message);
                DisplayError.showError(endInputLayout, " ");
                break;
            default:
                DisplayError.showError(textError, "Что-то пошло не так");
                break;
        }
    }

    private void showTask(Task task) {
        String first = Field.getField(startInputEditText);
        String last = Field.getField(endInputEditText);
        task.runTask(first, last);
        Logger.log(logs);
    }

    public void clearFields(View view) {
        ResetInput.reset(startInputEditText);
        ResetInput.reset(endInputEditText);
    }

}
