package com.example.alculatorandroid;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import static com.example.alculatorandroid.ArithmeticOperator.*;

public class MainActivity extends AppCompatActivity {

    TextView textView = null;
    Double res = 0D;
    ArithmeticOperator arithmeticOperator = NULL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);

    }
    public void clickingOn(View view)
    {
        Button button = (Button) view;
        String stringTextView = textView.getText().toString();
        Button button1 = (Button)findViewById(R.id.buttonMultiplication);
        String tmpString = stringTextView.replace(",",".");

        switch(view.getId())
        {
            case R.id.buttonZero:
            case R.id.button1:
            case R.id.button2:
            case R.id.button3:
            case R.id.button4:
            case R.id.button5:
            case R.id.button6:
            case R.id.button7:
            case R.id.button8:
            case R.id.button9:
                if (stringTextView.equals("0") || arithmeticOperator == EQUALLY)
                {
                    textView.setText(button.getText().toString());
                }
                else
                textView.append(button.getText().toString());
                break;
            case R.id.buttonComma:
                if(stringTextView.equals("0")) textView.setText("0,");
                else  textView.append(button.getText().toString());
                break;
            case R.id.buttonNull:
                textView.setText("0");
                res = 0D;
                button1.setText(res.toString());
                arithmeticOperator = NULL;
                break;
            case R.id.buttonPlus:
                setArithmeticOperator(arithmeticOperator, Double.parseDouble(tmpString));
                arithmeticOperator = PLUS;
                button1.setText(res.toString());
                textView.setText("0");
                break;
            case R.id.buttonMinus:
                setArithmeticOperator(arithmeticOperator, Double.parseDouble(tmpString));
                arithmeticOperator = MINUS;
                button1.setText(res.toString());
                textView.setText("0");
                break;
            case R.id.buttonMultiplication:
                setArithmeticOperator(arithmeticOperator, Double.parseDouble(tmpString));
                arithmeticOperator = MULTIPLICATION;
                button1.setText(res.toString());
                textView.setText("0");
                break;
            case R.id.buttonDivision:
                setArithmeticOperator(arithmeticOperator, Double.parseDouble(tmpString));
                arithmeticOperator = DIVISION;
                button1.setText(res.toString());
                textView.setText("0");
                break;
            case R.id.buttonEqually:
                setArithmeticOperator(arithmeticOperator, Double.parseDouble(tmpString));
                arithmeticOperator = EQUALLY;
                textView.setText(res.toString());
                button1.setText(res.toString());
                break;
        }


    }
    private void setArithmeticOperator(ArithmeticOperator ap, Double d)
    {
        if (ap == PLUS) res = res + d;
        if (ap == MINUS) res = res - d;
        if (ap == MULTIPLICATION) res = res * d;
        if (ap == DIVISION) res = res / d;
        if (ap == NULL) res = d;
        if (ap == EQUALLY) {res = 0D; arithmeticOperator = NULL;}

    }
}
