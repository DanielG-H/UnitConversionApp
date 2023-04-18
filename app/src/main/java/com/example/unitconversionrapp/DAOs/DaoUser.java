package com.example.unitconversionrapp.DAOs;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.unitconversionrapp.Entities.User;

import java.util.List;

@Dao
public interface DaoUser {

    @Query("SELECT * FROM User")
    LiveData<List<User>> getUserList();

    @Insert
    void insertUser(User user);

    @Update
    void updateUser(User user);

    @Delete
    void deleteUser(User user);
}
