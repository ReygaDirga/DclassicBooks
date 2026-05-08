package com.example.dclassic;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = findViewById(R.id.startBtn);

        startBtn.setOnClickListener(v -> {
            Intent intent =
                    new Intent(MainActivity.this,
                            LoginActivity.class);
            startActivity(intent);
        });
    }
}