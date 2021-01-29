package com.example.googleatelierdigital.Repository.Trip;

import android.os.AsyncTask;

import com.example.googleatelierdigital.ActionListener;
import com.example.googleatelierdigital.DatabaseInstance;
import com.example.googleatelierdigital.Model.Trip;

public class InsertTrip extends AsyncTask<Trip, Void, Void> {

    private ActionListener listener;

    InsertTrip(ActionListener listener) {
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
