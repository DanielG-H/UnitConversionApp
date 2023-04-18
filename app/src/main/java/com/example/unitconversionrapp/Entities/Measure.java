package com.example.unitconversionrapp.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Measure {

    @PrimaryKey(autoGenerate = true)
    public int MeasureID;

    @ColumnInfo (name = "MeasureName" )
    public String MeasureName;

    public Measure(String MeasureName){
        this.MeasureName = MeasureName;
    }
}
