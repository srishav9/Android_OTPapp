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
import java.util.List;

import utils.Model;

/**
 * Created by risha on 29-Dec-17.
 */

public class MyAdapter1 extends BaseAdapter{
    private List<Model> mylist;
    private Context context;


    private LayoutInflater inflater;
    public MyAdapter1(Context context, List<Model> mylist){
        this.context=context;
        this.mylist=mylist;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return mylist.size();
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
        convertView =inflater.inflate(R.layout.data_view,parent,false);
        MyAdapter1.Holder h=new MyAdapter1.Holder();
        h.tv_name=(TextView)convertView.findViewById(R.id.tv_name);
        h.tv_email=(TextView)convertView.findViewById(R.id.tv_email);
       // h.image=(ImageView)convertView.findViewById(R.id.iv_display);

        Model model=mylist.get(position);

        h.tv_name.setText(model.getNAME());
        h.tv_email.setText(model.getEMAIL());
       // h.image.setImageResource(R.mipmap.ic_launcher_round);
        //for a button show data.

        return convertView;
    }
    public class Holder{
       // ImageView image;
        TextView tv_name;
        TextView tv_email;
        //TextView tv_password;
        //TextView tv_image_path;
    }
}
