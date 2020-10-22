package com.example.testapplication;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView textViewDa;
    TextView textViewDm;
    TextView textViewNote;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewDa = itemView.findViewById(R.id.textView_da);
        textViewDm = itemView.findViewById(R.id.textView_dm);
        textViewNote = itemView.findViewById(R.id.textView_note);
    }
}
