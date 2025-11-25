package com.example.lab10_11_hkp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class M002DetailActivity extends AppCompatActivity {

    private ImageView ivDetailIcon;
    private TextView tvDetailName;
    private TextView tvDetailContent;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m002_act_detail);

        initViews();
        // Nhận dữ liệu từ Intent và hiển thị
        receiveAndSetData();
    }

    private void initViews() {
        ivDetailIcon = findViewById(R.id.iv_detail_icon);
        tvDetailName = findViewById(R.id.tv_detail_name);
        tvDetailContent = findViewById(R.id.tv_detail_content);
        btnBack = findViewById(R.id.btn_back);

        // Xử lý click vào button Quay Lại
        btnBack.setOnClickListener(v -> backToPreviousScreen());
    }

    private void receiveAndSetData() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = extras.getString(M001MenuActivity.KEY_NAME, "Tên cung");
            String content = extras.getString(M001MenuActivity.KEY_CONTENT, "Không có nội dung");
            int imageResId = extras.getInt(M001MenuActivity.KEY_IMAGE_RES, 0);

            tvDetailName.setText(name);
            tvDetailContent.setText(content);
            if (imageResId != 0) {
                ivDetailIcon.setImageResource(imageResId);
            }
        }
    }

    // Xử lý click vào button Quay Lại
    private void backToPreviousScreen() {
        // Kết thúc Activity hiện tại để quay về Activity trước đó (M001MenuActivity)
        finish();
    }
}