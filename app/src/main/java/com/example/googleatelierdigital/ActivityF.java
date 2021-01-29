package com.example.googleatelierdigital;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class ActivityF extends AppCompatActivity {

    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        fragmentManager = getSupportFragmentManager();

        if(findViewById(R.id.fragment_container_first) != null){
            if(savedInstanceState != null){
                return;
            }
            fragmentManager.beginTransaction().add(R.id.fragment_container_first, new FragmentRegister()).commit();
        }

    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
