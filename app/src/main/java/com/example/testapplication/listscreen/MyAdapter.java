package com.example.testapplication.listscreen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapplication.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<Note> notes;
    private OnViewHolderListener onViewHolderListener;

    public MyAdapter(List<Note> notes, OnViewHolderListener onViewHolderListener) {
        this.notes = notes;
        this.onViewHolderListener = onViewHolderListener;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_note, parent,false);
        MyViewHolder mvh = new MyViewHolder(view, onViewHolderListener);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Note currentNote = notes.get(position);
        holder.textViewDa.setText(currentNote.getDa());
        holder.textViewDm.setText(currentNote.getDm());
        holder.textViewNote.setText(currentNote.getBody());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}
