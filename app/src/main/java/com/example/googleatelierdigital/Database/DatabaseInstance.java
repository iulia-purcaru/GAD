package com.example.googleatelierdigital.Database;

import androidx.room.Room;

import com.example.googleatelierdigital.Application;

public class DatabaseInstance extends Application {

    private static DatabaseInstance instance;
    private static Database database;

    public static DatabaseInstance getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance  = this;

        database = Room.databaseBuilder(getApplicationContext(),
                Database.class, "database.db").allowMainThreadQueries().build();

    }

    public static Database getAppDatabase(){
        return database;
    }
}
