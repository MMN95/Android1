package ru.mmn.calcapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private final static String keyCalculator = "Calculator";
    TextView calcView;
    TextView resultView;
    Calculator calculator;

    @Override
    public void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        instanceState.putSerializable(keyCalculator, calculator);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        calculator = (Calculator) instanceState.getSerializable(keyCalculator);
        setTextViews();
    }

    private void setTextViews() {
        setView(resultView, calculator);
        // для calcView пока сделал атрибут freezesText
    }

    private void setView(TextView resultView, Calculator calculator) {
        if (calculator.getCurrentAction() == calculator.getAddition())
            resultView.setText(String.format("%s + ", calculator.getValueOne()));
        else if (calculator.getCurrentAction() == calculator.getSubtraction())
            resultView.setText(String.format("%s - ", calculator.getValueOne()));
        else if (calculator.getCurrentAction() == calculator.getMultiplication())
            resultView.setText(String.format("%s × ", calculator.getValueOne()));
        else if (calculator.getCurrentAction() == calculator.getDivision())
            resultView.setText(String.format("%s ÷ ", calculator.getValueOne()));
    }

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
                calcView.setText(String.format("%s2", calcView.getText()));
            }
        });

        Button button3 = findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcView.setText(String.format("%s3", calcView.getText()));
            }
        });

        Button button4 = findViewById(R.id.button_4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcView.setText(String.format("%s4", calcView.getText()));
            }
        });

        Button button5 = findViewById(R.id.button_5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcView.setText(String.format("%s5", calcView.getText()));
            }
        });

        Button button6 = findViewById(R.id.button_6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcView.setText(String.format("%s6", calcView.getText()));
            }
        });

        Button button7 = findViewById(R.id.button_7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcView.setText(String.format("%s7", calcView.getText()));
            }
        });

        Button button8 = findViewById(R.id.button_8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcView.setText(String.format("%s8", calcView.getText()));
            }
        });

        Button button9 = findViewById(R.id.button_9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcView.setText(String.format("%s9", calcView.getText()));
            }
        });

        Button button0 = findViewById(R.id.button_0);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcView.setText(String.format("%s0", calcView.getText()));
            }
        });

        // operation buttons
        Button buttonPlus = findViewById(R.id.buttonPlus);
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.setCurrentAction(calculator.getAddition());
                calculator.calculate(calcView);
                resultView.setText(String.format("%s + ", calculator.getValueOne()));
                calcView.setText(null);

            }
        });

        Button buttonMinus = findViewById(R.id.buttonMinus);
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.setCurrentAction(calculator.getSubtraction());
                calculator.calculate(calcView);
                resultView.setText(String.format("%s - ", calculator.getValueOne()));
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
                resultView.setText(String.format("%s × ", calculator.getValueOne()));
                calcView.setText(null);
            }
        });

        Button buttonDivide = findViewById(R.id.buttonDivide);
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.setCurrentAction(calculator.getDivision());
                calculator.calculate(calcView);
                resultView.setText(String.format("%s ÷ ", calculator.getValueOne()));
                calcView.setText(null);
            }
        });

        Button buttonEquals = findViewById(R.id.buttonEquals);
        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.calculate(calcView);
                resultView.setText(String.format(" = %s", calculator.getValueOne()));
                calculator.setValueOne(Double.NaN);
                calculator.setCurrentAction('0');
            }
        });

        Button buttonAC = findViewById(R.id.buttonAC);
        buttonAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultView.setText(null);
                calcView.setText(null);
                calculator.setValueOne(Double.NaN);
                calculator.setCurrentAction('0');
            }
        });

        Button buttonDel = findViewById(R.id.buttonDel);
        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = calcView.getText().toString();
                if (str.length() >= 1) {
                    str = str.substring(0, str.length() - 1);
                    calcView.setText(str);
                } else if (str.length() <= 1) calcView.setText("0");
            }
        });

        Button buttonPoint = findViewById(R.id.buttonPoint);
        buttonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcView.setText(String.format("%s.", calcView.getText()));
            }
        });

        Button buttonPercent = findViewById(R.id.buttonPercent);
        buttonPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //...
            }
        });

    }
}