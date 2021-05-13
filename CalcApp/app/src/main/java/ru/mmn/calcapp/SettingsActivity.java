package ru.mmn.calcapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.google.android.material.radiobutton.MaterialRadioButton;

public class SettingsActivity extends BaseActivity implements Constants{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        initThemeChooser();

        Button buttonBack = findViewById(R.id.button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
                Intent intentResult = new Intent();
//                intentResult.putExtra(CURRENT_THEME, flag);
                setResult(RESULT_OK, intentResult);
                finish();
            }
        });
    }
    private void initThemeChooser() {
        initRadioButton(findViewById(R.id.radioButtonChooseDark),
                DARK);
        initRadioButton(findViewById(R.id.radioButtonChooseLight),
                LIGHT);
        RadioGroup rg = findViewById(R.id.radioButtons);
        ((MaterialRadioButton)rg.getChildAt(getCodeStyle(DARK))).setChecked(true);
    }

    private void initRadioButton(View button, final int codeStyle){
        button.setOnClickListener(v -> {
            setAppTheme(codeStyle);
            recreate();
        });
    }

}