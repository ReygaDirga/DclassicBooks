package com.example.dclassic; // Pastikan package ini sesuai dengan punyamu

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    ImageView btnBack;
    ImageView btnLogout;
    LinearLayout editProfile;

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

        btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(v -> {
            SharedPreferences prefss =
                    getSharedPreferences(
                            "USER_SESSION",
                            MODE_PRIVATE
                    );

            prefss.edit()
                    .clear()
                    .apply();

            Intent intent =
                    new Intent(
                            ProfileActivity.this,
                            LoginActivity.class
                    );

            intent.setFlags(
                    Intent.FLAG_ACTIVITY_NEW_TASK |
                            Intent.FLAG_ACTIVITY_CLEAR_TASK
            );

            startActivity(intent);
            finish();
        });

        editProfile = findViewById(R.id.editProfile);

        editProfile.setOnClickListener(v -> {
            Intent intent =
                    new Intent(ProfileActivity.this,
                            EditProfileActivity.class);
            startActivity(intent);
        });
    }
}