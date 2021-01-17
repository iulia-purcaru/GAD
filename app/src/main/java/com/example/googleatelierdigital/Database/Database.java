package com.example.googleatelierdigital.Database;

import androidx.room.RoomDatabase;

import com.example.googleatelierdigital.Model.Trip;
import com.example.googleatelierdigital.Model.TripPhoto;
import com.example.googleatelierdigital.Model.User;

@androidx.room.Database(entities = {User.class, Trip.class, TripPhoto.class}, version = 1)
public abstract class Database extends RoomDatabase {
}
