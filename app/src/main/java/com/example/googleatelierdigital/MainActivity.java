package com.example.googleatelierdigital;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.googleatelierdigital.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//
//        return false;
//    }
}