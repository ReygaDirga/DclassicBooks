package com.example.dclassic;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {
    EditText etUsername, etPassword;
    Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        startBtn = findViewById(R.id.startBtn);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);

        startBtn.setOnClickListener(v -> {

            String username = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (username.isEmpty()) {
                etUsername.setError("Username wajib diisi");
                return;
            }

            if (password.isEmpty()) {
                etPassword.setError("Password wajib diisi");
                return;
            }

            if (!password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]+$")) {
                etPassword.setError("Password harus kombinasi huruf dan angka");
                return;
            }

            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);

        });
    }
}