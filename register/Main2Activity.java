package com.example.risha.register;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.risha.register.adapters.MyListAdapter;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ArrayList<String> al=new ArrayList<>();//array list of Strings <dynamic hai ye>

    String[] ar={"abc","def","ghi","jkl","mno","pqr","stu","vwx","yz"};
    ListView lv;
    MyListAdapter m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lv=(ListView)findViewById(R.id.lv);
        al.add("abc");
        m=new MyListAdapter(this,ar);
        lv.setAdapter(m);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
