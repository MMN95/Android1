package ru.mmn.calcapp;

import android.widget.TextView;

import java.io.Serializable;

public class Calculator implements Serializable {

    private double valueOne = Double.NaN;
    private double valueTwo;

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '×';
    private static final char DIVISION = '÷';
    private char currentAction;

    public void setCurrentAction(char currentAction) {
        this.currentAction = currentAction;
    }

    public char getCurrentAction(){
        return currentAction;
    }

    public char getAddition() {
        return ADDITION;
    }

    public char getSubtraction() {
        return SUBTRACTION;
    }

    public char getMultiplication() {
        return MULTIPLICATION;
    }

    public char getDivision() {
        return DIVISION;
    }

    public void calculate(TextView calcView){
        if(!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(calcView.getText().toString());
            calcView.setText(null);
            switch (currentAction) {
                case ADDITION:
                    valueOne = this.valueOne + valueTwo;
                    break;
                case SUBTRACTION:
                    valueOne = this.valueOne - valueTwo;
                    break;
                case MULTIPLICATION:
                    valueOne = this.valueOne * valueTwo;
                    break;
                case DIVISION:
                    valueOne = this.valueOne / valueTwo;
                    break;
            }
        } else {
            try {
                valueOne = Double.parseDouble(calcView.getText().toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setValueOne(double valueOne) {
        this.valueOne = valueOne;
    }

    public void setValueTwo(double valueTwo) {
        this.valueTwo = valueTwo;
    }

    public double getValueOne(){
        return valueOne;
    }

    public double getValueTwo(){
        return valueTwo;
    }

}
