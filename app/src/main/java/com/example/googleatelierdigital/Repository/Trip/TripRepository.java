package com.example.googleatelierdigital.Repository.Trip;

import android.content.Context;

import com.example.googleatelierdigital.ActionListener;
import com.example.googleatelierdigital.Database.Database;
import com.example.googleatelierdigital.DatabaseInstance;
import com.example.googleatelierdigital.Model.Trip;
import com.example.googleatelierdigital.Model.User;

import java.util.List;

public class TripRepository {
    private Database appDatabase;

    public TripRepository(Context context){appDatabase = DatabaseInstance.getAppDatabase(); }

    public void insertTrip(final Trip trip, final ActionListener listener){
        new InsertTrip(listener).execute(trip);
    }

    public Trip getTrip(int tripId) {
        return appDatabase.tripDao().getTrip(tripId);
    }

    public Trip getTripByName(String name) {
        return appDatabase.tripDao().getTripByName(name);
    }

    public List<Trip> getTrips() {
        return appDatabase.tripDao().getAllTrips();
    }

    public void deleteTrip (Trip trip)
    {
        appDatabase.tripDao().delete(trip);
    }

    public List<Trip> getTripsByUserId(int userId) {
        return appDatabase.tripDao().getAllTripsByUserId(userId);
    }
}
