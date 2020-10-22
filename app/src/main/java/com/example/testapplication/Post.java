package com.example.testapplication;

import com.google.gson.annotations.SerializedName;

public class Post {

    private String session;
    private String body;

    public Post(String session, String body) {
        this.session = session;
        this.body = body;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
