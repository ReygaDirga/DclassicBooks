package com.example.dclassic;

import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.view.WindowManager;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import androidx.core.view.ViewCompat;
import androidx.appcompat.app.AlertDialog;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    EditText etAddress, etPhone;
    Button btnPurchase;
    TextView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        WindowCompat.setDecorFitsSystemWindows(getWindow(), true);
        setContentView(R.layout.activity_detail);
//        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        View rootView = findViewById(R.id.rootScrollView);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            int imeHeight = insets.getInsets(WindowInsetsCompat.Type.ime()).bottom;
            int navBarHeight = insets.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
            int bottomPadding = Math.max(imeHeight, navBarHeight);
            v.setPadding(0, 0, 0, bottomPadding);
            return insets;
        });

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

        btnBack = findViewById(R.id.btnBack);

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
                showSuccessDialog();
            }
        });
    }

    private void showSuccessDialog(){
        AlertDialog dialog =
                new AlertDialog.Builder(this)
                        .setTitle("Purchase Success")
                        .setMessage("Your order has been received and will be processed")
                        .setCancelable(false)

                        .setPositiveButton("Next", (d, which)->{
                            startActivity(
                                    new Intent(
                                            DetailActivity.this,
                                            LibraryActivity.class
                                    )
                            );
                            finish();

                        }).create();

        dialog.show();
        dialog.getButton(
                AlertDialog.BUTTON_POSITIVE
        ).setTextColor(
                getColor(R.color.Primary)
        );
    }
}