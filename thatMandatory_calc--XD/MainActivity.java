package com.example.risha.mycalc;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String key;
    private double num1,num2,res;
    EditText editText;
    Button one,two,three,four,five,six,seven,eight,nine,zero,point;
    ImageButton add,sub,mul,div,equal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setValues();
    }
    public void onClick(View v){
        if(v.getId()==R.id.one){
            if(noText())    editText.setText('1');
            else {
                editText.setText(addToContent('1'));
                bringCursorToRight();   }
        }
        else if(v.getId()==R.id.two){
            if(noText())    editText.setText('2');
            else {
                editText.setText(addToContent('2'));
                bringCursorToRight();   }
        }
        else if(v.getId()==R.id.three){
            if(noText())    editText.setText('3');
            else {
                editText.setText(addToContent('3'));
                bringCursorToRight();   }
        }
        else if(v.getId()==R.id.four){
            if(noText())    editText.setText('4');
            else {
                editText.setText(addToContent('4'));
                bringCursorToRight();   }
        }
        else if(v.getId()==R.id.five){
            if(noText())    editText.setText('5');
            else{
                editText.setText(addToContent('5'));
                bringCursorToRight();   }
        }
        else if(v.getId()==R.id.six){
            if(noText())    editText.setText('6');
            else{
                editText.setText(addToContent('6'));
                bringCursorToRight();
            }
        }
        else if(v.getId()==R.id.seven){
            if(noText())    editText.setText('7');
            else{
                editText.setText(addToContent('7'));
                bringCursorToRight();
            }
        }
        else if(v.getId()==R.id.eight){
            if(noText())    editText.setText('8');
            else {
                editText.setText(addToContent('8'));
                bringCursorToRight();   }
        }
        else if(v.getId()==R.id.nine){
            if(noText())    editText.setText('9');
            else    {
                editText.setText(addToContent('9'));
                bringCursorToRight();   }
        }
        else if(v.getId()==R.id.zero){
            if(noText())    editText.setText('0');
            else    {
                editText.setText(addToContent('0'));
                bringCursorToRight();   }
        }
        else if(v.getId()==R.id.point){
            if(noText())    editText.setText('.');
            else    {
                editText.setText(addToContent('.'));
                bringCursorToRight();   }
        }
        else if(v.getId()==R.id.ad){
            if(isNumber()) {
                setNum1();
                setKey("add");
            }
        }
        else if(v.getId()==R.id.sub){
            if(isNumber()) {
                setNum1();
                setKey("sub");
            }
        }
        else if(v.getId()==R.id.mul){
            if(isNumber()) {
                setNum1();
                setKey("mul");
            }
        }
        else if(v.getId()==R.id.div){
            if(isNumber()) {
                setNum1();
                setKey("div");
            }
        }
        else if(v.getId()==R.id.equal){
            if(isNumber()) {
                setNum2(key);
                displayResult(key);
            }
        }
        else    editText.setText("");
    }
    private void setValues(){
        editText=(EditText)findViewById(R.id.et);
        one=(Button)findViewById(R.id.one);
        two=(Button)findViewById(R.id.two);
        three=(Button)findViewById(R.id.three);
        four=(Button)findViewById(R.id.four);
        five=(Button)findViewById(R.id.five);
        six=(Button)findViewById(R.id.six);
        seven=(Button)findViewById(R.id.seven);
        eight=(Button)findViewById(R.id.eight);
        nine=(Button)findViewById(R.id.nine);
        zero=(Button)findViewById(R.id.zero);
        point=(Button)findViewById(R.id.point);
        add=(ImageButton) findViewById(R.id.add);
        sub=(ImageButton) findViewById(R.id.sub);
        mul=(ImageButton) findViewById(R.id.mul);
        div=(ImageButton) findViewById(R.id.div);
        equal=(ImageButton) findViewById(R.id.equal);
    }
    private void bringCursorToRight(){
        editText.setSelection(editText.length());
    }
    private boolean isNumber(){
        String str=editText.getText().toString();
        if(str.trim().equals("")){
            Toast.makeText(this, "ENTER A NUMBER FIRST!", Toast.LENGTH_SHORT).show();
            editText.setText("");
            return false;
        }
        else
            return true;
    }
    @NonNull
    private String addToContent(char str){
        return editText.getText().toString()+str;
    }
    private boolean noText(){
        if(editText.getText().toString()==null){
            return true;
        }
        else {
            return false;
        }
    }
    private void setKey(String str){
        key=str;
    }
    private void setNum1(){
        num1 = Double.parseDouble(editText.getText().toString());
        Toast.makeText(this, "num1=" + num1, Toast.LENGTH_SHORT).show();
        editText.setText("");
    }
    private void setNum2(String str){
        num2 = Double.parseDouble(editText.getText().toString());
        Toast.makeText(this, "num2=" + num2 + "   " + str, Toast.LENGTH_SHORT).show();
    }
    private void displayResult(String str){
        switch (str) {
            case "add":
                res = num1 + num2;
                break;
            case "sub":
                res = num1 - num2;
                break;
            case "mul":
                res = num1 * num2;
                break;
            case "div":
                res = num1 / num2;
                break;
        }
        editText.setText(String.valueOf(res));
        bringCursorToRight();
    }
}
/*
editText.getText().toString().isEmpty() shows error IllegalStateException
*/