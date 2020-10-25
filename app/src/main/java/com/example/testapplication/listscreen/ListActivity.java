package com.example.testapplication.listScreen;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.testapplication.GetEntriesResponse;
import com.example.testapplication.GetEntries;
import com.example.testapplication.edittextscreen.EditTextActivity;
import com.example.testapplication.BnetSessionResponse;
import com.example.testapplication.R;
import com.example.testapplication.BnetSession;
import com.example.testapplication.detailscreen.DetailActivity;

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
    private String baseUrl = "https://bnet.i-partner.ru/";


    private BnetSession myBnetSession;
    private String mySessionResponse;

    private GetEntries getEntries;
    private GetEntriesResponse getEntriesResponse;

    public static final String INTENT_DA = "IntentDa";
    public static final String INTENT_DM = "IntentDm";
    public static final String INTENT_ENTRIES = "IntentEntries";
    public static final String INTENT_SESSION = "IntentSession";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        myNotes = new ArrayList<>();

        mRecyclerView = findViewById(R.id.recycler_view);

        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new NoteAdapter(myNotes, this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


        /* создаем Retrofit и получаем сессию */
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myBnetSession = retrofit.create(BnetSession.class);
        getEntries = retrofit.create(GetEntries.class);

        getSession();
    }

    /* получаем и отображаем данные из EditTextActivity */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==1) {
            if (resultCode==RESULT_OK) {
                getEntries();
            }
        }
    }

    /* добавляем toolbar */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_toolbar, menu);
        return true;
    }

    /* открываем второй экран */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.new_note) {
            Intent intent = new Intent(this, EditTextActivity.class);
            intent.putExtra(INTENT_SESSION, mySessionResponse);
            startActivityForResult(intent, 1);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPostClick(int position) {
        myNotes.get(position);
        Intent intent = new Intent(this, DetailActivity.class);

        intent.putExtra(INTENT_DA, myNotes.get(position).da);
        intent.putExtra(INTENT_DM, myNotes.get(position).dm);
        intent.putExtra(INTENT_ENTRIES, myNotes.get(position).body);

        startActivity(intent);
    }

    /* получаем сессию */
    private void getSession() {
        Call<BnetSessionResponse> call = myBnetSession.getSession("new_session");

        call.enqueue(new Callback<BnetSessionResponse>() {
            @Override
            public void onResponse(Call<BnetSessionResponse> call, Response<BnetSessionResponse> response) {
                if (response.isSuccessful()) {
                    mySessionResponse = response.body().data.session;
                }
            }
            @Override
            public void onFailure(Call<BnetSessionResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    /* получаем ранее введенные данные */
    private void getEntries() {
        Call<GetEntriesResponse> call = getEntries.getEntry("get_entries", mySessionResponse+"");

        call.enqueue(new Callback<GetEntriesResponse>() {
            @Override
            public void onResponse(Call<GetEntriesResponse> call, Response<GetEntriesResponse> response) {
                if (response.isSuccessful()) {
                    getEntriesResponse = response.body();

                    myNotes.clear();
                    myNotes.addAll(getEntriesResponse.getData().get(0));

                    mAdapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onFailure(Call<GetEntriesResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}