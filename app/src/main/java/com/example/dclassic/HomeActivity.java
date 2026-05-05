package com.example.dclassic;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.navigation.NavigationView;

import java.util.Arrays;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private ViewPager2 pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        String username = getIntent().getStringExtra("username");
        TextView greeting = findViewById(R.id.greeting);

        greeting.setText("Hi, " + username + "!");
        pager = findViewById(R.id.viewPager);

        List<Integer> images = Arrays.asList(
                R.drawable.store1,
                R.drawable.store2,
                R.drawable.store3,
                R.drawable.store4
        );

        StoreAdapter adapter = new StoreAdapter(images);
        pager.setAdapter(adapter);


        ImageButton rightBtn =
                findViewById(R.id.rightBtn);

        ImageButton leftBtn =
                findViewById(R.id.leftBtn);

        rightBtn.setOnClickListener(v -> {
            if (pager.getCurrentItem() < images.size()-1) {
                pager.setCurrentItem(
                        pager.getCurrentItem()+1,
                        true
                );
            }
        });

        leftBtn.setOnClickListener(v -> {
            if (pager.getCurrentItem() > 0) {
                pager.setCurrentItem(
                        pager.getCurrentItem()-1,
                        true
                );
            }
        });

        Handler handler =
                new Handler(Looper.getMainLooper());

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                int next =
                        (pager.getCurrentItem()+1)
                                % images.size();

                pager.setCurrentItem(next,true);

                handler.postDelayed(this,3000);
            }
        };

        handler.postDelayed(runnable,3000);

        DrawerLayout drawerLayout =
                findViewById(R.id.drawerLayout);

        ImageButton menuBtn =
                findViewById(R.id.menuBtn);

        menuBtn.setOnClickListener(v -> {
            drawerLayout.openDrawer(
                    GravityCompat.END
            );
        });

        NavigationView navView =
                findViewById(R.id.navView);

        navView.setNavigationItemSelectedListener(item -> {

            int id = item.getItemId();
            if(id == R.id.nav_home){
                drawerLayout.closeDrawer(
                        GravityCompat.END
                );
            }
            else if(id == R.id.nav_library){
                startActivity(
                    new Intent(
                            HomeActivity.this,
                            LibraryActivity.class
                    )
                );
            }

            else if(id == R.id.nav_store){
                startActivity(
                    new Intent(
                            HomeActivity.this,
                            StoreActivity.class
                    )
                );
            }

            else if(id == R.id.nav_profile){
                startActivity(
                    new Intent(
                            HomeActivity.this,
                            ProfileActivity.class
                    )
                );
            }
            drawerLayout.closeDrawer(
                    GravityCompat.END
            );

            return true;
        });

    }
}