package com.example.googleatelierdigital.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.googleatelierdigital.Model.User;

@Dao
public interface UserDao {

    @Query("SELECT * FROM Users WHERE user_email = :email AND user_password = :password")
    User getUser(String email, String password);

    @Insert
    Long insertTrip(User user);

    @Query("SELECT user_name FROM Users WHERE user_id =:userId")
    String getUserNameById(int userId);

    @Query("SELECT user_password FROM Users WHERE user_email =:email")
    String getPasswordByEmail(String email);

    @Query("SELECT * FROM Users WHERE user_email =:email and user_name =:name")
    User getUserByEmailAndName(String email, String name);

    @Query("SELECT * FROM Users WHERE user_email =:email")
    User getUserByEmail(String email);
}
