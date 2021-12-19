package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Hello");

        bottomNavigationView = findViewById(R.id.bottom_nav);


       getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new HomeFragment()).commit();



        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.page1:
                        fragment = new HomeFragment();
                        break;

                    case R.id.page2:
                        fragment = new ProfileFragment();
                        Toast.makeText(MainActivity.this, "This is just for Testing" +
                                "", Toast.LENGTH_SHORT).show();
                        break;


                    case R.id.page3:
                        fragment = new NotificationFragment();
                        break;

                }

                getSupportFragmentManager().beginTransaction().replace(R.id.main_container,fragment).commit();

                return true;
            }
        });



    }
}