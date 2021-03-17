package com.example.risha.register.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.risha.register.R;

/**
 * Created by risha on 28-Dec-17.
 */

public class MyListAdapter extends BaseAdapter {
    private Context context;
    private String[] ar;
    private LayoutInflater inflater;
    public MyListAdapter(Context context,String[] ar){
        this.context=context;
        this.ar=ar;
        inflater=LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        //Toast.makeText(context,""+ar.length, Toast.LENGTH_SHORT).show();
        return ar.length;
    }

    @Override
    public Object getItem(int position) {

        return position;
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            convertView =inflater.inflate(R.layout.item_view,parent,false);
            Holder h=new Holder();
            h.tv_itemName=(TextView)convertView.findViewById(R.id.tv);
            h.tv_itemName.setText(ar[position]);
        return convertView;
    }
    public class Holder{
        TextView tv_itemName;
    }
}
