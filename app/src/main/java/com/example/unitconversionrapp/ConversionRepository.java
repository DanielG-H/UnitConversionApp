package com.example.unitconversionrapp;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.unitconversionrapp.DAOs.DaoUser;
import com.example.unitconversionrapp.DatabaseRoom.ConversionDatabase;
import com.example.unitconversionrapp.Entities.User;

import java.util.List;

public class ConversionRepository {
    DaoUser userDao;

    ConversionRepository(Application application){
        ConversionDatabase db = ConversionDatabase.getDatabase(application);
        userDao = db.userDao();
    }

    LiveData<List<User>> getUsers(){
        return userDao.getUserList();
    }

    void insertUser(User user){
        new insertAsyncTask(userDao).execute(user);
    }

    private static class insertAsyncTask extends AsyncTask<User, Void, Void> {
        private DaoUser taskDao;

        insertAsyncTask(DaoUser userDao){
            taskDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            taskDao.insertUser(users[0]);
            return null;
        }
    }
}
