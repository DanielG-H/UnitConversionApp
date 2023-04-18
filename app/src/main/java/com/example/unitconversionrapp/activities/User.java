package com.example.unitconversionrapp.activities;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "User")
public class User {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "UserID")
    protected int UserID;

    @ColumnInfo(name = "Username")
    protected String Username;

    public User(String Username){
//        this.UserID = UserID;
        this.Username = Username;
    }

}