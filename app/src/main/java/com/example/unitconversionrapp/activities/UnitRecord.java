package com.example.unitconversionrapp.activities;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


@Entity(tableName = "UnitRecord",
        foreignKeys = @ForeignKey( entity = User.class,
                parentColumns = "UserID",
                childColumns = "UserID",
                onDelete = ForeignKey.CASCADE))
public class UnitRecord {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "UnitRecordID")
    protected int UnitRecordID;

    @ColumnInfo(name = "UserID")
    protected int UserID;

    @ColumnInfo(name = "InitialUnitQuantity")
    protected double InitialUnitQuantity;

    @ColumnInfo(name = "InitialUnit")
    protected String InitialUnit;

    @ColumnInfo(name = "ConvertedUnitQuantity")
    protected double ConvertedUnitQuantity;

    @ColumnInfo(name = "ConvertedUnit")
    protected String ConvertedUnit;

    public UnitRecord(int UserID, double InitialUnitQuantity,
                      String InitialUnit, double ConvertedUnitQuantity,
                      String ConvertedUnit){
        this.UserID = UserID;
        this.InitialUnitQuantity = InitialUnitQuantity;
        this.InitialUnit = InitialUnit;
        this.ConvertedUnitQuantity = ConvertedUnitQuantity;
        this.ConvertedUnit = ConvertedUnit;
    }

}