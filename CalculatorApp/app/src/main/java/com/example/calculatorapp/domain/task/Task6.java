package com.example.calculatorapp.domain.task;

import com.example.calculatorapp.presentation.util.Logger;

import java.util.ArrayList;
import java.util.List;

public class Task6 implements Task {
    @Override
    public void runTask(String start, String end) {
        int startNum = Integer.parseInt(start);
        int endNum = Integer.parseInt(end);

        for (int num = startNum; num <= endNum; num++) {
            if (isKeithNumber(num)) {
                Logger.add(Integer.toString(num));
            }
        }
    }

    public static boolean isKeithNumber(int n) {
        if (n < 10) return false;
        List<Integer> digits = new ArrayList<>();
        int temp = n;
        while (temp > 0) {
            digits.add(0, temp % 10);
            temp /= 10;
        }

        int len = digits.size();
        List<Integer> sequence = new ArrayList<>(digits);
        int currentSum = digits.stream().mapToInt(Integer::intValue).sum();
        sequence.add(currentSum);
        while (currentSum <= n) {
            if (currentSum == n) return true;
            int nextNum = currentSum;
            currentSum = currentSum * 2 - sequence.get(sequence.size() - len - 1);
            sequence.add(nextNum);
        }

        return false;
    }
}
