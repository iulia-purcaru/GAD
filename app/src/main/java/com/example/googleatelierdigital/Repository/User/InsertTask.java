package com.example.googleatelierdigital.Repository.User;

import android.os.AsyncTask;

import com.example.googleatelierdigital.ActionListener;
import com.example.googleatelierdigital.DatabaseInstance;
import com.example.googleatelierdigital.Model.User;

public class InsertTask extends AsyncTask<User, Void, Void> {

    private ActionListener listener;

    InsertTask(ActionListener listener) {
        this.listener = listener;
    }

    @Override
    protected Void doInBackground(User... users) {
        DatabaseInstance.getAppDatabase().userDao().insertTrip(users[0]);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}
