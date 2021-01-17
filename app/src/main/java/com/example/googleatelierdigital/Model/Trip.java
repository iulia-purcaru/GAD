package com.example.googleatelierdigital.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.Data;

@Data
@Entity(tableName = "Trips")
public class Trip {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "trip_id")
    private int id;

    @ColumnInfo(name = "trip_name")
    private String name;

    @ColumnInfo(name = "trip_location")
    private String location;

    @ColumnInfo(name = "trip_date")
    private String date;

    @ColumnInfo(name = "trip_image")
    private String image_path;

    //one-to-many with users table
    @ColumnInfo(name = "user_id")
    private  int user_id;

    public Trip() {
    }
}
