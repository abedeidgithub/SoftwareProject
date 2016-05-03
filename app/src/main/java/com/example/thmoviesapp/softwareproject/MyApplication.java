package com.example.thmoviesapp.softwareproject;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Abed Eid on 01/05/2016.
 */
public class MyApplication extends Application {

    Firebase firebase;
    @Override
    public void onCreate() {
        super.onCreate();
        firebase.setAndroidContext(this);
    }
}
