package com.example.testapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListActivity extends AppCompatActivity implements OnViewHolderListener {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Note> myNotes;

    private SessionApi mySessionApi;
    String mySessionResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        myNotes = new ArrayList<>();

        mRecyclerView = findViewById(R.id.recycler_view);

        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new MyAdapter(myNotes, this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        //создаем Retrofit и получаем сессию
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://bnet.i-partner.ru/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mySessionApi = retrofit.create(SessionApi.class);
        Call<MySession> call = mySessionApi.getSession("new_session");


        call.enqueue(new Callback<MySession>() {
            @Override
            public void onResponse(Call<MySession> call, Response<MySession> response) {
                if (response.isSuccessful()) {
                    mySessionResponse = response.body().data.session;
                    //Log.d("MySession", "My session is " + mySessionResponse);
                    getEntries();
                }
            }

            @Override
            public void onFailure(Call<MySession> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    //добавляем toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_toolbar, menu);
        return true;
    }

    //открываем второй экран
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.new_note:
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("mySession", mySessionResponse);
                startActivityForResult(intent,1);
                break;

            case R.id.add_note:
                Toast.makeText(this,"Add some notes", Toast.LENGTH_LONG).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    //получаем и отображаем данные из MainActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==1) {
            if (resultCode==RESULT_OK) {
                String result = data.getStringExtra("result");
                if (result != null) {
                    myNotes.add(new Note(result));
                    // обновляем recyclerView
                    mAdapter.notifyDataSetChanged();
                }
            }
        }
    }

    @Override
    public void onPostClick(int position) {
        myNotes.get(position);
        Intent intent = new Intent(this, SingleTextActivity.class);
        startActivity(intent);
    }
}