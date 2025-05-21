package com.example.calculatorapp.task;

import com.example.calculatorapp.util.Logger;

public class Task1 implements Task {
    @Override
    public void runTask(int start, int end) {
        int num = start;
        for(int i = start; i <= end; i++) {
            int length = getLength(i);
            int multiply = multiplyNumbers(i, length);
            double result = calcResult(i, multiply);
            showResult(i, result);
        }
    }

    private int multiplyNumbers(int start, int length) {
        int multiply = 1;
        for(int i = 0; i < length; i++) {
            multiply *= start % 10;
            start /= 10;
        }
        return multiply;
    }

    private int getLength(int start) {
        int count = 0;
        while(start > 0) {
            int digit = start % 10;
            start /= 10;
            count++;
        }
        return count;
    }

    private double calcResult(int start, int multiply) {
        return (double) start / multiply;
    }

    private void showResult(int start, double result) {
        if(isInteger(result)) {
            System.out.println(start);
        }
    }

    private boolean isInteger(double result) {
        return result % 1 == 0;
    }
}
