package com.example.td1_calculatrice;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView textCalcul;
    private double result;
    private boolean clickedOperator = false;
    private boolean update = false;
    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onClickButtonsListener();
    }

    protected void onClickButtonsListener() {
        Button b0 = findViewById(R.id.button_0);
        Button b1 = findViewById(R.id.button_1);
        Button b2 = findViewById(R.id.button_2);
        Button b3 = findViewById(R.id.button_3);
        Button b4 = findViewById(R.id.button_4);
        Button b5 = findViewById(R.id.button_5);
        Button b6 = findViewById(R.id.button_6);
        Button b7 = findViewById(R.id.button_7);
        Button b8 = findViewById(R.id.button_8);
        Button b9 = findViewById(R.id.button_9);

        Button bAdd = findViewById(R.id.button_add);
        Button bSub = findViewById(R.id.button_sub);
        Button bProd = findViewById(R.id.button_prod);
        Button bDiv = findViewById(R.id.button_div);
        Button bEqual = findViewById(R.id.button_equal);
        Button bComma = findViewById(R.id.button_comma);
        Button bClear = findViewById(R.id.button_clear);
        textCalcul = findViewById(R.id.text_view);

        bAdd.setOnClickListener(
                view -> clickAdd()
        );
        bSub.setOnClickListener(
                view -> clickSub()
        );
        bProd.setOnClickListener(
                view -> clickProd()
        );
        bDiv.setOnClickListener(
                view -> clickDiv()
        );

        bEqual.setOnClickListener(
                view -> clickEqual()
        );
        bComma.setOnClickListener(
                view -> clickDigit(".")
        );
        bClear.setOnClickListener(
                view -> clickClear()
        );


        b0.setOnClickListener(
                view -> clickDigit("0")
        );
        b1.setOnClickListener(
                view -> clickDigit("1")
        );
        b2.setOnClickListener(
                view -> clickDigit("2")
        );
        b3.setOnClickListener(
                view -> clickDigit("3")
        );
        b4.setOnClickListener(
                view -> clickDigit("4")
        );
        b5.setOnClickListener(
                view -> clickDigit("5")
        );
        b6.setOnClickListener(
                view -> clickDigit("6")
        );
        b7.setOnClickListener(
                view -> clickDigit("7")
        );
        b8.setOnClickListener(
                view -> clickDigit("8")
        );
        b9.setOnClickListener(
                view -> clickDigit("9")
        );
    }

    protected void clickDigit(String digit) {
        if (update) {
            update = false;
        }
        else {
            if (!textCalcul.getText().equals("0"))
                digit = textCalcul.getText() + digit;
        }
        textCalcul.setText(digit);
    }

    protected void clickAdd() {
        if (clickedOperator) {
            calcul();
        } else {
            result = Double.parseDouble(textCalcul.getText().toString());
            clickedOperator = true;
        }
        operator = "+";
        update = true;
    }
    protected void clickSub() {
        if (clickedOperator) {
            calcul();
        } else {
            result = Double.parseDouble(textCalcul.getText().toString());
            clickedOperator = true;
        }
        operator = "-";
        update = true;
    }
    protected void clickProd() {
        if (clickedOperator) {
            calcul();
        } else {
            result = Double.parseDouble(textCalcul.getText().toString());
            clickedOperator = true;
        }
        operator = "*";
        update = true;
    }
    protected void clickDiv() {
        if (clickedOperator) {
            calcul();
        } else {
            result = Double.parseDouble(textCalcul.getText().toString());
            clickedOperator = true;
        }
        operator = "/";
        update = true;
    }
    protected void clickEqual() {
        calcul();
        update = true;
        clickedOperator = false;
    }
    protected void clickClear() {
        clickedOperator = false;
        update = true;
        result = 0;
        operator = "";
        textCalcul.setText("");
    }

    protected void calcul() {
        switch (operator) {
            case "+":
                result += Double.parseDouble(textCalcul.getText().toString());
                textCalcul.setText(String.valueOf(result));
                break;
            case "-":
                result -= Double.parseDouble(textCalcul.getText().toString());
                textCalcul.setText(String.valueOf(result));
                break;
            case "*":
                result *= Double.parseDouble(textCalcul.getText().toString());
                textCalcul.setText(String.valueOf(result));
                break;
            case "/":
                try {
                    result /= Double.parseDouble(textCalcul.getText().toString());
                    textCalcul.setText(String.valueOf(result));
                } catch (ArithmeticException e) {
                    textCalcul.setText("0");
                }
                break;
        }
    }
}