package com.example.unitconversionrapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.unitconversionrapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConversionViewModel viewModel = new ViewModelProvider(this).get(ConversionViewModel.class);

        // Test user entry
//        User Ximena = new User("Ximena");
//        viewModel.insertUser(Ximena);

        // Test record entry
        UnitRecord record_test = new UnitRecord(1, 3.0,"Meter", 300.0, "Centimeter");
        viewModel.insertRecord(record_test);


        // Test read Room LiveData (Plus)
//        viewModel.getUsers().observe(this, userList -> {
//            Log.d("Number of Users", ": " + userList.size());
//
//            for(User list: userList){
//                Log.d("users", list.Username);
//            }
//
//        });

    }
}