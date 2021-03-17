package adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.risha.mylistview.R;

import listeners.IRecyclerItemClick;

/**
 * Created by risha on 31-Dec-17.
 */


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Holder> {
private final int text=0;
private final int Image=1;
private final Context context;
private final String[] ar;
private LayoutInflater inflater;
    private IRecyclerItemClick listener;
    public RecyclerAdapter(Context context, String ar[], IRecyclerItemClick listener) {
        this.context=context;
        this.ar=ar;
        this.listener=listener;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate
        inflater= LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.activity_main2,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        //data binding
        holder.tv.setText(ar[position]);
        holder.iv.setImageResource(R.mipmap.ic_launcher);
        holder.bindData(position);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {

        return position;
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView tv;
        ImageView iv;
        private int pos;
        public Holder(View itemView) {
            super(itemView);
            tv=(TextView)itemView.findViewById(R.id.tv);
            iv=(ImageView)itemView.findViewById(R.id.iv);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onRecyclerItemClick(ar[pos]);
                }
            });
        }
        public void bindData(int position){
            this.pos=position;
        }

    }
}
