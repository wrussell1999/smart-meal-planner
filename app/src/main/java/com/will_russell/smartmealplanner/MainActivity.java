package com.will_russell.smartmealplanner;

import android.os.Bundle;
import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.MenuItem;

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
                    getSupportActionBar().setTitle(R.string.title_meals);
                    selectedFragment = MealsFragment.newInstance();
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
