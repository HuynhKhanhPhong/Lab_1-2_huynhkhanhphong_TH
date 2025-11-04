package com.example.lab1_hkp_th;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Sử dụng layout menu mới
        setContentView(R.layout.activity_main_menu);

        // Menu Chính: Chuyển màn hình giữa các bài tập
        findViewById(R.id.btn_bai_tap_cu).setOnClickListener(v ->
                startActivity(new Intent(this, CalculatorDiceActivity.class)));

        findViewById(R.id.btn_goi_nhan_tin).setOnClickListener(v ->
                startActivity(new Intent(this, CallSmsActivity.class)));

        findViewById(R.id.btn_bai_tap_1_moi).setOnClickListener(v ->
                startActivity(new Intent(this, RandomScreenActivity.class)));

        findViewById(R.id.btn_bai_tap_2_moi).setOnClickListener(v ->
                startActivity(new Intent(this, CustomProgressActivity.class)));
        findViewById(R.id.btn_bai_tap_5_moi).setOnClickListener(v ->
                startActivity(new Intent(this, DiscoverActivity.class)));
    }
}