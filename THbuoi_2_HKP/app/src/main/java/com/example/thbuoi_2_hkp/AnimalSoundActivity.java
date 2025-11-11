package com.example.thbuoi_2_hkp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class AnimalSoundActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hiển thị giao diện chi tiết Rabbit
        setContentView(R.layout.m003_act_detail);
        // Do màn hình này không yêu cầu logic Java phức tạp nên chỉ cần set content view
    }
}