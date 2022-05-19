package com.minhthieu.reddit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.minhthieu.reddit.Fragments.ChatFragment;
import com.minhthieu.reddit.Fragments.HomeFragment;
import com.minhthieu.reddit.Fragments.NotificationFragment;
import com.minhthieu.reddit.Fragments.SearchFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigation;
    private Fragment selectedFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Anh xa
        AnhXa();
        // ContainOnClikcListener
        ContainOnClikcListener();

    }

    private void ContainOnClikcListener() {
        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @org.jetbrains.annotations.NotNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        selectedFragment = new HomeFragment();
                        break;

                    case R.id.nav_chat:
                        selectedFragment = new ChatFragment();
                        break;


                    case R.id.nav_notification:
                        selectedFragment = new NotificationFragment();
                        break;

                    case R.id.nav_search:
                        selectedFragment = new SearchFragment();
                        break;

                }

                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                } else{
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                }

                return true;
            }
        });


    }

    private void AnhXa() {
        bottomNavigation = findViewById(R.id.bottom_navigation);
    }
}