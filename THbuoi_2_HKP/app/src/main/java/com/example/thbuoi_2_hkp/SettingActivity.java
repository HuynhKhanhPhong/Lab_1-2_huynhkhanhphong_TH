package com.example.thbuoi_2_hkp;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SettingActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "MyPrefs";
    private static final String KEY_ROTATION_LOCK = "RotationLock";
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        Button btnOff = findViewById(R.id.btn_rotation_off);
        Button btnOn = findViewById(R.id.btn_rotation_on);

        // Nút OFF: Khóa màn hình ở chế độ dọc (PORTRAIT)
        btnOff.setOnClickListener(v -> {

            prefs.edit().putBoolean(KEY_ROTATION_LOCK, true).apply();


            finish();
        });

        // Nút ON: Cho phép màn hình xoay theo cảm biến
        btnOn.setOnClickListener(v -> {

            prefs.edit().putBoolean(KEY_ROTATION_LOCK, false).apply();


            finish();
        });
    }
}