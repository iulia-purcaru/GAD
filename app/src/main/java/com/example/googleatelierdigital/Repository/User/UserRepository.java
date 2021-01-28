package com.example.googleatelierdigital.Repository.User;

import android.content.Context;

import com.example.googleatelierdigital.Database.Database;
import com.example.googleatelierdigital.Database.DatabaseInstance;
import com.example.googleatelierdigital.Model.User;

public class UserRepository {

    private Database appDatabase;

    public UserRepository(Context context) { appDatabase = DatabaseInstance.getAppDatabase(); }

    public void insertTask(final User user, final OnUserRepositoryActionListener listener){
        new InsertTask(listener).execute(user);
    }

    public User getUser(String email, String password) {
        return appDatabase.userDao().getUser(email, password);
    }

    public  User getUserByEmailString(String email) {
        return  appDatabase.userDao().getUserByEmail(email);
    }

    public  User getUserByEmailAndNameString(String email, String name) {
        return  appDatabase.userDao().getUserByEmailAndName(email, name);
    }

    public String getUserPassword(String email) {
        return appDatabase.userDao().getPasswordByEmail(email);
    }

    public String getUserNameById(int userId) {
        return appDatabase.userDao().getUserNameById(userId);
    }
}
