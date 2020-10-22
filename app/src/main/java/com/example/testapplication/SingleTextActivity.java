package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SingleTextActivity extends AppCompatActivity {
    TextView mSingleTextiew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_text);

        mSingleTextiew = findViewById(R.id.single_text);
    }
}