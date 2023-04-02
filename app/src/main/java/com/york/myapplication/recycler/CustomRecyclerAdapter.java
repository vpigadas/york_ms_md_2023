package com.york.myapplication.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.york.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private List<String> arrayData = new ArrayList<String>();
    private Context context;

    public CustomRecyclerAdapter(Context context,List<String> arrayData) {
        this.context = context;
        this.arrayData = arrayData;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.holder_item_view, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        String item = arrayData.get(position);

//        TextView textView = holder.itemView.findViewById(R.id.txn_title);
//        textView.setText(item);

//        holder.getTextView().setText(item);

        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return arrayData.size();
    }
}
