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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
