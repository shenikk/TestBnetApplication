package com.example.testapplication;

import java.util.ArrayList;

public class Entries {

    int status;
    ArrayList<ArrayList<MData>> data;

    public int getStatus() {
        return status;
    }

    public ArrayList<ArrayList<MData>> getData() {
        return data;
    }

    public class MData {
        String id;
        String body;
        String da;
        String dm;

        public String getId() {
            return id;
        }

        public String getBody() {
            return body;
        }

        public String getDa() {
            return da;
        }

        public String getDm() {
            return dm;
        }
    }
}
