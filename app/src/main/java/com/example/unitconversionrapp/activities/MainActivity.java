package com.example.unitconversionrapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.unitconversionrapp.R;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerInitial;
    Spinner spinnerFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ConversionViewModel viewModel = new ViewModelProvider(this).get(ConversionViewModel.class);

        // Test user entry
//        User Ximena = new User("Ximena");
//        viewModel.insertUser(Ximena);

        // Test record entry
//        UnitRecord record_test = new UnitRecord(1, 3.0,"Meter", 300.0, "Centimeter");
//        viewModel.insertRecord(record_test);


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