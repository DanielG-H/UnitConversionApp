package com.example.unitconversionrapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.unitconversionrapp.R;
import com.example.unitconversionrapp.databinding.ActivityLoadingScreenBinding;

public class LoadingScreen extends AppCompatActivity {
    ActivityLoadingScreenBinding binding;
    private final String TAG = "LoadingScreen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoadingScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Glide.with(this).load(R.drawable.ic_convert_arrows).into(binding.appLogo);

        binding.start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isUsernameValid();
            }
        });
    }

    protected void isUsernameValid() {
       String username = (binding.nameEt).getText().toString();
        Log.d(TAG, "Username: " + username);
        if (TextUtils.isEmpty(username)) {
           Toast.makeText(this, "Enter a valid username", Toast.LENGTH_LONG).show();
       } else {

           startIntent();
           Log.d(TAG, "Goes to main screen");
       }
    }

    private void startIntent() {
        Intent i = new Intent(LoadingScreen.this, MainActivity.class);
        i.putExtra("NAME", binding.nameEt.getText().toString());
        startActivity(i);
    }
}