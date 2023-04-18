package com.example.unitconversionrapp.activities;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

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
