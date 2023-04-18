package com.example.unitconversionrapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.unitconversionrapp.R;
import com.example.unitconversionrapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";

    private String username;
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

        ConversionViewModel viewModel = new ViewModelProvider(this).get(ConversionViewModel.class);

        Intent intent = getIntent();
        username = intent.getStringExtra("NAME");

        User user = new User(username);
        viewModel.insertUser(user);

        spinnerInitial = binding.SpinnerInitial;
        spinnerFinal = binding.SpinnerConverted;
        calculateBtn = binding.button;
        firstUQ = binding.editText;

        String[] items = getResources().getStringArray(R.array.unit_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinnerInitial.setAdapter(adapter);
        spinnerFinal.setAdapter(adapter);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double result = getConversion();
                binding.resultTv.setText(String.valueOf(result));
                UnitRecord record_test = new UnitRecord(username, Double.parseDouble(firstUQ.getText().toString()),
                        spinnerInitial.getSelectedItem().toString(), result, spinnerFinal.getSelectedItem().toString());
                viewModel.insertRecord(record_test);
            }
        });
    }

    public double getConversion() {
        String spInitialValue = spinnerInitial.getSelectedItem().toString();
        String spFinalValue = spinnerFinal.getSelectedItem().toString();
        UnitConverter converter = new UnitConverter();
        double result = 0.0;
        try {
            result = converter.getConversion(Double.parseDouble(firstUQ.getText().toString()), spInitialValue, spFinalValue);
        } catch (Exception e) {
            Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_LONG).show();
        }
        return result;
    }
}