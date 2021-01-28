package com.example.googleatelierdigital.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.Data;

@Data
@Entity(tableName = "Users")
public class User {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    private int id;

    @ColumnInfo(name = "user_name")
    private String username;

    @ColumnInfo(name = "user_email")
    private String email;

    @ColumnInfo(name = "user_password")
    private String password;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
