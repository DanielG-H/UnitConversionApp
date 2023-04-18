package com.example.unitconversionrapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.unitconversionrapp.R;
import com.example.unitconversionrapp.databinding.ActivityLoadingBinding;


public class LoadingActivity extends AppCompatActivity {

    ActivityLoadingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        binding = ActivityLoadingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}