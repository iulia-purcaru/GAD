package com.example.googleatelierdigital.Database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.googleatelierdigital.Dao.TripDao;
import com.example.googleatelierdigital.Dao.TripPhotoDao;
import com.example.googleatelierdigital.Dao.UserDao;
import com.example.googleatelierdigital.Model.Trip;
import com.example.googleatelierdigital.Model.TripPhoto;
import com.example.googleatelierdigital.Model.User;

@androidx.room.Database(entities = {User.class, Trip.class, TripPhoto.class}, version = 1)
public abstract class Database extends RoomDatabase {

    private static final String DB_NAME = "database.db";
    private static Database instance;

    public abstract TripDao tripDao();
    public abstract UserDao userDao();
    public abstract TripPhotoDao tripPhotoDao();

//    private Database(){}

//    public static Database getInstance(Context context) {
//        if (instance == null) {
//            synchronized (Database.class) {
//                if (instance == null) {
//                    instance = Room.databaseBuilder(context.getApplicationContext(),
//                            Database.class, DB_NAME).allowMainThreadQueries().build();
//                }
//            }
//        }
//        return instance;
//    }
}
