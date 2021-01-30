package com.example.googleatelierdigital.Repository.Trip;

import android.content.Context;

import com.example.googleatelierdigital.ActionListener;
import com.example.googleatelierdigital.Database.Database;
import com.example.googleatelierdigital.DatabaseInstance;
import com.example.googleatelierdigital.Model.Trip;

public class TripRepository {
    private Database appDatabase;

    public TripRepository(Context context){appDatabase = DatabaseInstance.getAppDatabase(); }

    public void insertTrip(final Trip trip, final ActionListener listener){
        new InsertTrip(listener).execute(trip);
    }
}
