package com.example.unitconversionrapp.activities;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import androidx.lifecycle.LiveData;

import java.util.List;
@Dao
public interface UnitRecordDao {
    @Query("SELECT * FROM UnitRecord")
    LiveData<List<UnitRecord>> getRecordList();

    @Insert
    void insertRecord(UnitRecord unitRecord);

    @Update
    void updateRecord(UnitRecord unitRecord);

    @Delete
    void deleteRecord(UnitRecord unitRecord);
}
