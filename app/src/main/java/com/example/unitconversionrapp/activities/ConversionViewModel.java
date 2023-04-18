package com.example.unitconversionrapp.activities;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ConversionViewModel extends AndroidViewModel {

    ConversionRepository repository;
    LiveData<List<User>> userList;
    LiveData<List<UnitRecord>> recordList;

    public ConversionViewModel(Application application){
        super(application);
        repository = new ConversionRepository(application);
        userList = repository.getUsers();
        recordList = repository.getRecords();
    }

    LiveData<List<User>> getUsers(){
        return userList;
    }

    public void insertUser(User user){
        repository.insertUser(user);
    }

    LiveData<List<UnitRecord>> getRecords(){
        return recordList;
    }


}
