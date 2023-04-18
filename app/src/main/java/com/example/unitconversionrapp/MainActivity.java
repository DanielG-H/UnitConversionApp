package com.example.unitconversionrapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.unitconversionrapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerInitial;
    Spinner spinnerFinal;

    Button calculateBtn;

    EditText firstUQ;

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ConversionViewModel viewModel = ViewModelProviders.of(this).get(ConversionViewModel.class);

        spinnerInitial = binding.SpinnerInitial;
        spinnerFinal = binding.SpinnerConverted;
        calculateBtn = binding.button;
        firstUQ = binding.edFirstUQ;


        String[] items = getResources().getStringArray(R.array.unit_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinnerInitial.setAdapter(adapter);
        spinnerFinal.setAdapter(adapter);

    }

    public double getConversion(){
        String spInitialValue = spinnerInitial.getSelectedItem().toString();
        String spFinalValue = spinnerFinal.getSelectedItem().toString();
        UnitConverter converter = new UnitConverter();
        return converter.getConversion(Double.parseDouble(firstUQ.getText().toString()), spInitialValue, spFinalValue);

    }
}