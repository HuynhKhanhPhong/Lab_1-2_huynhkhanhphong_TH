package com.example.thbuoi_2_hkp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTruyenCuoi = findViewById(R.id.btn_truyen_cuoi);
        Button btnAnimalSound = findViewById(R.id.btn_animal_sound);

        // Chuyển sang Ứng dụng Truyện Cười (Lab I)
        btnTruyenCuoi.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TruyenCuoiActivity.class);
            startActivity(intent);
        });

        // Chuyển sang Ứng dụng Animal Sound (Lab II)
        btnAnimalSound.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AnimalSoundActivity.class);
            startActivity(intent);
        });
        Button btnMultiLanguage = findViewById(R.id.btn_multi_language);

        btnMultiLanguage.setOnClickListener(v -> {
            // Khởi chạy Activity cho Bài tập 2
            Intent intent = new Intent(MainActivity.this, MultiLanguageActivity.class);
            startActivity(intent);
        });

        Button btnSetting = findViewById(R.id.btn_setting);

        btnSetting.setOnClickListener(v -> {
            // Khởi chạy Activity cho Bài tập 1
            Intent intent = new Intent(MainActivity.this, SettingActivity.class);
            startActivity(intent);
        });
    }
}