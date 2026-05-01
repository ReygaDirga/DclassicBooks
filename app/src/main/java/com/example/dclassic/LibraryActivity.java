package com.example.dclassic;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class LibraryActivity extends AppCompatActivity {

    CardView image1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        DrawerLayout drawerLayout =
                findViewById(R.id.drawerLayout);

        ImageButton menuBtn =
                findViewById(R.id.menuBtn);

        NavigationView navView =
                findViewById(R.id.navView);


        // hamburger click
        menuBtn.setOnClickListener(v ->
                drawerLayout.openDrawer(GravityCompat.END)
        );


        navView.setNavigationItemSelectedListener(item -> {

            int id = item.getItemId();

            if(id == R.id.nav_home){
                startActivity(
                        new Intent(
                                LibraryActivity.this,
                                HomeActivity.class
                        )
                );
                finish();
            }

            else if(id == R.id.nav_profile){
                startActivity(
                        new Intent(
                                LibraryActivity.this,
                                ProfileActivity.class
                        )
                );
                finish();
            }

            else if(id == R.id.nav_store){
                startActivity(
                        new Intent(
                                LibraryActivity.this,
                                StoreActivity.class
                        )
                );
                finish();
            }

            drawerLayout.closeDrawer(GravityCompat.END);

            return true;
        });

        image1 = findViewById(R.id.image1);

        image1.setOnClickListener(v -> {
            Intent i = new Intent(
                    LibraryActivity.this,
                    DetailActivity.class
            );
            startActivity(i);
        });

    }
}