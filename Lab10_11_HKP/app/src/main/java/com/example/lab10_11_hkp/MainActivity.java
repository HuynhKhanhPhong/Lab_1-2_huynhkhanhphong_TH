package com.example.lab10_11_hkp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import com.example.lab10_11_hkp.M001TopicFrg;

public class MainActivity extends AppCompatActivity {
    private String topicName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showFrg(new M000SplashFrg()); // Bắt đầu bằng Splash
    }

    private void showFrg (Fragment frg) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.In_main, frg, null)
                .commit();
    }

    // Chuyển sang màn hình Danh sách Chủ đề (M001)
    public void gotoM001Screen() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.In_main, new M001TopicFrg(), null)
                .commit();
    }

    // Chuyển sang màn hình Danh sách Truyện (M002)
    public void gotoM002Screen (String topicName) {
        this.topicName = topicName;
        M002StoryFrg frg = new M002StoryFrg();
        frg.setTopicName(topicName);
        showFrg(frg);
    }

    // Quay lại màn hình M001
    public void backToM001Screen() {
        gotoM001Screen();
    }

    // Chuyển sang màn hình Chi tiết Truyện (M003)
    public void gotoM003Screen(ArrayList<StoryEntity> listStory, StoryEntity story) {
        M003DetailStoryFrg frg = new M003DetailStoryFrg();
        frg.setData(topicName, listStory, story);
        showFrg(frg);
    }
}