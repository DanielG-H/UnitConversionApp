package com.example.unitconversionrapp.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "User")
public class User {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "UserID")
    public int UserID;

    @ColumnInfo(name = "Username")
    public String Username;

    public User(String Username){
        this.Username = Username;
    }

}

