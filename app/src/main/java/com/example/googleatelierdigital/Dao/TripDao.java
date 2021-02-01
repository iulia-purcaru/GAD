package com.example.googleatelierdigital.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.googleatelierdigital.Model.Trip;
import com.example.googleatelierdigital.Model.User;

import java.util.List;

@Dao
public interface TripDao {

    @Query("SELECT * FROM TRIPS")
    List<Trip> getAllTrips();

    @Query("SELECT * FROM Trips WHERE user_id = :userId")
    List<Trip> getAllTripsByUserId(int userId);

    @Insert
    void insertTrip(Trip trip);

    @Query("SELECT * FROM Trips WHERE trip_id=:id")
    Trip getTrip(int id);

    @Query("SELECT * FROM Trips WHERE trip_name=:name")
    Trip getTripByName(String name);

    @Delete
    void delete(Trip trip);

    @Query("SELECT user_name FROM Users INNER JOIN TRIPS WHERE trip_id=:id")
    String getUserIdByTripId(int id);
}
