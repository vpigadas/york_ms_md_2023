package com.york.myapplication.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity( tableName = "User")
public class UserEntity {

    @ColumnInfo(name = "name")
    @PrimaryKey
    public String name;
    @ColumnInfo(name = "age")
    public int age;
    @ColumnInfo(name = "job")
    public String job;
}
