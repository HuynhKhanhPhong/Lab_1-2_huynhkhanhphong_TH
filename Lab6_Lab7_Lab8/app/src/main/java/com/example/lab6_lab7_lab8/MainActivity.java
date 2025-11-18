package com.example.lab6_lab7_lab8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openLab(View view) {
        String labTag = (String) view.getTag();
        Intent intent = null;

        if (labTag.equals("currency")) {
            // Mở chương trình đổi tiền tệ
            intent = new Intent(this, Lab6CurrencyActivity.class);
        } else if (labTag.equals("length")) {
            // Mở chương trình đổi đơn vị đo chiều dài
            intent = new Intent(this, Lab6LengthActivity.class);
        }else if (labTag.equals("lab7_ex12")) {
            // Mở Bài tập 1 & 2: Custom Button, Toast, Dialog
            intent = new Intent(this, Lab7CustomControlsActivity.class);
        } else if (labTag.equals("lab7_ex3")) {
            // Mở Bài tập 3: Seekbar (Color Picker)
            intent = new Intent(this, Lab7SeekbarActivity.class);
        }
        if (labTag.equals("lab8_basic")) {
            // Mở Bài luyện tập: ListView cơ bản và Custom ListView
            intent = new Intent(this, Lab8BasicListViewActivity.class);
        } else if (labTag.equals("lab8_ex1")) {
            // Mở Bài tập 1: Custom ListView (Quản lý món ăn)
            intent = new Intent(this, Lab8FoodManagerActivity.class);
        } else if (labTag.equals("lab8_ex2")) {
            // Mở Bài tập 2: Custom GridView
            intent = new Intent(this, Lab8GridActivity.class);
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}