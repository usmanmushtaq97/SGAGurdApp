package com.tss.sga;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.tss.sga.fragment.Attendance;
import com.tss.sga.fragment.Emergency;
import com.tss.sga.fragment.Home;
import com.tss.sga.fragment.Profile;

public class MainHomeActivity  extends AppCompatActivity implements  BottomNavigationView.OnItemSelectedListener{
        BottomNavigationView bottomNavigationView;
        int name;
        Fragment fragment = null;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.mainhome);
            init();
            bottomNavigationView.setOnItemSelectedListener(this);
            if (savedInstanceState == null) {
                Home fragment = new Home();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment)
                        .commit();
            }
        }
        private void init() {
            bottomNavigationView = findViewById(R.id.bottomNavigationView);
        }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.home:
                fragment = new Home();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment)
                        .commit();
                break;
            case R.id.profile_id:
                fragment = new Profile();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment)
                        .commit();
                break;
            case R.id.attendane_id:
                fragment = new Attendance();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment)
                        .commit();
                break;
            case R.id.emergecny_nav_id:
                fragment = new Emergency();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment)
                        .commit();
                break;
        }
        return  true;
    }
}