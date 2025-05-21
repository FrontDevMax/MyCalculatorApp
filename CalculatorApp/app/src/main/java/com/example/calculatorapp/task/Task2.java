package com.example.calculatorapp.task;

public class Task2 implements Task {
    @Override
    public void runTask(int start, int end) {
        int num = start;
        for(int i = start; i <= end; i++) {
            int length = getLength(i);
            int sum = sumNumbers(i, length);
            double result = calcResult(i, sum);
            showResult(i, result);
        }
    }

    private int sumNumbers(int start, int length) {
        int sum = 0;
        for(int i = 0; i < length; i++) {
            sum += start % 10;
            start /= 10;
        }
        return sum;
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

    private double calcResult(int start, int sum) {
        return (double) start / sum;
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
