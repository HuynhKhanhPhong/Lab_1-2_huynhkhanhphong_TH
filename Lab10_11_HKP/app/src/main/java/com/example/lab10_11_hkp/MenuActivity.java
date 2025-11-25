package com.example.lab10_11_hkp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.lab10_11_hkp.M001MenuActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m000_activity_menu);

        Button btnLab10 = findViewById(R.id.btn_lab_10);
        Button btnLab11 = findViewById(R.id.btn_lab_11_cung_hoang_dao);


        btnLab10.setOnClickListener(v -> {
            // Khởi chạy MainActivity (Lab 10)
            Intent intent = new Intent(MenuActivity.this, MainActivity.class);
            startActivity(intent);
        });
        // Logic cho LAB 11 (Cung Hoàng Đạo) -> Chuyển đến M001MenuActivity
        btnLab11.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, M001MenuActivity.class);
            startActivity(intent);
        });
    }
}