package com.example.testapplication.listScreen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapplication.R;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteViewHolder> {

    private List<Note> notes;
    private OnViewHolderListener onViewHolderListener;

    public NoteAdapter(List<Note> notes, OnViewHolderListener onViewHolderListener) {
        this.notes = notes;
        this.onViewHolderListener = onViewHolderListener;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_note, parent,false);
        return new NoteViewHolder(view, onViewHolderListener);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note currentNote = notes.get(position);
        holder.configure(currentNote);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}
