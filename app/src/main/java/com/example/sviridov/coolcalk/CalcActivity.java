package com.example.sviridov.coolcalk;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CalcActivity extends Activity {
    String runningNumbers = "";
    String leftContainer = "";
    String righrContainer = "";
    int result = 0;


    TextView resultView;

    public enum Operation {
        ADD, SUBSTRACT, DIVIDE, MULTIPLY, EQUAL
    }

    Operation currentOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        Button oneButton = (Button) findViewById(R.id.button1);
        Button twoButton = (Button) findViewById(R.id.button2);
        Button threeButton = (Button) findViewById(R.id.button3);
        Button fourButton = (Button) findViewById(R.id.button4);
        Button fiveButton = (Button) findViewById(R.id.button5);
        Button sixButton = (Button) findViewById(R.id.button6);
        Button sevenButton = (Button) findViewById(R.id.button7);
        Button eightButton = (Button) findViewById(R.id.button8);
        Button nineButton = (Button) findViewById(R.id.button9);
        Button zeroButton = (Button) findViewById(R.id.button0);
        Button clearButton = (Button) findViewById(R.id.btnClear);

        ImageButton equalButton = (ImageButton) findViewById(R.id.ButtonEqual);
        ImageButton plusButton = (ImageButton) findViewById(R.id.imgBtnPlus);
        ImageButton minusButton = (ImageButton) findViewById(R.id.imgBtnMin);
        ImageButton multiplButton = (ImageButton) findViewById(R.id.imgBtnMult);
        ImageButton divButton = (ImageButton) findViewById(R.id.imgBtnDiv);

        resultView = (TextView) findViewById(R.id.resultView);
        resultView.setText("");

        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(1);
            }
        });
        twoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(2);
            }
        });
        threeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(3);
            }
        });
        fourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(4);
            }
        });
        fiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(5);
            }
        });
        sixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(6);
            }
        });
        sevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(7);
            }
        });
        eightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(8);
            }
        });
        nineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(9);
            }
        });
        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(0);
            }
        });
        equalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.EQUAL);
            }
        });
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.ADD);

            }
        });
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.SUBSTRACT);

            }
        });
        multiplButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.MULTIPLY);
            }
        });
        divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.DIVIDE);

            }
        });
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftContainer = "";
                righrContainer = "";
                result = 0;
                runningNumbers = "";
                currentOperation = null;
                resultView.setText("");

            }
        });

    }

    void processOperation(Operation operation) {
        if (currentOperation != null) {
            if (runningNumbers != "") {
                righrContainer = runningNumbers;
                runningNumbers = "";

                switch (currentOperation) {
                    case ADD:
                        result = Integer.parseInt(leftContainer) + Integer.parseInt(righrContainer);
                        break;
                    case SUBSTRACT:
                        result = Integer.parseInt(leftContainer) - Integer.parseInt(righrContainer);
                        break;
                    case MULTIPLY:
                        result = Integer.parseInt(leftContainer) * Integer.parseInt(righrContainer);
                        break;
                    case DIVIDE:
                        result = Integer.parseInt(leftContainer) / Integer.parseInt(righrContainer);
                        break;

                }
                leftContainer = String.valueOf(result);
                resultView.setText(leftContainer);

            }
        } else {
            leftContainer = runningNumbers;
            runningNumbers = "";
        }
        currentOperation = operation;
    }

    void numberPressed(int number) {
        runningNumbers += String.valueOf(number);
        resultView.setText(runningNumbers);
    }
}
