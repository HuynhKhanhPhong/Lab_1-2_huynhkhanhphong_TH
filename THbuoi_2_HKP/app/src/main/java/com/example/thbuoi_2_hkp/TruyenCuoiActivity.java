package com.example.thbuoi_2_hkp;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;


class StoryEntity {}

public class TruyenCuoiActivity extends AppCompatActivity {

    // Khai báo cho Bài tập 1: Khóa xoay màn hình
    private static final String PREFS_NAME = "MyPrefs";
    private static final String KEY_ROTATION_LOCK = "RotationLock";



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        applyRotationLock();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truyen_cuoi);


        showFrg(new M000SplashFrg());
    }


    private void applyRotationLock() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        boolean isLocked = prefs.getBoolean(KEY_ROTATION_LOCK, false);

        if (isLocked) {
            // Nếu khóa (OFF) -> ép buộc hướng dọc
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        } else {
            // Nếu không khóa (ON) -> cho phép xoay theo cảm biến
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        applyRotationLock();
    }


    private void showFrg(Fragment frg) {
        getSupportFragmentManager().beginTransaction().replace(
                R.id.ln_main,
                frg,
                null
        ).commit();
    }


    public void gotoM001Screen() {

        showFrg(new M001ListCategoryFrg());
    }


    public void gotoM002Screen (String topicName) {
        // TODO: showFrg(new M002ListStoryFrg(topicName));

        showFrg(new M001ListCategoryFrg());
    }


    public void backToM001Screen() {
        gotoM001Screen();
    }


    public void gotoM003Screen (ArrayList<StoryEntity> listStory, StoryEntity story) {
        // TODO: showFrg(new M003DetailStoryFrg(listStory, story));
    }
}