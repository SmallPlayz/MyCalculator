package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    /*
        EXAMPLE TEST CASES
        2x^2 + 6x + 5 + 3x^2 − 2x − 1 = 5x^2 + 4x + 4
        10+6 = 16
        3 * 4 = 12
        2x + 8 = 2x + 8
        4 + 2x^3 + 5x^3 + 2 = 7x^3 + 6
        3x^3 + 6x^4 + 7x^4 - 4 = 13x^4 + 3x^3 - 4
        7x + 6x * 5x^2 + 8 = 30x^3 + 7x + 8
        6x * 2x + 3 = 12x^2 + 3
        5x^3 * 12x^5 + 5x - 2x * 8 + 10 = 60x^8 - 11x + 10
        7x^5 + 8x - 9x^5 + 10 - 8 = -2x^5 + 8x + 2

        EXAMPLE ERROR TEST CASES (Should result in “ERROR” displayed)
        5x^2+X^ [Ends with carrot]
        3X+ [Ends with Operator]
        *X+2 [Starts with Operator]
        4X++2 [Double Operators]
        4X**2 [Double Operators]
        4X+*2 [Double Operators]
        Nothing in expression -> Press Delete
     */


    TextView textNumber;
    Button buttonClear, buttonDelete, buttonVariable, buttonDivision, button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonMultiplication, buttonSubtraction, buttonAddition, buttonEqual, buttonExponent, buttonDecimal;

    WebView myWebView;

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


        buttonEqual.setOnClickListener(new addNumberToTextView());


        // ************************************************************

       // myWebView = findViewById(R.id.webview); 2x^2 + 6x + 5 + 3x^2 − 2x − 1

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
            else if(str.equalsIgnoreCase("G")) {
                textNumber.setText("WEFIH");
                Log.d("FGEEFW", "WEFWEFOJI");

            }
            else if(str.equalsIgnoreCase("=")) {
                Log.d("omgsgors", (String) textNumber.getText().toString());

                if(textNumber.getText().toString().charAt(textNumber.length()-1) != '+' && textNumber.getText().charAt(textNumber.length()-1) != '-' && textNumber.getText().charAt(textNumber.length()-1) != '*' && textNumber.getText().charAt(textNumber.length()-1) != '^' && textNumber.getText().charAt(0) != '+' && textNumber.getText().charAt(0) != '*' && textNumber.getText().charAt(0) != '^') {
                        try {
                            String result = calculate(textNumber.getText().toString().toLowerCase());
                            textNumber.setText(result.toUpperCase());
                        } catch (Exception e) {
                            textNumber.setText("error"); //7x^5 + 8x - 9x^5 + 10 - 8
                        }

                    /*
                    *
                    * 5x^2+X^ [Ends with carrot]
                    3X+ [Ends with Operator]
                    *X+2 [Starts with Operator]
                    4X++2 [Double Operators]
                    4X**2 [Double Operators]
                    4X+*2 [Double Operators]
                    Nothing in expression -> Press Delete
                    *
                    * */

                } else {
                    textNumber.setText("error");

                }
            }
            else if(str.equalsIgnoreCase("^")) {
                Log.d("CHEESE",textNumber.getText() + " " + textNumber.length());
                if(!textNumber.getText().toString().equals("0"))
                    if((textNumber.getText().charAt(textNumber.length()-1)) != '^')
                        textNumber.append("^");

            }
            else
                if(textNumber.getText().toString().equals("0"))
                    textNumber.setText(str);
                else
                    textNumber.setText(textNumber.getText() + str);


        }
    }
    public static String add(String input, String input2) {

        if(input.contains("x") && !input2.contains("x"))
            return input + "+" + input2;
        else if(!input.contains("x") && input2.contains("x"))
            return input2 + "+" + input;

        if (input.contains("x") && input2.contains("x")) {

            if(input.contains("^") && !input2.contains("^")) {
                return input + "+" + input2;
            }
            else if(!input.contains("^") && input2.contains("^")) {
                return input2 + "+" + input;
            }
            else if(input.contains("^") && input2.contains("^")) {
                int i1 = Integer.parseInt((input.substring(input.length()-1)));
                int i2 = Integer.parseInt((input2.substring(input2.length()-1)));

                if(i1 < i2)
                    return input2 + "+" + input;
                else if(i1 > i2)
                    return input + "+" + input2;
                else if (i1 == i2)
                    return Integer.parseInt(input.split("x")[0]) + Integer.parseInt(input2.split("x")[0]) + "x^" + i1;


            }

            return Integer.parseInt(input.replace("x", "")) + Integer.parseInt(input2.replace("x", "")) + "x";
        } else {
            return String.valueOf(Integer.parseInt(input) + Integer.parseInt(input2));
        }
    }

    public static String multiply(String input1, String input2) {

        if(!input1.contains("x") && !input2.contains("x"))
            return Integer.parseInt(input1) + Integer.parseInt(input2) + "";
        else if (input1.contains("x") && !input2.contains("x")) {
            int x = Integer.parseInt(input1.substring(0, input1.indexOf('x')));
            int y = Integer.parseInt(input2);
            return x*y + input1.substring(input1.indexOf('x'));
        }
        else if (!input1.contains("x") && input2.contains("x")) {
            int x = Integer.parseInt(input1);
            int y = Integer.parseInt(input2.substring(0, input2.indexOf('x')));
            return x*y + input2.substring(input2.indexOf('x'));
        } else if (input1.contains("x") && input2.contains("x")) {
            int x = Integer.parseInt(input1.substring(0, input1.indexOf('x')));
            int y = Integer.parseInt(input2.substring(0, input2.indexOf('x')));

            String str = (x*y) + "x";

            if(!input1.contains("^") && !input2.contains("^"))
                return str + "^2";
            else if (input1.contains("^") && input2.contains("^")) {
                int z = Integer.parseInt(input1.substring(input1.indexOf('^')+1));
                int z1 = Integer.parseInt(input2.substring(input2.indexOf('^')+1));
                return str + "^" + (z+z1);
            }
            else if (input1.contains("^") && !input2.contains("^")) {
                return str + input1.substring(input1.indexOf("^"));
            }
            else if (!input1.contains("^") && input2.contains("^")) {
                return str + input2.substring(input2.indexOf("^"));
            }
        }

        return "";
    }

    public static String calculate(String input) {
        input = input.trim();
        input = input.replace(" ", "");
        System.out.println("HELLO: " + input);
        input = input.replace("-", "+-");
        System.out.println("HELLO: " + input);

        String result = "";

        StringTokenizer tokenizer = new StringTokenizer(input, "+*/", true);
        ArrayList<String> tokens = new ArrayList<>();

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            tokens.add(token);
        }
        System.out.println(tokens);

        for(int i = 0; i<tokens.size(); i++)
            if(tokens.get(i).contains("x") && !tokens.get(i).contains("^"))
                tokens.set(i, tokens.get(i) + "^1");

        // If non variable elements contain exponents, simplify it.
        for(int i = 0; i<tokens.size(); i++)
            if(tokens.get(i).contains("^") && !tokens.get(i).contains("x")){
                int baseNum = Integer.parseInt(tokens.get(i).substring(0, tokens.get(i).indexOf("^")));
                int expNum = Integer.parseInt(tokens.get(i).substring(tokens.get(i).indexOf("^")+1));
                int newNum = (int) Math.pow(baseNum, expNum);
                tokens.set(i, Integer.toString(newNum));
            }

        System.out.println("XXXXXXXXXXXXXXXXXXXX");
        System.out.println(tokens);

        // If find multiplication, multiply.
        for(int j = 1; j<tokens.size()-1; j++) {
            for (int i = 1; i < tokens.size() - 1; i++)
                if (tokens.get(i).contains("*")) {
                    String num1 = tokens.get(i - 1);
                    String num2 = tokens.get(i + 1);
                    String product = multiply(num1, num2);
                    tokens.subList(i - 1, i + 2).clear();
                    tokens.add(i - 1, product);
                }
            System.out.println(tokens);
        }
        System.out.println("\nAMOGUS\n");

        for(int j = 1; j<tokens.size()-1; j++) {
            for (int i = 1; i < tokens.size() - 1; i++)
                if (tokens.get(i).contains("+")) {
                    String num1 = tokens.get(i - 1);
                    String num2 = tokens.get(i + 1);
                    String sum = add(num1, num2);

                    // todo: make string of array part before and after sum. Put sum in middle. Convert back into Arraylist.





                    // SOMETHING WENT WRONG HERE!!!!



                    String first_part = "";
                    String second_part = "";

                    if(i != 1)
                        for(int k = 0; k <= i; k++)
                            first_part += tokens.get(k);
                    for(int k = i; k < tokens.size(); k++)
                        second_part += tokens.get(k);

                    String total_str = String.join("", tokens.subList(0, i - 1)) + sum + String.join("", tokens.subList(i + 2, tokens.size()));

                    StringTokenizer tokenizer2 = new StringTokenizer(total_str, "+*/", true);
                    ArrayList<String> tokens2 = new ArrayList<>();

                    while (tokenizer2.hasMoreTokens()) {
                        String token2 = tokenizer2.nextToken();
                        tokens2.add(token2);
                    }

                    tokens = tokens2;


                    //*******

                    //tokens.subList(i - 1, i + 2).clear();
                    //tokens.add(i - 1, sum);
                }
            System.out.println(tokens);
        }

        System.out.println("\nAMOGUS\n");

        // put things in order maybe
        if(tokens.size() >= 2) {
            //among us among us among us among us among us among us among us amgius omogsudogjeieddkeikekekekekfkefekeeee
            for(int j = 1; j<tokens.size()-1; j++) {
                if(tokens.get(j).equals("+") || tokens.get(j).equals("*")) {
                    String one = tokens.get(j-1);
                    String two = tokens.get(j+1);
                    if(one.contains("^") && two.contains("^")) {
                        String onee = one.substring(one.indexOf("^") + 1);
                        two = two.substring(two.indexOf("^") + 1);

                        int one1 = Integer.parseInt(onee);
                        int two1 = Integer.parseInt(two);

                        if(one1 < two1) {
                            tokens.set(j-1, tokens.get(j+1));
                            tokens.set(j+1, one);
                        }
                    }
                    else if(!one.contains("^") && two.contains("^")) {
                        tokens.set(j-1, tokens.get(j+1));
                        tokens.set(j+1, one);
                    }
                }

                // ICH HASSE DAS SPRACHE UND ICH MUSS JETZT SCHLFAEN

                // EWUFHWEFHUWEFHUFEWHUFWEIOIJOFEWEFWJIOEFWIOJEFWIJO

                // DAS SPRACHE IST SO SCHLECHTE


                // AONEFVIWJRNFJQEJVF

                // EINE KARTOFFEL IST WAS MICH MÖTCHTEN
                // SEBST EIN KARTOFFEL IST BESSER ALS DAS DUMME SCHPRACHE
            }
        }

        System.out.println("\n\n\n");
        // Removes exponents of 1.
        for(int i = 0; i<tokens.size(); i++) {
            System.out.println(tokens);
            if (tokens.get(i).contains("x") && tokens.get(i).contains("^1")) {
                tokens.set(i, tokens.get(i).substring(0, tokens.get(i).indexOf("^")));
            }
        }
        System.out.println("\n\n\n");

        for(String str: tokens)
            result+=str;

        System.out.println(result);
        //removes +- and puts - if +- is found.
        result = result.replaceAll("\\+\\-", "-");

        return result;
    }

}