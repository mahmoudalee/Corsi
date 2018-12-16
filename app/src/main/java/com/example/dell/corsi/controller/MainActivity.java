package com.example.dell.corsi.controller;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.dell.corsi.R;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mMainNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainNav = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        mMainNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container , new HomeFragment() ).commit();
    }

    //used to navigate between fragments
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;
            switch (menuItem.getItemId()){
                case R.id.nav_home:
                    selectedFragment =new HomeFragment();
                    break;
                case R.id.nav_dash_board :
                    selectedFragment = new DashboardFragment();
                    break;
                case R.id.nav_downloads :
                    selectedFragment = new DownloadsFragment();
                    break;
                case R.id.nav_settings :
                    selectedFragment = new SettingsFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container , selectedFragment ).commit();
            return true;
        }
    };
}
