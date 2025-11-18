package com.example.lab6_lab7_lab8;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class Lab7SeekbarActivity extends AppCompatActivity {

    private SeekBar seekBarR, seekBarG, seekBarB;
    private TextView tvRValue, tvGValue, tvBValue;
    private View colorBlockRgb, colorBlockCmy;

    private int currentR = 0;
    private int currentG = 0;
    private int currentB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab7_seekbar);

        // 1. Ánh xạ View
        seekBarR = findViewById(R.id.seekBarR);
        seekBarG = findViewById(R.id.seekBarG);
        seekBarB = findViewById(R.id.seekBarB);

        tvRValue = findViewById(R.id.tvRValue);
        tvGValue = findViewById(R.id.tvGValue);
        tvBValue = findViewById(R.id.tvBValue);

        colorBlockRgb = findViewById(R.id.colorBlockRgb);
        colorBlockCmy = findViewById(R.id.colorBlockCmy);

        // Thiết lập giá trị mặc định cho label
        tvRValue.setText(getString(R.string.color_r) + "=" + currentR);
        tvGValue.setText(getString(R.string.color_g) + "=" + currentG);
        tvBValue.setText(getString(R.string.color_b) + "=" + currentB);

        // 2. Thiết lập Listener
        setupSeekbarListeners();
    }

    private void setupSeekbarListeners() {
        SeekBar.OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Cập nhật giá trị R, G, B
                if (seekBar.getId() == R.id.seekBarR) {
                    currentR = progress;
                    tvRValue.setText(getString(R.string.color_r) + "=" + progress);
                } else if (seekBar.getId() == R.id.seekBarG) {
                    currentG = progress;
                    tvGValue.setText(getString(R.string.color_g) + "=" + progress);
                } else if (seekBar.getId() == R.id.seekBarB) {
                    currentB = progress;
                    tvBValue.setText(getString(R.string.color_b) + "=" + progress);
                }
                updateColors();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        };

        seekBarR.setOnSeekBarChangeListener(listener);
        seekBarG.setOnSeekBarChangeListener(listener);
        seekBarB.setOnSeekBarChangeListener(listener);
    }

    private void updateColors() {
        // Màu RGB (Red, Green, Blue)
        int rgbColor = Color.rgb(currentR, currentG, currentB);
        colorBlockRgb.setBackgroundColor(rgbColor);


        int cmyR = 255 - currentR;
        int cmyG = 255 - currentG;
        int cmyB = 255 - currentB;

        int cmyColor = Color.rgb(cmyR, cmyG, cmyB);
        colorBlockCmy.setBackgroundColor(cmyColor);
    }
}
