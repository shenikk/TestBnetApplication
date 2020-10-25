package com.example.testapplication.detailscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.testapplication.R;

public class DetailActivity extends AppCompatActivity {
    TextView mSingleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mSingleTextView = findViewById(R.id.single_text);

        Intent intent = getIntent();
        String resultBody = intent.getStringExtra("MyEntries");
        String resultDa = intent.getStringExtra("MyDa");
        String resultDm = intent.getStringExtra("MyDm");

        String text = resultDa + "\n" + resultDm + "\n" + resultBody;

        mSingleTextView.setText(text);
    }
}