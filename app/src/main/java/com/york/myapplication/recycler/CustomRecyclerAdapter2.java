package com.york.myapplication.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.york.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class CustomRecyclerAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> arrayData = new ArrayList<String>();

    public CustomRecyclerAdapter2(List<String> arrayData) {
        this.arrayData = arrayData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        if (viewType == R.layout.holder_item_view) {
            return new CustomViewHolder(view);
        } else {
            return new CustomViewHolder2(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        String item = arrayData.get(position);
        if (holder instanceof CustomViewHolder) {
            ((CustomViewHolder) holder).bind(item);
        } else if (holder instanceof CustomViewHolder2) {
            ((CustomViewHolder2) holder).bind(item);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return R.layout.holder_item_view;
        } else {
            return R.layout.holder_item_view_2;
        }
    }

    @Override
    public int getItemCount() {
        return arrayData.size();
    }
}
