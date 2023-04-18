package com.example.unitconversionrapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;


import android.os.Bundle;

import com.example.unitconversionrapp.Entities.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConversionViewModel viewModel = ViewModelProviders.of(this).get(ConversionViewModel.class);

        User Ximena = new User("Ximena");

        viewModel.insertUser(Ximena);

    }
}