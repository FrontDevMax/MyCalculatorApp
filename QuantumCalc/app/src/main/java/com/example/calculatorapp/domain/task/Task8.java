package com.example.calculatorapp.domain.task;

import com.example.calculatorapp.presentation.util.Logger;

public class Task8 implements Task {
    @Override
    public void runTask(String start, String end) {
        int startNum = Integer.parseInt(start);
        int endNum = Integer.parseInt(end);

        for (int num = startNum; num <= endNum; num++) {
            if (isKaprekarNumber(num)) {
                Logger.add(Integer.toString(num));
            }
        }
    }

    public static boolean isKaprekarNumber(int num) {
        if (num == 1) return true;

        long square = (long) num * num;
        String squareStr = Long.toString(square);

        for (int i = 1; i < squareStr.length(); i++) {
            String leftStr = squareStr.substring(0, i);
            String rightStr = squareStr.substring(i);

            int left = Integer.parseInt(leftStr);
            int right = Integer.parseInt(rightStr);

            if (right != 0 && left + right == num) {
                return true;
            }
        }

        return false;
    }
}
