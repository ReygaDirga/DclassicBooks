package com.example.dclassic;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    EditText etAddress, etPhone;
    Button btnPurchase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imgBook = findViewById(R.id.imgBook);
        TextView txtTitle = findViewById(R.id.txtTitle);
        TextView txtAuthor = findViewById(R.id.txtAuthor);

        // ambil data dari intent
        String title = getIntent().getStringExtra("title");
        String author = getIntent().getStringExtra("author");
        int image = getIntent().getIntExtra("image", 0);

        // set ke UI
        txtTitle.setText(title);
        txtAuthor.setText("by " + author);
        imgBook.setImageResource(image);

        TextView btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(v -> {
            finish();
        });

        etAddress = findViewById(R.id.etAddress);
        etPhone = findViewById(R.id.etPhone);
        btnPurchase = findViewById(R.id.btnPurchase);

        btnPurchase.setOnClickListener(v -> {
            String address = etAddress.getText().toString();
            String phone = etPhone.getText().toString();

            if(address.isEmpty() || phone.isEmpty()){
                Toast.makeText(this, "All fields must be filled", Toast.LENGTH_SHORT).show();
            } else if(!phone.matches("[0-9]+")){
                Toast.makeText(this, "Phone must be numeric", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Purchase success!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}