package com.example.lab4_lab5_hkp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class EnglishLearningActivity extends AppCompatActivity {
    private static final int[] ID_DRAWABLES = {
            R.drawable.ic_mess, R.drawable.ic_flight, R.drawable.ic_hospital,
            R.drawable.ic_hotel, R.drawable.ic_restaurant, R.drawable.ic_coctail,
            R.drawable.ic_store, R.drawable.ic_at_work, R.drawable.ic_time, R.drawable.ic_education,
            R.drawable.ic_movie
    };
    private static final int[] ID_TEXTS = {
            R.string.txt_mess, R.string.txt_flight, R.string.txt_hospital,
            R.string.txt_hotel, R.string.txt_restaurant, R.string.txt_coctail,
            R.string.txt_store, R.string.txt_work, R.string.txt_time, R.string.txt_education, R.string.txt_movie
    };

    private static final String[] SAMPLE_WORDS = {
            "Hello, Thank you",
            "Passport, Ticket",
            "Doctor, Ambulance",
            "Reservation, Key",
            "Menu, Waiter",
            "Beer, Cocktail",
            "Cash, Receipt",
            "Meeting, Deadline",
            "Hour, Minute",
            "Class, Professor",
            "Movie, Popcorn"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_learning);
        initView();
    }

    private void initView() {
        LinearLayout InMain = findViewById(R.id.In_main);
        InMain.removeAllViews();

        for (int i = 0; i < ID_DRAWABLES.length; i++) {
            View v = LayoutInflater.from(this).inflate(R.layout.item_topic, null);
            ImageView ivTopic = v.findViewById(R.id.iv_topic);
            TextView tvTopic = v.findViewById(R.id.tv_topic);

            ivTopic.setImageResource(ID_DRAWABLES[i]);
            tvTopic.setText(ID_TEXTS[i]);

            int finalI = i;

            // Bài tập 2: Hiển thị Toast khi click
            v.setOnClickListener(view -> {
                String topicName = getString(ID_TEXTS[finalI]);
                String words = (finalI < SAMPLE_WORDS.length) ? SAMPLE_WORDS[finalI] : "Từ vựng đang được cập nhật.";

                Toast.makeText(this,
                        topicName + ": " + words,
                        Toast.LENGTH_LONG).show();

            });

            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    1.0f
            );
            v.setLayoutParams(param);
            InMain.addView(v);
        }

    }
    private void openTopicDetailActivity(String topicName, String words) {
        Intent intent = new Intent(this, TopicDetailActivity.class);
        intent.putExtra("TOPIC_NAME", topicName);
        intent.putExtra("WORDS", words);
        startActivity(intent);
    }
}