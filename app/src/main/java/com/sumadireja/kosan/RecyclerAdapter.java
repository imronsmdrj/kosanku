package com.sumadireja.kosan;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private final Context context;

    String [] name = {"Apple", "Facebook", "Twitter", "Google", "Mircosoft",
                    "Wikipedia", "Yahoo", "Youtube"};

    LayoutInflater inflater;
    public RecyclerAdapter(Context context){
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = inflater.inflate(R.layout.item_list, parent, false);

        RecyclerViewHolder viewHolder = new RecyclerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position){

        holder.tv1.setText(name[position]);
        holder.tv1.setOnClickListener(clickListener);
        holder.imageView.setOnClickListener(clickListener);
        holder.tv1.setTag(holder);
        holder.imageView.setTag(holder);
    }

    View.OnClickListener clickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            RecyclerViewHolder vholder = (RecyclerViewHolder) v.getTag();

            int position = vholder.getPosition();

            Toast.makeText(context, "Menu ini berada di posisi " + position, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public int getItemCount(){
        return name.length;
    }
}
