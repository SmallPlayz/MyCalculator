package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textNumber;
    Button buttonClear, buttonDelete, buttonVariable, buttonDivision, button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonMultiplication, buttonSubtraction, buttonAddition, buttonEqual, buttonExponent, buttonDecimal; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textNumber = findViewById(R.id.textNumber);
        
        buttonClear = findViewById(R.id.buttonClear);
        buttonDelete = findViewById(R.id.buttonDelete);
        buttonVariable = findViewById(R.id.buttonVariable);
        buttonDivision = findViewById(R.id.buttonDivision);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);

        buttonMultiplication = findViewById(R.id.buttonMultiplication);
        buttonSubtraction = findViewById(R.id.buttonSubtraction);
        buttonAddition = findViewById(R.id.buttonAddition);
        buttonEqual = findViewById(R.id.buttonEqual);
        buttonExponent = findViewById(R.id.buttonExponent);
        buttonDecimal = findViewById(R.id.buttonDecimal);

        button0.setOnClickListener(new addNumberToTextView());
        button1.setOnClickListener(new addNumberToTextView());
        button2.setOnClickListener(new addNumberToTextView());
        button3.setOnClickListener(new addNumberToTextView());
        button4.setOnClickListener(new addNumberToTextView());
        button5.setOnClickListener(new addNumberToTextView());
        button6.setOnClickListener(new addNumberToTextView());
        button7.setOnClickListener(new addNumberToTextView());
        button8.setOnClickListener(new addNumberToTextView());
        button9.setOnClickListener(new addNumberToTextView());

        buttonClear.setOnClickListener(new addNumberToTextView());
        buttonDelete.setOnClickListener(new addNumberToTextView());

        buttonVariable.setOnClickListener(new addNumberToTextView());
        buttonDivision.setOnClickListener(new addNumberToTextView());
        buttonMultiplication.setOnClickListener(new addNumberToTextView());
        buttonSubtraction.setOnClickListener(new addNumberToTextView());
        buttonAddition.setOnClickListener(new addNumberToTextView());
        buttonExponent.setOnClickListener(new addNumberToTextView());

        // ************************************************************

    }

    class addNumberToTextView implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Button b = (Button)view;
            String str = b.getText().toString();
            Log.d("amogus", (String) b.getText());

            if(str.equalsIgnoreCase("C"))
                textNumber.setText("0");
            else if(str.equalsIgnoreCase("D"))
                if(textNumber.length() > 1)
                    textNumber.setText(textNumber.getText().subSequence(0, textNumber.length()-1));
                else
                    textNumber.setText("0");
            else if(str.equalsIgnoreCase("Gr")) {

            }
            else if(str.equalsIgnoreCase("^")) {
                if(!textNumber.getText().equals("0") && textNumber.getText().charAt(textNumber.getText().length()-1) != '^')
                    textNumber.append("^");

            }
            else
                if(textNumber.getText().equals("0"))
                    textNumber.setText(str);
                else
                    textNumber.setText(textNumber.getText() + str);

            /*
            else if(b.getText().toString().equalsIgnoreCase("D"))
                if(textNumber.getText().toString().length() > 0)
                    textNumber.setText(textNumber.getText().toString().substring(0, textNumber.getText().toString().length()-1));
            else {
                if (textNumber.getText().toString().equals("0.00"))
                    textNumber.setText(b.getText().toString());
                else
                    textNumber.append(b.getText().toString());
            }*/
        }
    }
}