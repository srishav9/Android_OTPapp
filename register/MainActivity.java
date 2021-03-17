package com.example.risha.register;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    EditText et_name,et_email,et_password,et_re_password;
    Button btn_browse,btn_register;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name=(EditText)findViewById(R.id.et_name);
        et_email=(EditText)findViewById(R.id.et_email);
        et_password=(EditText)findViewById(R.id.et_password);
        et_re_password=(EditText)findViewById(R.id.et_re_password);
        btn_browse=(Button)findViewById(R.id.btn_browse);
        btn_register=(Button)findViewById(R.id.btn_register);
        iv=(ImageView)findViewById(R.id.iv);
    }


    public void onClick(View view) {
        if(view.getId()==R.id.btn_browse) {
            final AlertDialog dialog;
            final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, R.style.AlertDialog_AppCompat_);
            builder.setTitle("Choose a picture");
            LayoutInflater inflater=this.getLayoutInflater();
            final View dialogView=inflater.inflate(R.layout.activity_main2,null);

            builder.setView(dialogView);
            builder.setNegativeButton("cancel",null);
            dialog=builder.create();
            dialog.show();
        }

    }
}
