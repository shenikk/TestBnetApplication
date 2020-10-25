package com.example.testapplication.edittextscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testapplication.AddEntries;
import com.example.testapplication.Post;
import com.example.testapplication.R;
import com.example.testapplication.listScreen.ListActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EditTextActivity extends AppCompatActivity {
    EditText mEditText;
    Button mButtonSave;
    Button mButtonCancel;
    private AddEntries addEntries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        //инициализация View
        mEditText = (EditText) findViewById(R.id.editText);
        mButtonSave = (Button) findViewById(R.id.button1);
        mButtonCancel = (Button) findViewById(R.id.button2);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://bnet.i-partner.ru/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        addEntries = retrofit.create(AddEntries.class);

        mButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mEditText.getText().toString().isEmpty()) {
                    createPost();
                } else {
                    Toast.makeText(getApplicationContext(), "Введите текст!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void createPost() {

        //получаем сессию
        Intent intent = getIntent();
        String session = intent.getStringExtra("mySession");

        Call<Post> call = addEntries.createPost("add_entry", session+"", mEditText.getText().toString()+"");

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Log.d("MyTag", "Получили response");

                if (response.isSuccessful()) {
                    Post postResponse = response.body();

                    //передаем данные первому экрану
                    Intent resultIntent = new Intent(getBaseContext(), ListActivity.class);
                    resultIntent.putExtra("result", mEditText.getText().toString());
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                mEditText.setText(t.getMessage());
                Log.d("MyTag", "Получили ошибку");
            }
        });
    }
}