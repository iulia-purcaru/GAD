package com.example.googleatelierdigital;

import android.app.Application;

import androidx.room.Room;

import com.example.googleatelierdigital.Database.Database;

public class DatabaseInstance extends Application {

    private static DatabaseInstance mInstance;

    private static Database mAppDatabase;

    public static DatabaseInstance getInstance(){
        return  mInstance;
    }

    @Override
    public void onCreate() {

        super.onCreate();

        mInstance  = this;

        mAppDatabase = Room.databaseBuilder(getApplicationContext(),
                Database.class, Constants.DB_NAME).allowMainThreadQueries().build();
    }

    public static Database getAppDatabase(){
        return mAppDatabase;
    }
}