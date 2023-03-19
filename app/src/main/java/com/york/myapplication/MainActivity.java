package com.york.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        Button btn = findViewById(R.id.btn_login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("App", "Button clicked!!!");
                Toast.makeText(MainActivity.this, "Btn Clicked", Toast.LENGTH_LONG).show();
                Snackbar.make(v, "Btn Clicked", Snackbar.LENGTH_LONG).show();
            }
        });

        TextView txt = findViewById(R.id.txn_title);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("App", "TextView clicked!!!");
                Toast.makeText(MainActivity.this, "TextView Clicked", Toast.LENGTH_LONG).show();
                Snackbar.make(v, "TextView Clicked", Snackbar.LENGTH_LONG).show();
            }
        });
    }
}