package com.example.testapplication.screens.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.testapplication.R;
import com.example.testapplication.screens.list.ListActivity;

public class DetailActivity extends AppCompatActivity {
    private TextView mSingleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mSingleTextView = findViewById(R.id.single_text);

        setupContent();
    }

    private void setupContent() {
        Intent intent = getIntent();
        String resultBody = intent.getStringExtra(ListActivity.INTENT_ENTRIES);
        String resultDa = intent.getStringExtra(ListActivity.INTENT_DA);
        String resultDm = intent.getStringExtra(ListActivity.INTENT_DM);

        String text = resultDa + "\n" + resultDm + "\n" + resultBody;

        mSingleTextView.setText(text);
    }
}