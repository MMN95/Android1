package ru.mmn.calcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView calcView;
    TextView resultView;
    Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcView = findViewById(R.id.calcView);
        resultView = findViewById(R.id.resultView);
        calculator = new Calculator();

        // number buttons
        Button button1 = findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcView.setText(String.format("%s1", calcView.getText()));
            }
        });

        Button button2 = findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcView.setText(calcView.getText() + "2");
            }
        });

        Button button3 = findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcView.setText(calcView.getText() + "3");
            }
        });

        Button button4 = findViewById(R.id.button_4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcView.setText(calcView.getText() + "4");
            }
        });

        Button button5 = findViewById(R.id.button_5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcView.setText(calcView.getText() + "5");
            }
        });

        Button button6 = findViewById(R.id.button_6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcView.setText(calcView.getText() + "6");
            }
        });

        Button button7 = findViewById(R.id.button_7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcView.setText(calcView.getText() + "7");
            }
        });

        Button button8 = findViewById(R.id.button_8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcView.setText(calcView.getText() + "8");
            }
        });

        Button button9 = findViewById(R.id.button_9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcView.setText(calcView.getText() + "9");
            }
        });

        Button button0 = findViewById(R.id.button_0);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcView.setText(calcView.getText() + "0");
            }
        });

        // operation buttons
        Button buttonPlus = findViewById(R.id.buttonPlus);
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.setCurrentAction(calculator.getAddition());
                calculator.calculate(calcView);
                resultView.setText((int) calculator.getValueOne() + " + ");
                calcView.setText(null);

            }
        });

        Button buttonMinus = findViewById(R.id.buttonMinus);
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.setCurrentAction(calculator.getSubtraction());
                calculator.calculate(calcView);
                resultView.setText((int) calculator.getValueOne() + " - ");
                calcView.setText(null);
            }
        });
//
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.setCurrentAction(calculator.getMultiplication());
                calculator.calculate(calcView);
                resultView.setText((int) calculator.getValueOne() + " × ");
                calcView.setText(null);
            }
        });

        Button buttonDivide = findViewById(R.id.buttonDivide);
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.setCurrentAction(calculator.getDivision());
                calculator.calculate(calcView);
                resultView.setText((int) calculator.getValueOne() + " ÷ ");
                calcView.setText(null);
            }
        });

        Button buttonEquals = findViewById(R.id.buttonEquals);
        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.calculate(calcView);
                resultView.setText(" = " + calculator.getValueOne());
                calculator.setValueOne(Double.NaN);
                calculator.setCurrentAction('0');
            }
        });



    }
}