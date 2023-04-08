package com.york.myapplication.recycler;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.york.myapplication.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RcyclerActivity extends AppCompatActivity {

    private CustomListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcycler);

        adapter = new CustomListAdapter(new CustomListAdapter.DiffItemUtils());
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        //CustomRecyclerAdapter2 adapter = new CustomRecyclerAdapter2(getMockData());
        recyclerView.setAdapter(adapter);

        findViewById(R.id.fab_plus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> currentList = adapter.getCurrentList();

                List<String> data = getMockData(4);
                data.addAll(currentList);

                adapter.submitList(data);
            }
        });
    }

    private List<String> getMockData() {
        List<String> dataList = new ArrayList<String>();

        for (int i = 0; i < 100; i++) {
            int value = new Random().nextInt();
            dataList.add(String.valueOf(value));
        }

        return dataList;
    }

    private List<String> getMockData(int count) {
        List<String> dataList = new ArrayList<String>();

        for (int i = 0; i < count; i++) {
            int value = new Random().nextInt();
            dataList.add(String.valueOf(value));
        }

        return dataList;
    }
}