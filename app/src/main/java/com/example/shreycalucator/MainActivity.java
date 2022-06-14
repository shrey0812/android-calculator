package com.example.shreycalucator;

import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText display;
    private TextView previousCalculation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display=findViewById(R.id.displayEditText);
        display.setShowSoftInputOnFocus(false);
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });
    }
    public void updateText(String strToAdd){
        String oldStr=display.getText().toString();
        int cursorPos=display.getSelectionStart();
        String leftStr=oldStr.substring(0,cursorPos);
        String rightStr=oldStr.substring(cursorPos);
        if(getString(R.string.display).equals(display.getText().toString())){
            display.setText(strToAdd);
            display.setSelection(cursorPos+strToAdd.length());
        }
        else
        {
            display.setText(String.format("%s%s%s",leftStr,strToAdd,rightStr));
            display.setSelection(cursorPos+strToAdd.length());
        }
    }
    public void zeroBTN(View view){
          updateText("0");
    }
    public void oneBTN(View view){
          updateText("1");
    }
    public void twoBTN(View view){
          updateText("2");
    }
    public void threeBTN(View view){
         updateText("3");
    }
    public void fourBTN(View view){
         updateText("4");
    }
    public void fiveBTN(View view){
         updateText("5");
    }
    public void sixBTN(View view){
         updateText("6");
    }
    public void sevenBTN(View view){
         updateText("7");
    }
    public void eightBTN(View view){
         updateText("8");
    }
    public void nineBTN(View view){
         updateText("9");
    }
    public void pointBTN(View view){
         updateText(".");
    }
    public void equalsBTN(View view){
        String userExp= display.getText().toString();
        userExp=userExp.replaceAll("÷","/");
        userExp=userExp.replaceAll("×","*");
        Expression exp=new Expression(userExp);

        String result= String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());

    }
    public void plusMinusBTN(View view){

    }
    public void openParenthesisBTN(View view){
         updateText("(");
    }
    public void closeParenthesisBTN(View view){
        updateText(")");
    }
    public void addBTN(View view){
        updateText("+");
    }
    public void subtractBTN(View view){
        updateText("-");
    }
    public void multiplyBTN(View view){
        updateText("×");
    }
    public void divisionBTN(View view){
        updateText("÷");
    }
    public void clearBTN(View view){
        display.setText("");
    }
    public void backspaceBTN(View view){
     int cursorPos=display.getSelectionStart();
     int textLen=display.getText().length();
     if(cursorPos!=0 && textLen!=0){
         SpannableStringBuilder selection= (SpannableStringBuilder) display.getText();
         selection.replace(cursorPos-1,cursorPos,"");
         display.setText(selection);
         display.setSelection(cursorPos-1);
     }
    }
    public void sinBTN(View view){
        updateText("sin(");
    }
    public void cosBTN(View view){
        updateText("cos(");
    }
    public void tanBTN(View view){
        updateText("tan(");
    }
    public void sinInverseBTN(View view){
        updateText("arcsin(");
    }
    public void cosInverseBTN(View view){
        updateText("arccos(");
    }
    public void tanInverseBTN(View view){
        updateText("arctan(");
    }
    public void logBTN(View view){
        updateText("log10(");
    }
    public void naturalBTN(View view){
        updateText("ln(");
    }
    public void rootBTN(View view){
        updateText("sqrt(");
    }
    public void eBTN(View view){
        updateText("e");
    }
    public void piBTN(View view){
        updateText("Pi(");
    }
    public void absValueBTN(View view){
        updateText("abs(");
    }
    public void primeBTN(View view){
        updateText("ispr(");
    }
    public void squareBTN(View view){
        updateText("^(2)");
    }
    public void powerBTN(View view){
        updateText("^(");
    }
}