package com.example.dclassic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        ImageButton menuBtn = findViewById(R.id.menuBtn);
        NavigationView navView = findViewById(R.id.navView);

        // hamburger click
        menuBtn.setOnClickListener(v ->
                drawerLayout.openDrawer(GravityCompat.END)
        );


        navView.setNavigationItemSelectedListener(item -> {

            int id = item.getItemId();

            if(id == R.id.nav_home){
                startActivity(new Intent(LibraryActivity.this, HomeActivity.class));
            }
            else if(id == R.id.nav_profile){
                startActivity(new Intent(LibraryActivity.this, ProfileActivity.class));
            }
            else if(id == R.id.nav_store){
                startActivity(new Intent(LibraryActivity.this, StoreActivity.class));
            }

            drawerLayout.closeDrawer(GravityCompat.END);
            return true;
        });

        Button btnFiction = findViewById(R.id.btnFiction);
        Button btnNonFiction = findViewById(R.id.btnNonFiction);

        LinearLayout bookContainer = findViewById(R.id.bookContainer);

        btnFiction.setOnClickListener(v -> filterBooks(bookContainer, "fiction"));
        btnNonFiction.setOnClickListener(v -> filterBooks(bookContainer, "nonfiction"));

        int[] cardIds = {
                R.id.image1, R.id.image2, R.id.image3,
                R.id.image4, R.id.image5, R.id.image6
        };

        // DATA BUKU
        String[] titles = {
                "The Keeper",
                "The Locked Door",
                "Wish You Were Here",
                "How to Be Okay",
                "Wait For Me",
                "Diary of a Wimpy Kid"
        };

        String[] authors = {
                "Tana French",
                "Freida McFadden",
                "Jodi Picoult",
                "Jenny Lawson",
                "Amy Jo Burns",
                "Jeff Kinney"
        };

        int[] images = {
                R.drawable.book1,
                R.drawable.book5,
                R.drawable.book6,
                R.drawable.book7,
                R.drawable.book8,
                R.drawable.book9
        };

        // LOOP
        for (int i = 0; i < cardIds.length; i++) {

            CardView card = findViewById(cardIds[i]);
            int index = i;

            card.setOnClickListener(v -> {
                Intent intent = new Intent(LibraryActivity.this, DetailActivity.class);

                intent.putExtra("title", titles[index]);
                intent.putExtra("author", authors[index]);
                intent.putExtra("image", images[index]);

                startActivity(intent);
            });
        }
    }
    private void filterBooks(LinearLayout container, String category) {
        for (int i = 0; i < container.getChildCount(); i++) {
            View child = container.getChildAt(i);
            Object tag = child.getTag();

            if (tag != null) {
                if (tag.toString().equals(category)) {
                    child.setVisibility(View.VISIBLE);
                } else {
                    child.setVisibility(View.GONE);
                }
            }
        }
    }
}