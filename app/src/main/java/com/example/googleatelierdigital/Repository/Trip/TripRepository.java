package com.example.googleatelierdigital.Repository.Trip;

import android.content.Context;

import com.example.googleatelierdigital.Database.Database;
import com.example.googleatelierdigital.Database.DatabaseInstance;
import com.example.googleatelierdigital.Model.Trip;
import com.example.googleatelierdigital.Model.User;
import com.example.googleatelierdigital.Repository.User.InsertTask;
import com.example.googleatelierdigital.Repository.User.OnUserRepositoryActionListener;

public class TripRepository {
    private Database appDatabase;

    public TripRepository(Context context){appDatabase = DatabaseInstance.getAppDatabase(); }

    public void insertTask(final Trip trip, final OnTripRepositoryActionListener listener){
        new InsertTrip(listener).execute(trip);
    }
}
