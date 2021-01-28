package com.example.googleatelierdigital.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.googleatelierdigital.Model.Trip;

import java.util.List;

@Dao
public interface TripDao {

    @Query("SELECT * FROM TRIPS")
    List<Trip> getAllTrips();

    @Query("SELECT * FROM Trips WHERE user_id = :userId")
    List<Trip> getAllTripsByUserId(int userId);

    @Insert
    void insertTrip(Trip trip);
}
