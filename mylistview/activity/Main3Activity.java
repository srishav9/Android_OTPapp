package com.example.risha.mylistview.activity;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.risha.mylistview.R;

import java.util.ArrayList;
import java.util.List;

import adapters.MyAdapter;
import adapters.MyAdapter1;
import adapters.RecyclerAdapter;
import database.DataSource;
import listeners.IRecyclerItemClick;
import utils.Model;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener, IRecyclerItemClick {
    Button btn,btn1,btn2;
    EditText et_name,et_email,et_password,et_re_password;
    DataSource ds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        btn=(Button)findViewById(R.id.btn_browse);
        btn1=(Button)findViewById(R.id.btn_register);
        btn2=(Button)findViewById(R.id.btn_show_data);
        et_email=(EditText)findViewById(R.id.et_email);
        et_name=(EditText)findViewById(R.id.et_name);
        et_password=(EditText)findViewById(R.id.et_password);
        et_re_password=(EditText)findViewById(R.id.et_re_password);

        btn.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        ds=DataSource.getInstance(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btn_browse) {
            AlertDialog dialog;
            String[] ar = {"Camera", "Gallery"};
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Choose a picture");

            //what to show inside the layout:

            LayoutInflater inflater = this.getLayoutInflater();
            final View dialogView = inflater.inflate(R.layout.activity_main, null);


            RecyclerView dialogList = (RecyclerView) dialogView.findViewById(R.id.lv);
            dialogList.setLayoutManager(new LinearLayoutManager(this));
            RecyclerAdapter adapter = new RecyclerAdapter(Main3Activity.this, ar,this);
            dialogList.setAdapter(adapter);
           /* dialogList.setOnC(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (position == 0) {
                        //cam clicked
                    } else if (position == 1) {
                        //gallery clicked
                    }
                }
            });*/
            builder.setView(dialogView);
            builder.setNegativeButton("cancel", null);
            //builder.setPositiveButton("yes",this);
            //builder.setMessage("ready??");
            dialog = builder.create();
            dialog.show();


        }
        else if(v.getId()==R.id.btn_register){
            if(et_password.getText().toString().equals(et_re_password.getText().toString())) {
                ds.insertIntoStudent(et_name.getText().toString(), et_email.getText().toString(), et_password.getText().toString());
                Toast.makeText(this, "data set: "+et_name.getText().toString()+ et_email.getText().toString()+ et_password.getText().toString(), Toast.LENGTH_SHORT).show();
            }

        }
        else if (v.getId()==R.id.btn_show_data) {
            AlertDialog dialog;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Data: ");

            //what to show inside the layout:

            LayoutInflater inflater = this.getLayoutInflater();
            final View dialogView = inflater.inflate(R.layout.activity_main, null);

            List<Model> myList=ds.getAllData();
            Toast.makeText(this, "items: "+myList.get(0), Toast.LENGTH_SHORT).show();

            ListView dialogList = (ListView) dialogView.findViewById(R.id.lv);

            MyAdapter1 adapter = new MyAdapter1(Main3Activity.this,myList);
            dialogList.setAdapter(adapter);
            dialogList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (position == 0) {
                        //cam clicked
                    } else if (position == 1) {
                        //gallery clicked
                    }
                }
            });
            builder.setView(dialogView);
            builder.setNegativeButton("cancel", null);
            //builder.setPositiveButton("yes",this);
            //builder.setMessage("ready??");
            dialog = builder.create();
            dialog.show();


        }
    }

    @Override
    public void onRecyclerItemClick(String arValue) {
    if(arValue.equalsIgnoreCase("Gallery")){
        Toast.makeText(this, "Gallery Clicked", Toast.LENGTH_SHORT).show();
    }
    }
}
