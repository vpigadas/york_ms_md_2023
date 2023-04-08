package com.york.myapplication.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void save(UserEntity user);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void save(UserEntity[] users);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void save(List<UserEntity> users);

//    @Insert
//    public void insert(UserEntity user) throws Exception;
//
//    @Update
//    public void update(UserEntity user) throws Exception;

    @Delete
    public void delete(UserEntity user);

    @Query("SELECT * FROM User")
    public List<UserEntity> get();

    @Query("SELECT * FROM User WHERE name LIKE :userName")
    public List<UserEntity> get(String userName);

    @Query("SELECT * FROM User WHERE name LIKE :userName LIMIT 1")
    public  UserEntity getFirst(String userName);
}
