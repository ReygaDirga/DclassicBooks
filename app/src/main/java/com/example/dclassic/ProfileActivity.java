package com.example.dclassic; // Pastikan package ini sesuai dengan punyamu

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile);

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        SharedPreferences prefs =
                getSharedPreferences("USER_SESSION", MODE_PRIVATE);
        String username =
                prefs.getString("username", "guest");

        TextView txtUsername = findViewById(R.id.txtUsername);


        txtUsername.setText(username);
    }
}