package com.example.dclassic;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button startBtn, btnFiction, btnNonFiction;
    LinearLayout bookContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = findViewById(R.id.startBtn);
        btnFiction = findViewById(R.id.btnFiction);
        btnNonFiction = findViewById(R.id.btnNonFiction);
        bookContainer = findViewById(R.id.bookContainer);

        startBtn.setOnClickListener(v -> {
            Intent intent =
                    new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        btnFiction.setOnClickListener(v -> filterBooks("fiction"));
        btnNonFiction.setOnClickListener(v -> filterBooks("nonfiction"));
    }

    private void filterBooks(String category) {
        for (int i = 0; i < bookContainer.getChildCount(); i++) {
            View child = bookContainer.getChildAt(i);
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