package com.example.smalu.policebank.modle;

import android.app.Application;

/**
 * Created by KL on 2016/11/25 0025.
 */

public class UserData extends Application {

    private String username;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
