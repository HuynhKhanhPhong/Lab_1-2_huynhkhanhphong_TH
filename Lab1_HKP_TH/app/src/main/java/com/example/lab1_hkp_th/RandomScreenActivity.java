package com.example.lab1_hkp_th;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import java.util.Random;

public class RandomScreenActivity extends AppCompatActivity {

    private View rootLayout;
    private ImageView ivRandomTrigger; // Icon 1: Kích hoạt Random
    private ImageView ivCallTrigger;   // Icon 2: Kích hoạt Call
    private Random random = new Random();

    // Mảng các icon ngẫu nhiên để áp dụng cho ivRandomTrigger
    private final int[] RANDOM_ICON_IDS = {
            android.R.drawable.ic_menu_camera,
            android.R.drawable.ic_menu_compass,
            android.R.drawable.ic_menu_gallery,
            android.R.drawable.ic_menu_edit
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_screen);

        rootLayout = findViewById(R.id.random_root_layout);
        ivRandomTrigger = findViewById(R.id.iv_random_trigger);
        ivCallTrigger = findViewById(R.id.iv_call_trigger);

        // Thiết lập màu nền ban đầu
        setRandomBackground();

        // 1. Chức năng 1: Bấm vào icon QUAY để đổi màu nền và đổi icon của chính nó
        ivRandomTrigger.setOnClickListener(v -> setRandomBackgroundAndIcon(ivRandomTrigger));

        // 2. Chức năng 2: Bấm vào icon GỌI để chuyển sang màn hình gọi điện
        ivCallTrigger.setOnClickListener(v -> {
            Intent intent = new Intent(this, CallSmsActivity.class);
            startActivity(intent);
        });
    }

    // Hàm chỉ thay đổi màu nền (được gọi khi Activity khởi tạo)
    private void setRandomBackground() {
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        int randomColor = Color.rgb(red, green, blue);
        rootLayout.setBackgroundColor(randomColor);
    }

    // Hàm thay đổi màu nền VÀ icon (được gọi khi click ivRandomTrigger)
    private void setRandomBackgroundAndIcon(ImageView view) {
        // Thay đổi màu nền
        setRandomBackground();

        // Thay đổi icon của ImageView được truyền vào
        int randomIconId = RANDOM_ICON_IDS[random.nextInt(RANDOM_ICON_IDS.length)];
        view.setImageResource(randomIconId);
    }
}