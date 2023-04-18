package com.example.unitconversionrapp.activities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


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