package com.ksharshembie.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Integer first, second, result;
    private boolean isOperationClick;
    private boolean isOperationClickFirst;
    private String operationType = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview_display);
    }

    public void OnClickNumber(View view) {
        switch (view.getId()) {
            case R.id.btn_one:
                setNumber("1");
                break;
            case R.id.btn_two:
                setNumber("2");
                break;
            case R.id.btn_three:
                setNumber("3");
                break;
            case R.id.btn_four:
                setNumber("4");
                break;
            case R.id.btn_five:
                setNumber("5");
                break;
            case R.id.btn_six:
                setNumber("6");
                break;
            case R.id.btn_seven:
                setNumber("7");
                break;
            case R.id.btn_eight:
                setNumber("8");
                break;
            case R.id.btn_nine:
                setNumber("9");
                break;
            case R.id.btn_zero:
                setNumber("0");
                break;
        }
    }

    private void setNumber(String number) {
        if (textView.getText().toString().equals("0")) {
            textView.setText(number);
        } else if (isOperationClick) {
            textView.setText(number);
        } else {
            textView.append(number);
        }
        isOperationClick = false;
    }

    public void OnClickOperation(View view) {
        switch (view.getId()) {
            case R.id.btn_all_clear:
                allClear();
                break;
            case R.id.btn_plus:
                if (operationType.equals("0")) {
                    operationType = "+";
                    setOperation(operationType);
                } else {
                    setOperation(operationType);
                    operationType = "+";
                }
                break;
            case R.id.btn_minus:
                if (operationType.equals("0")) {
                    operationType = "-";
                    setOperation(operationType);
                } else {
                    setOperation(operationType);
                    operationType = "-";
                }
                break;
            case R.id.btn_multiplication:
                if (operationType.equals("0")) {
                    operationType = "*";
                    setOperation(operationType);
                } else {
                    setOperation(operationType);
                    operationType = "*";
                }
                break;
            case R.id.btn_division:
                if (operationType.equals("0")) {
                    operationType = "/";
                    setOperation(operationType);
                } else {
                    setOperation(operationType);
                    operationType = "/";
                }
                break;
            case R.id.btn_plus_minus:
                if (operationType.equals("0")) {
                    operationType = "+/-";
                    setOperation(operationType);
                } else {
                    setOperation(operationType);
                    operationType = "+/-";
                    setOperation(operationType);
                }
                break;
            case R.id.btn_equal:
                second = Integer.parseInt(textView.getText().toString());
                switch (operationType) {
                    case "+":
                        result = first + second;
                        break;
                    case "-":
                        result = first - second;
                        break;
                    case "*":
                        result = first * second;
                        break;
                    case "/":
                        if (second == 0) {
                            Toast.makeText(MainActivity.this, R.string.division_to_zero, Toast.LENGTH_SHORT).show();
                            allClear();
                        } else {
                            result = first / second;
                        }
                        break;
                }
                textView.setText(result.toString());
                isOperationClickFirst = false;
                isOperationClick = true;
                break;

        }
    }

    private void setOperation(String function) {
        if (isOperationClickFirst) {
            Integer temp = Integer.parseInt(textView.getText().toString());
            switch (function) {
                case "+":
                    first += temp;
                    break;
                case "-":
                    first -= temp;
                    break;
                case "*":
                    first *= temp;
                    break;
                case "/":
                    if (temp == 0) {
                        Toast.makeText(MainActivity.this, R.string.division_to_zero, Toast.LENGTH_SHORT).show();
                        allClear();
                    } else {
                        first /= temp;
                    }
                    break;
            }
            textView.setText(first.toString());
            isOperationClickFirst = true;
        } else {
            first = Integer.parseInt(textView.getText().toString());
            isOperationClickFirst = true;
        }
        isOperationClick = true;
    }

    private void allClear() {
        textView.setText("0");
        first = 0;
        second = 0;
        result = 0;
        isOperationClick = false;
        isOperationClickFirst = false;
        operationType = "0";
    }

}