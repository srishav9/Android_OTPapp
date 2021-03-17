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

public class Main2Activity extends AppCompatActivity {
    EditText et1;
    Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        et1=(EditText)findViewById(R.id.et1);
        bt1=(Button)findViewById(R.id.bt1);
    }
    public void onClick(View view) {

        setResult(Constants.RES_CODE,
                  new Intent().putExtra(Constants.key2,
                          getIntent().getIntExtra(Constants.key1,0)
                                  +Integer.parseInt(et1.getText().toString())
                                       )
                 );
        this.finish();

    }
}
