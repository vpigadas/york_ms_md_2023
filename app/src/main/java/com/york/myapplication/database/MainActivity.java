package com.york.myapplication.database;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.york.myapplication.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        DatabaseIntance instance = Room.databaseBuilder(this, DatabaseIntance.class, "db")
                .build();


        AsyncTaskRetrieve async = new AsyncTaskRetrieve(new AsyncTaskRetrieve.Listener() {
            @Override
            public void onSuccess(List<UserEntity> array) {

            }
        }, instance);
        async.execute();


        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("age", 100);
        editor.commit();
//        editor.apply();

        SharedPreferences sharedPreferences = getSharedPreferences("preferences",MODE_PRIVATE);
        SharedPreferences.Editor editor1 = sharedPreferences.edit();
        editor1.putInt("age", 100);
//        editor1.commit();
        editor1.apply();
    }
}