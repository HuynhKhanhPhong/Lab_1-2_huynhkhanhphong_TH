package com.example.lab4_lab5_hkp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;
import java.util.List;

public class TopicDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_detail);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String topicName = extras.getString("TOPIC_NAME", "Chi tiết Chủ đề");
            String wordsString = extras.getString("WORDS", "");


            TextView tvTitle = findViewById(R.id.tv_topic_detail_title);
            tvTitle.setText(topicName);


            ListView listView = findViewById(R.id.lv_words);


            List<String> wordsList = Arrays.asList(wordsString.split(",\\s*"));

            ArrayAdapter<String> adapter = new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_list_item_1,
                    wordsList);

            listView.setAdapter(adapter);
        }
    }
}