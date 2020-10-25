package com.example.testapplication.services;

import com.example.testapplication.screens.list.Note;

import java.util.ArrayList;

public class GetEntriesResponse {
    public ArrayList<ArrayList<Note>> data;
    public ArrayList<ArrayList<Note>> getData() {
        return data;
    }
}
