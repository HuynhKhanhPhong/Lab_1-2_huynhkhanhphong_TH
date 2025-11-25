package com.example.lab10_11_hkp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class M001MenuActivity extends AppCompatActivity {

    private ImageView ivSelectedIcon;
    private TextView tvSelectedName;
    private TextView tvSelectedContent;
    private Button btnSeeMore;

    private String currentZodiacName = "Virgo (23/8 - 22/9)";
    private String currentZodiacContent = "Đây là nội dung tóm tắt của Virgo...";
    // Bạn nên sử dụng hằng số cho key Intent
    public static final String KEY_NAME = "zodiac_name";
    public static final String KEY_CONTENT = "zodiac_content";
    public static final String KEY_IMAGE_RES = "zodiac_image_res";
    // Ví dụ: Resource ID cho ảnh
    private int currentZodiacImageResId = R.drawable.ic_launcher_foreground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m001_act_menu);

        initViews();

        updateDetailBlock(currentZodiacName, currentZodiacContent, currentZodiacImageResId);
    }

    private void initViews() {
        ivSelectedIcon = findViewById(R.id.iv_selected_zodiac_icon);
        tvSelectedName = findViewById(R.id.tv_selected_zodiac_name);
        tvSelectedContent = findViewById(R.id.tv_selected_zodiac_content);
        btnSeeMore = findViewById(R.id.btn_see_more);

        btnSeeMore.setOnClickListener(v -> gotoM002Screen());
    }

    // Hàm xử lý khi click vào một cung hoàng đạo
    private void handleZodiacClick(String name, String content, int imageResId) {
        // 1. Cập nhật dữ liệu hiện tại
        currentZodiacName = name;
        currentZodiacContent = content;
        currentZodiacImageResId = imageResId;

        // 2. Hiển thị dữ liệu lên khối nội dung
        updateDetailBlock(name, content, imageResId);
    }

    private void updateDetailBlock(String name, String content, int imageResId) {
        tvSelectedName.setText(name);
        tvSelectedContent.setText(content);
        ivSelectedIcon.setImageResource(imageResId);
    }

    // Xử lý click button XEM THÊM
    private void gotoM002Screen() {
        // Gửi kèm thông tin Ảnh cung, Tên cung, Nội dung cung sang màn hình mới bằng Intent.
        Intent intent = new Intent(M001MenuActivity.this, M002DetailActivity.class);
        intent.putExtra(KEY_NAME, currentZodiacName);
        intent.putExtra(KEY_CONTENT, currentZodiacContent);
        // Gửi ID resource của ảnh
        intent.putExtra(KEY_IMAGE_RES, currentZodiacImageResId);
        startActivity(intent);
    }
}