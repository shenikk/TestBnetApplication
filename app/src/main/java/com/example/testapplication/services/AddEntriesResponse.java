package com.example.testapplication.services;

public class AddEntriesResponse {

    private String session;
    private String body;

    public AddEntriesResponse(String session, String body) {
        this.session = session;
        this.body = body;
    }
}
