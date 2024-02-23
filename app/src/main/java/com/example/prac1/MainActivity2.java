package com.example.prac1;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prac1.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String initialData = getIntent().getStringExtra("navigate");
        binding.resultText.setText(initialData);
        binding.buttonBack.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.putExtra("result", "Navigate Back");
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}