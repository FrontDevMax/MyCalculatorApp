package com.example.calculatorapp.validator;

import android.util.Patterns;

import com.example.calculatorapp.enumeration.AuthError;
import com.example.calculatorapp.enumeration.NumError;
import com.example.calculatorapp.exception.AuthException;
import com.example.calculatorapp.exception.NumException;

public final class NumValidator {
    private NumValidator(){}

    public static void validateStartNum(String startNum) throws NumException {
        if(startNum.equals("")) {
            throw new NumException(NumError.EMPTY_START, "Начало диапазона не может быть пустым");
        } else if(Integer.parseInt(startNum) > 2_147_483_646) {
            throw new NumException(NumError.LIMIT_START, "Начало диапазона слишком большое");
        }
    }

    public static void validateEndNum(String endNum) throws NumException {
        if(endNum.equals("")) {
            throw new NumException(NumError.EMPTY_END, "Конец диапазона не может быть пустым");
        } else if(Integer.parseInt(endNum) > 2_147_483_646) {
            throw new NumException(NumError.LIMIT_END, "Конец диапазона слишком большое");
        }
    }

    public static void validateStartNum(String startNum, String endNum) throws NumException {
        if(Integer.parseInt(startNum) > Integer.parseInt(endNum)) {
            throw new NumException(NumError.START_MORE_END, "Начало диапазона больше чем конечное");
        }
    }
}
