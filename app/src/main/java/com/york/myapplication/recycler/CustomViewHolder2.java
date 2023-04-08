package com.york.myapplication.recycler;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.york.myapplication.R;

public class CustomViewHolder2 extends RecyclerView.ViewHolder {

    private TextView textView;

    public CustomViewHolder2(@NonNull View itemView) {
        super(itemView);

        textView = itemView.findViewById(R.id.holder_txt);
    }

    public void bind(String data) {
        textView.setText(data);
    }

    public TextView getTextView() {
        return textView;
    }
}
