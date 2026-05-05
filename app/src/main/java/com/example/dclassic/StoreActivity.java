package com.example.dclassic;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.Arrays;
import java.util.List;

public class StoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        ImageButton menuBtn = findViewById(R.id.menuBtn);
        NavigationView navView = findViewById(R.id.navView);

        // buka sidebar
        menuBtn.setOnClickListener(v ->
                drawerLayout.openDrawer(GravityCompat.END)
        );

        // klik menu
        navView.setNavigationItemSelectedListener(item -> {

            int id = item.getItemId();

            if(id == R.id.nav_home){
                startActivity(new Intent(this, HomeActivity.class));
            }

            else if(id == R.id.nav_library){
                startActivity(new Intent(this, LibraryActivity.class));
            }

            else if(id == R.id.nav_profile){
                startActivity(new Intent(this, ProfileActivity.class));
            }

            else if(id == R.id.nav_logout){
                startActivity(new Intent(this, LoginActivity.class));
                finish();
            }

            drawerLayout.closeDrawer(GravityCompat.END);

            return true;
        });
        List<Integer> images = Arrays.asList(
                R.drawable.store1,
                R.drawable.store2,
                R.drawable.store3,
                R.drawable.store4
        );

        List<String> names = Arrays.asList(
                "Gramedia",
                "Kinokuniya",
                "Periplus",
                "POST Bookshop"
        );

        List<String> locations = Arrays.asList(
                "South Jakarta",
                "Central Jakarta",
                "West Jakarta",
                "Bandung"
        );

        // RECYCLER
        RecyclerView rvStores = findViewById(R.id.rvStores);
        rvStores.setLayoutManager(new LinearLayoutManager(this));
        rvStores.setAdapter(new storepagesadapter(images, names, locations));
    }
}