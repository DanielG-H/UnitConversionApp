package com.example.unitconversionrapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.unitconversionrapp.Entities.User;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerInitial;
    Spinner spinnerFinal;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConversionViewModel viewModel = ViewModelProviders.of(this).get(ConversionViewModel.class);

        spinnerInitial = findViewById(R.id.SpinnerInitial);
        spinnerFinal = findViewById(R.id.SpinnerConverted);

//        User Ximena = new User("Ximena");
//
//        viewModel.insertUser(Ximena);

        String[] items = getResources().getStringArray(R.array.unit_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinnerInitial.setAdapter(adapter);
        spinnerFinal.setAdapter(adapter);

        spinnerInitial.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Handle the user's selection here
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

    }




}