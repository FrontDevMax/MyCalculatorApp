package com.example.calculatorapp.domain.model;

import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;

public class CalculatorModel {
    private final String startNum;
    private final String endNum;

    public CalculatorModel(String startNum, String endNum) {
        this.startNum = startNum;
        this.endNum = endNum;
    }

    public String getStartNum() {
        return startNum;
    }

    public String getEndNum() {
        return endNum;
    }
}
