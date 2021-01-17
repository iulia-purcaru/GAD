package com.example.googleatelierdigital.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.Data;

@Data
@Entity(tableName = "tripphoto")
public class TripPhoto {

    @ColumnInfo(name = "tripphoto_id")
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "tripphoto_image")
    private String image;
}
