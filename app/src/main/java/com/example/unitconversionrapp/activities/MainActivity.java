package com.example.unitconversionrapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.arch.persistence.room.Room;
import android.os.Bundle;

import com.example.unitconversionrapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConversionViewModel viewModel = ViewModelProviders.of(this).get(ConversionViewModel.class);

        User Ximena = new User("Ximena");
        UnitRecord record_test = new UnitRecord(0, 3.0,"Meter", 300.0, "Centimeter");

        viewModel.insertUser(Ximena);

    }
}