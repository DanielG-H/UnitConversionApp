package com.example.unitconversionrapp.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(tableName = "ConversionFactor",
        foreignKeys = {
        @ForeignKey(entity = Measure.class,
                                  parentColumns = "MeasureID",
                                  childColumns = "InitialMeasureID",
                                  onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = Measure.class,
                                 parentColumns = "MeasureID",
                                 childColumns = "FinalMeasureID",
                                 onDelete = ForeignKey.CASCADE)
        })


public class ConversionFactor {
        @ColumnInfo
        protected int InitialMeasureID;

        @ColumnInfo
        protected int FinalMeasureID;

        @ColumnInfo
        protected double Factor;

}
