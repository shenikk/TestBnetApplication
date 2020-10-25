package com.example.testapplication.screens.list;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapplication.R;

public class NoteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private TextView textViewDa;
    private TextView textViewDm;
    private TextView textViewNote;

    private OnViewHolderListener onViewHolderListener;

    public NoteViewHolder(@NonNull View itemView, OnViewHolderListener onViewHolderListener) {
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

    public void configure(Note note) {

        if (!note.getDa().equals(note.getDm())) {
            textViewDm.setText("дата модификации: " + note.getDm());
        } else {
            textViewDa.setText("");
        }
        textViewDa.setText("дата создания: " + note.getDa());
        textViewNote.setText(note.getBody());
    }
}
