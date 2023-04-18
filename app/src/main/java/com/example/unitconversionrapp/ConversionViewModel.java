package com.example.unitconversionrapp;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.unitconversionrapp.Entities.User;

import java.util.List;

public class ConversionViewModel extends AndroidViewModel {
    ConversionRepository repository;
    LiveData<List<User>> userList;


    public ConversionViewModel(Application application){
        super(application);
        repository = new ConversionRepository(application);
        userList = repository.getUsers();
    }

    LiveData<List<User>> getUsers(){
        return userList;
    }

    public void insertUser(User user){
        repository.insertUser(user);
    }
}
