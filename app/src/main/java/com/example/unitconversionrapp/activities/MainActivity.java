package com.example.unitconversionrapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.unitconversionrapp.R;
import com.example.unitconversionrapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerInitial;
    Spinner spinnerFinal;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        ConversionViewModel viewModel = new ViewModelProvider(this).get(ConversionViewModel.class);

        // Test user entry
//        User Ximena = new User("Ximena");
//        viewModel.insertUser(Ximena);
        Intent intent = getIntent();
        String username = intent.getStringExtra("NAME");

        User user = new User(username);
        viewModel.insertUser(user);


        // Test read Room LiveData (Plus)
//        viewModel.getUsers().observe(this, userList -> {
//            Log.d("Number of Users", ": " + userList.size());
//
//            for(User list: userList){
//                Log.d("users", list.Username);
//            }
//
//        });

        spinnerInitial = findViewById(R.id.SpinnerInitial);
        spinnerFinal = findViewById(R.id.SpinnerConverted);

        String[] items = getResources().getStringArray(R.array.unit_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);

        spinnerInitial.setAdapter(adapter);
        spinnerFinal.setAdapter(adapter);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double number = Double.parseDouble(binding.editText.getText().toString());

                

            }
        });

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