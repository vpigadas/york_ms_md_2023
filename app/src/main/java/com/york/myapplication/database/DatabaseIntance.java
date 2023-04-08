package com.york.myapplication.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {UserEntity.class}, version = 1)
public abstract class DatabaseIntance extends RoomDatabase {

    public abstract UserDao getUserDao();
}
