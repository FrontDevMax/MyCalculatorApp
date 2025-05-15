package com.example.calculatorapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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
import com.google.android.material.textfield.TextInputEditText;

import java.util.Arrays;
import java.util.List;

public class CalculatorActivity extends AppCompatActivity {
    private Spinner spinnerTasks;
    private TextInputEditText startEditText, endEditText;
    private TextView textError, logs;
    private CalculatorController calculatorController = new CalculatorController();
    private List<Task> listTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        init();
    }

    private void init() {
        spinnerTasks = findViewById(R.id.spinnerTasks);
        startEditText = findViewById(R.id.startEditText);
        endEditText = findViewById(R.id.endEditText);
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
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }

    /*public void startMethod(View view) {
        try {
            CalculatorModel calculatorModel = new CalculatorModel(
                    Integer.parseInt(String.valueOf(startEditText.getText())),
                    Integer.parseInt(String.valueOf(endEditText.getText()))
            );
            calculatorController.validateInput(calculatorModel);
            listTasks = getListTasks();
//            int selectItem = spinnerTasks.getSelectedItemPosition();
//            showTask(listTasks.get(selectItem - 1));
        } catch(NumException ex) {
            handleNumError(ex.getNumError(), ex.getMessage());
        }
    }
*/
    private void handleNumError(NumError numError, String message) {
        switch(numError) {
            case EMPTY:
                textError.setText(message);
            case LESS_ZERO:
                textError.setText(message);
            case FLOATING_NUM:
                textError.setText(message);
            case LIMIT_NUM:
                textError.setText(message);
        }
    }

    private void showTask(Task task) {
        int start = Integer.parseInt(String.valueOf(startEditText.getText()));
        int end = Integer.parseInt(String.valueOf(endEditText.getText()));
        task.runTask(start, end);
    }

    public void startMethod1(View view) {
        try {
            CalculatorModel calculatorModel = new CalculatorModel(
                    startEditText.getText().toString(),
                    endEditText.getText().toString()
            );
            calculatorController.validateInput(calculatorModel);
            /*listTasks = getListTasks();
            int selectItem = spinnerTasks.getSelectedItemPosition();
            showTask(listTasks.get(selectItem - 1));*/
        } catch(NumException ex) {
            handleNumError(ex.getNumError(), ex.getMessage());
        }
    }

//    public void cleanFields(View view) {
//
//    }

}
