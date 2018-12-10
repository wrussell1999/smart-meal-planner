package com.example.jetpo.smartmealplanner;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.content.Intent;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle(R.string.title_home);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                case R.id.navigation_home:
                    getSupportActionBar().setTitle(R.string.title_home);
                    selectedFragment = HomeFragment.newInstance();
                    break;
                case R.id.navigation_inventory:
                    getSupportActionBar().setTitle(R.string.title_inventory);
                    selectedFragment = InventoryFragment.newInstance();
                    break;
                case R.id.navigation_shopping_list:
                    getSupportActionBar().setTitle(R.string.title_shopping_list);
                    selectedFragment = ShoppingFragment.newInstance();
                    break;
                case R.id.navigation_week_overview:
                    getSupportActionBar().setTitle(R.string.title_week_overview);
                    selectedFragment = WeekFragment.newInstance();
                    break;
                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, selectedFragment);
                transaction.commit();
                return true;
            }
        });
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, HomeFragment.newInstance());
        transaction.commit();

    }
}
