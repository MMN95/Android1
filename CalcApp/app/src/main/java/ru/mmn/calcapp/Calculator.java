package ru.mmn.calcapp;

import android.widget.TextView;

public class Calculator {

    private double valueOne;
    private double valueTwo;

    private static final char addition = '+';
    private static final char subtraction = '-';
    private static final char multiplication = '×';
    private static final char division = '÷';
    private char currentAction;

    public void setCurrentAction(char currentAction) {
        this.currentAction = currentAction;
    }

    public char getAddition() {
        return addition;
    }

    public char getSubtraction() {
        return subtraction;
    }

    public char getMultiplication() {
        return multiplication;
    }

    public char getDivision() {
        return division;
    }

    public void calculate(TextView calcView){
        if(!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(calcView.getText().toString());
            calcView.setText(null);
            if(currentAction == addition)
                valueOne = this.valueOne + valueTwo;
            else if(currentAction == subtraction)
                valueOne = this.valueOne - valueTwo;
            else if(currentAction == multiplication)
                valueOne = this.valueOne * valueTwo;
            else if(currentAction == division)
                valueOne = this.valueOne / valueTwo;
        } else {
            try {
                valueOne = Double.parseDouble(calcView.getText().toString());
            } catch (Exception e) {}
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
