package com.example.unitconversionrapp.activities;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ConversionRepository {

    UserDao userDao;
    UnitRecordDao unitRecordDao;

    ConversionRepository(Application application){
        ConversionDatabase db = ConversionDatabase.getDatabase(application);
        userDao = db.userDao();
        unitRecordDao = db.unitRecordDao();
    }

    LiveData<List<User>> getUsers(){
        return userDao.getUserList();
    }

    void insertUser(User user){
        new insertAsyncTask(userDao).execute(user);
    }

    LiveData<List<UnitRecord>> getRecords(){
        return unitRecordDao.getRecordList();
    }

    private static class insertAsyncTask extends AsyncTask<User, Void, Void>{
        private UserDao taskDao;

        insertAsyncTask(UserDao userDao){
            taskDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            taskDao.insertUser(users[0]);
            return null;
        }
    }
}
