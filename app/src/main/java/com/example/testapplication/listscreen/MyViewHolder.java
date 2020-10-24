package com.example.testapplication.listscreen;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapplication.R;

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    TextView textViewDa;
    TextView textViewDm;
    TextView textViewNote;

    OnViewHolderListener onViewHolderListener;

    public MyViewHolder(@NonNull View itemView, OnViewHolderListener onViewHolderListener) {
        super(itemView);
        textViewDa = itemView.findViewById(R.id.textView_da);
        textViewDm = itemView.findViewById(R.id.textView_dm);
        textViewNote = itemView.findViewById(R.id.textView_note);
        this.onViewHolderListener = onViewHolderListener;

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        onViewHolderListener.onPostClick(getAdapterPosition());

    }
}
