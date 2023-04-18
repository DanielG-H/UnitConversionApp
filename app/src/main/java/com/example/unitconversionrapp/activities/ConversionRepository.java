package com.example.unitconversionrapp.activities;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.unitconversionrapp.activities.DatabaseRoom.ConversionDatabase;

import java.util.List;

public class ConversionRepository {

    UserDao userDao;
    UnitRecordDao unitRecordDao;

    ConversionRepository(Application application){
        ConversionDatabase db = ConversionDatabase.getDatabase(application);
        userDao = db.userDao();
        unitRecordDao = db.unitRecordDao();
    }

    // ---------- USERS ---------- //
    LiveData<List<User>> getUsers(){
        return userDao.getUserList();
    }

    void insertUser(User user){
        new insertAsyncTaskUser(userDao).execute(user);
    }

    // ---------- RECORDS ---------- ///
    LiveData<List<UnitRecord>> getRecords(){
        return unitRecordDao.getRecordList();
    }

    void insertRecord(UnitRecord unitRecord){
        new insertAsyncTaskRecord(unitRecordDao).execute(unitRecord);
    }

    private static class insertAsyncTaskUser extends AsyncTask<User, Void, Void>{
        private UserDao taskDao;

        insertAsyncTaskUser(UserDao userDao){
            taskDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            taskDao.insertUser(users[0]);
            return null;
        }

    }

    private static class insertAsyncTaskRecord extends AsyncTask<UnitRecord, Void, Void>{
        private UnitRecordDao taskDao;

        insertAsyncTaskRecord(UnitRecordDao unitRecordDao){
            taskDao = unitRecordDao;
        }

        @Override
        protected Void doInBackground(UnitRecord... records) {
            taskDao.insertRecord(records[0]);
            return null;
        }

    }

}
