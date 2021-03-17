package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.risha.mylistview.R;

import java.util.ArrayList;

import utils.Model;

/**
 * Created by risha on 29-Dec-17.
 */

public class MyAdapter extends BaseAdapter {

    private String[] ar;
    Context context;
    private LayoutInflater inflater;
    public MyAdapter(Context context,String[] ar){
        this.context=context;
        this.ar=ar;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
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
        convertView =inflater.inflate(R.layout.activity_main2,parent,false);
        Holder h=new Holder();  //to save whatever to show in item
        h.tv_itemName=(TextView)convertView.findViewById(R.id.tv);
        h.iv_image=(ImageView)convertView.findViewById(R.id.iv);

        //Model model=list.get(position);
        // setText()--> model.getNAME();  model.getEMAIL(); model.getIMAGE_PATH();
        //for a button show data.
        h.tv_itemName.setText(ar[position]);
        if(position==0){
            h.iv_image.setImageResource(R.drawable.cam);
        }
        else if(position==1){
            h.iv_image.setImageResource(R.drawable.gal);
        }
        return convertView;
    }
    public class Holder{
        ImageView iv_image;
        TextView tv_itemName;
    }
}
