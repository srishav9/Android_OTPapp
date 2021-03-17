package com.example.risha.intents.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.risha.intents.R;
import constants.Constants;

public class MainActivity extends AppCompatActivity {
    EditText et;
    TextView tv;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=(EditText)findViewById(R.id.et);
        tv=(TextView)findViewById(R.id.tv);
        bt=(Button)findViewById(R.id.bt);
    }

    public void onClick(View view) {
        Intent i;
        i = new Intent(this,Main2Activity.class);
        i.putExtra(Constants.key1,Integer.parseInt(et.getText().toString()));
        startActivityForResult(i, Constants.REQ_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==Constants.REQ_CODE && resultCode==Constants.RES_CODE){
            tv.setText(String.valueOf(data.getIntExtra(Constants.key2,0)));
        }
    }
}