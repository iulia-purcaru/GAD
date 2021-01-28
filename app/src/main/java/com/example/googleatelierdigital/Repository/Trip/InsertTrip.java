package com.example.googleatelierdigital.Repository.Trip;

import android.os.AsyncTask;

import com.example.googleatelierdigital.Database.DatabaseInstance;
import com.example.googleatelierdigital.Model.Trip;
import com.example.googleatelierdigital.Model.User;
import com.example.googleatelierdigital.Repository.User.OnUserRepositoryActionListener;

public class InsertTrip extends AsyncTask<Trip, Void, Void> {

    private OnTripRepositoryActionListener listener;

    InsertTrip(OnTripRepositoryActionListener listener) {
        this.listener = listener;
    }

    @Override
    protected Void doInBackground(Trip... trips) {
        DatabaseInstance.getAppDatabase().tripDao().insertTrip(trips[0]);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}
