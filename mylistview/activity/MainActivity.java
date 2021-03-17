package com.example.risha.mylistview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.risha.mylistview.R;
import adapters.MyAdapter;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] ar={"Camera","Gallery"};
    ListView lv;
    MyAdapter m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.lv);
        m=new MyAdapter(this,ar);
        lv.setAdapter(m);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
