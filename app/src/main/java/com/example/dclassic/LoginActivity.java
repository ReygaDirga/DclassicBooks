package com.example.dclassic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.ViewCompat;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {
    EditText etUsername, etPassword;
    Button startBtn;
    TextView signUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        setContentView(R.layout.activity_login);

        View rootView = findViewById(R.id.rootScrollView);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            int imeHeight = insets.getInsets(WindowInsetsCompat.Type.ime()).bottom;
            int navBarHeight = insets.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
            int bottomPadding = Math.max(imeHeight, navBarHeight);
            v.setPadding(0, 0, 0, bottomPadding);
            return insets;
        });

        startBtn = findViewById(R.id.startBtn);
        signUpBtn = findViewById(R.id.signUpBtn);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);

        startBtn.setOnClickListener(v -> {

            String username = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()){
                Toast.makeText(LoginActivity.this, "All column must be filled", Toast.LENGTH_SHORT).show();
                return;
            } else if (!password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]+$")) {
                Toast.makeText(LoginActivity.this, "Password must be combination of alphanumerical", Toast.LENGTH_SHORT).show();
                return;
            }
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            intent.putExtra("username", username);

            SharedPreferences prefs =
                    getSharedPreferences("USER_SESSION", MODE_PRIVATE);

            prefs.edit()
                    .putString("username", username)
                    .apply();

            startActivity(intent);
        });

        signUpBtn.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
            startActivity(intent);
        });
    }
}