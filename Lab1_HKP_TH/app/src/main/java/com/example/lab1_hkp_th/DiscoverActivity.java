package com.example.lab1_hkp_th;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.os.Bundle;
import android.widget.Toast;

public class DiscoverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover);

        // Ánh xạ và xử lý sự kiện cho ô "New Arrival" (Bài tập 5)
        CardView cardNewArrival = findViewById(R.id.card_new_arrival);

        cardNewArrival.setOnClickListener(v -> {
            Toast.makeText(this, "Đã chuyển đến mục Hàng Mới (New Arrival)!", Toast.LENGTH_SHORT).show();
        });

        // Bạn có thể thêm xử lý sự kiện cho các CardView khác tại đây nếu cần
    }
}