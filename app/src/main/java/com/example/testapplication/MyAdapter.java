package com.example.testapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

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
//        holder.textViewDa.setText(currentNote.getDa().toString());
//        holder.textViewDm.setText(currentNote.getDm().toString());
        holder.textViewNote.setText(currentNote.getText());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}
