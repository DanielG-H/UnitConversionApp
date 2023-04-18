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

        User Ximena = new User("Ximena");
        UnitRecord record_test = new UnitRecord(0, 3.0,"Meter", 300.0, "Centimeter");

        viewModel.insertUser(Ximena);

    }
}