package com.example.calculatorapp.controller;

import com.example.calculatorapp.enumeration.NumError;
import com.example.calculatorapp.exception.NumException;
import com.example.calculatorapp.model.CalculatorModel;

public class CalculatorController {
    public void validateInput(CalculatorModel calculatorModel) throws NumException {
        if(calculatorModel.getStartNum().equals("")) {
            throw new NumException(NumError.EMPTY, "Начало диапазона не может быть пустым");
        } else if(calculatorModel.getEndNum().equals("")) {
            throw new NumException(NumError.EMPTY, "Конец диапазона не может быть пустым");
        } else if(Integer.parseInt(calculatorModel.getStartNum()) < 0) {
            throw new NumException(NumError.LESS_ZERO, "Начало диапазона не может быть меньше нуля");
        } else if(Integer.parseInt(calculatorModel.getEndNum()) < 0) {
            throw new NumException(NumError.LESS_ZERO, "Конец диапазона не может быть меньше нуля");
        } else if(!(Integer.parseInt(calculatorModel.getStartNum()) % 1 == 0)) {
            throw new NumException(NumError.FLOATING_NUM, "Начало диапазона не может быть с дробями");
        } else if(!(Integer.parseInt(calculatorModel.getEndNum()) % 1 == 0)) {
            throw new NumException(NumError.FLOATING_NUM, "Конец диапазона не может быть с дробями");
        } else if(Integer.parseInt(calculatorModel.getStartNum()) > 2_147_483_646) {
            throw new NumException(NumError.LIMIT_NUM, "Начало диапазона слишком большое");
        } else if(Integer.parseInt(calculatorModel.getEndNum()) > 2_147_483_646) {
            throw new NumException(NumError.LIMIT_NUM, "Конец диапазона слишком большое");
        }
    }
}
