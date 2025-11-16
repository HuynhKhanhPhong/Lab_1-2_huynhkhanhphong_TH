package com.example.lab4_lab5_hkp;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class AnimationActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView ivAnimal;
    private final int[] animationIds = {
            R.anim.alpha,
            R.anim.scale,
            R.anim.translate,
            R.anim.rotate
    };
    private final Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        initViews();
    }

    private void initViews() {
        ivAnimal = findViewById(R.id.iv_animal);

        // Luyện tập 1: Gán sự kiện cho 4 nút animation
        findViewById(R.id.bt_alpha).setOnClickListener(this);
        findViewById(R.id.bt_rotate).setOnClickListener(this);
        findViewById(R.id.bt_scale).setOnClickListener(this);
        findViewById(R.id.bt_trans).setOnClickListener(this);

        // Bài tập 1: Gán sự kiện cho nút Random
        findViewById(R.id.bt_random).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int animationResId = 0;
        int viewId = v.getId();

        if (viewId == R.id.bt_alpha) {
            animationResId = R.anim.alpha;
        } else if (viewId == R.id.bt_rotate) {
            animationResId = R.anim.rotate;
        } else if (viewId == R.id.bt_scale) {
            animationResId = R.anim.scale;
        } else if (viewId == R.id.bt_trans) {
            animationResId = R.anim.translate;
        } else if (viewId == R.id.bt_random) {
            // Bài tập 1: Chọn một animation ngẫu nhiên từ mảng
            int randomIndex = random.nextInt(animationIds.length);
            animationResId = animationIds[randomIndex];
        }


        if (animationResId != 0) {
            ivAnimal.startAnimation(AnimationUtils.loadAnimation(this, animationResId));
        }
    }
}