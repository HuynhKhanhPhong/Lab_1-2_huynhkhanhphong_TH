package com.example.lab4_lab5_hkp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo các nút Lab4
        Button btnLogin = findViewById(R.id.btn_lab4_login);
        Button btnMenu = findViewById(R.id.btn_lab4_menu);
        Button btnEmoji = findViewById(R.id.btn_lab4_emoji);

        // Khởi tạo các nút Lab5
        Button btnAnimation = findViewById(R.id.btn_lab5_animation);
        Button btnQuickCall = findViewById(R.id.btn_lab5_quickcall);

        // Lab 4
        // Chuyển hướng đến Luyện tập/Bài tập 1
        btnLogin.setOnClickListener(v ->
                startActivity(new Intent(this, LoginActivity.class)));

        // Chuyển hướng đến Luyện tập/Bài tập 2
        btnMenu.setOnClickListener(v ->
                startActivity(new Intent(this, EnglishLearningActivity.class)));

        // Chuyển hướng đến Luyện tập/Bài tập 3
        btnEmoji.setOnClickListener(v ->
                startActivity(new Intent(this, FaceEmoijActivity.class)));

        // Lab 5
        // Chuyển hướng đến Luyện tập/Bài tập 1
        btnAnimation.setOnClickListener(v ->
                startActivity(new Intent(this, AnimationActivity.class)));

        // Chuyển hướng đến Luyện tập/Bài tập 2
        btnQuickCall.setOnClickListener(v ->
                startActivity(new Intent(this, QuickCallActivity.class)));
    }
}