package com.example.googleatelierdigital.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;



@Entity(tableName = "tripphoto")
public class TripPhoto {

    @ColumnInfo(name = "tripphoto_id")
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "tripphoto_image")
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
