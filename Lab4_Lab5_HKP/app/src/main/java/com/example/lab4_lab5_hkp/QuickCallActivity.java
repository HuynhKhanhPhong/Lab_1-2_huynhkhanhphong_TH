package com.example.lab4_lab5_hkp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class QuickCallActivity extends AppCompatActivity implements View.OnClickListener {
    private final int REQUEST_CALL_PERMISSION = 101;

    private int currentAnimationId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_call);
        initView();
    }

    private void initView() {
        // Luyện tập 2: Item danh bạ và Dialer
        findViewById(R.id.fr_mom).setOnClickListener(this);
        findViewById(R.id.fr_dad).setOnClickListener(this);
        findViewById(R.id.fr_crush).setOnClickListener(this);
        findViewById(R.id.fr_best_friend).setOnClickListener(this);
        findViewById(R.id.iv_dialer).setOnClickListener(this);

        // Bài tập 2: Các nút chọn Animation
        findViewById(R.id.btn_anim_alpha).setOnClickListener(this);
        findViewById(R.id.btn_anim_scale).setOnClickListener(this);
        findViewById(R.id.btn_anim_trans).setOnClickListener(this);
        findViewById(R.id.btn_anim_rotate).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();


        if (viewId == R.id.btn_anim_alpha) {
            currentAnimationId = R.anim.alpha;
            Toast.makeText(this, "Animation: Alpha Selected", Toast.LENGTH_SHORT).show();
            return;
        } else if (viewId == R.id.btn_anim_scale) {
            currentAnimationId = R.anim.scale;
            Toast.makeText(this, "Animation: Scale Selected", Toast.LENGTH_SHORT).show();
            return;
        } else if (viewId == R.id.btn_anim_trans) {
            currentAnimationId = R.anim.translate;
            Toast.makeText(this, "Animation: Translate Selected", Toast.LENGTH_SHORT).show();
            return;
        } else if (viewId == R.id.btn_anim_rotate) {
            currentAnimationId = R.anim.rotate;
            Toast.makeText(this, "Animation: Rotate Selected", Toast.LENGTH_SHORT).show();
            return;
        }

        // 2. Xử lý click vào item
        // Áp dụng animation đã chọn (Bài tập 2)
        if (currentAnimationId != 0) {
            v.startAnimation(AnimationUtils.loadAnimation(this, currentAnimationId));
        } else {

            v.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_popup_enter));
        }

        if (v instanceof FrameLayout) {

            String phoneNumber = (String) v.getTag();
            processCall(phoneNumber);
        } else if (viewId == R.id.iv_dialer) {

            gotoDialPad();
        }
    }

    private void gotoDialPad() {

        Intent intent = new Intent(Intent.ACTION_DIAL);
        startActivity(intent);
    }

    private void processCall(String phone) {
        if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL_PERMISSION);
            Toast.makeText(this, "Hãy thực hiện lại sau khi cấp quyền!", Toast.LENGTH_SHORT).show();
            return;
        }


        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phone));
        startActivity(intent);
    }
}