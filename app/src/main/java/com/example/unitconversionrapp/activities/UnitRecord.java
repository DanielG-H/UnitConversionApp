package com.example.unitconversionrapp.activities;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.example.unitconversionrapp.activities.User;


@Entity(tableName = "UnitRecord")
public class UnitRecord {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "UnitRecordID")
    protected int UnitRecordID;

    @ColumnInfo(name = "Username")
    protected String Username;

    @ColumnInfo(name = "InitialUnitQuantity")
    protected double InitialUnitQuantity;

    @ColumnInfo(name = "InitialUnit")
    protected String InitialUnit;

    @ColumnInfo(name = "ConvertedUnitQuantity")
    protected double ConvertedUnitQuantity;

    @ColumnInfo(name = "ConvertedUnit")
    protected String ConvertedUnit;

    public UnitRecord(String Username, double InitialUnitQuantity,
                      String InitialUnit, double ConvertedUnitQuantity,
                      String ConvertedUnit){
        this.Username = Username;
        this.InitialUnitQuantity = InitialUnitQuantity;
        this.InitialUnit = InitialUnit;
        this.ConvertedUnitQuantity = ConvertedUnitQuantity;
        this.ConvertedUnit = ConvertedUnit;
    }

}