package com.york.myapplication.recycler;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.york.myapplication.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RcyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcycler);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        CustomRecyclerAdapter adapter = new CustomRecyclerAdapter(RcyclerActivity.this, getMockData());

        recyclerView.setAdapter(adapter);
    }

    private List<String> getMockData() {
        List<String> dataList = new ArrayList<String>();

        for (int i = 0; i < 100; i++) {
            int value = new Random().nextInt();
            dataList.add(String.valueOf(value));
        }

        return dataList;
    }
}