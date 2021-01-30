package com.example.googleatelierdigital;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.googleatelierdigital.R;
import com.example.googleatelierdigital.Repository.User.UserRepository;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout    drawerLayout;
    private Toolbar         toolbar;
    private NavigationView  navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        SharedPreferences sharedPreferences = getApplicationContext()
                                            .getSharedPreferences("com.example.googleatelierdigital",
                                                                    Context.MODE_PRIVATE);
        int userId = sharedPreferences.getInt("com.example.googleatelierdigital.userId",0);
        UserRepository userRepository = new UserRepository(getApplicationContext());
        String userName = userRepository.getUserNameById(userId);

        TextView userNameTextView = navigationView.getHeaderView(0).findViewById(R.id.userName);
        userNameTextView.setText("You are logged as " + userName);

        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                                        R.string.navigation_drawer_open,
                                        R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_main, new FragmentAll()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_main, new FragmentAll()).commit();
                break;
            case R.id.nav_add_trip:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_main, new FragmentAdd()).commit();
                break;
            case R.id.nav_my_trips:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_main, new FragmentMyTrips()).commit();
                break;
            case R.id.nav_log_out:
                //elimin valorile pastrate in SharedPreferences
                SharedPreferences sharedPref = this.getSharedPreferences("com.example.googleatelierdigital", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.clear();
                editor.apply();
                Intent intent =  new Intent(this, ActivityF.class);
                startActivity(intent);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}