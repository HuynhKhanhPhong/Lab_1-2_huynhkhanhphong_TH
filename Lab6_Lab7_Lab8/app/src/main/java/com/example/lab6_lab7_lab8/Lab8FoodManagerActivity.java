package com.example.lab6_lab7_lab8;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab6_lab7_lab8.adapters.MyListViewAdapter;
import com.example.lab6_lab7_lab8.models.Product;

import java.util.ArrayList;

public class Lab8FoodManagerActivity extends AppCompatActivity {

    private ListView lvFoodMenu;
    private ArrayList<Product> foodList;

    // Dữ liệu mẫu (chỉ hiển thị)
    private final String[] titles = {"Hamburger", "Bánh mì", "Bánh bao", "Bánh ú", "Bánh giò chay", "Bánh giò nhân thịt"};
    private final String[] contents = {
            "Bánh mì kẹp thịt trên (Giá: 12.000₫)",
            "Bánh mì kẹp thịt (Giá: 10.000₫)",
            "Bánh bao nhân thịt, trứng (Giá: 12.000₫)",
            "Bánh ú dùng cho cỗ, lễ (Giá: 5.000₫)",
            "Bánh giò chay bằng nếp hoặc sắn (Giá: 6.000₫)",
            "Bánh giò nếp, tẻ có nhân thịt (Giá: 6.000₫)"
    };
    // Placeholder images - cần thay bằng ảnh món ăn thực tế (hamburger.png, banhmi.png,...)
    private final int[] imgs = {
            R.drawable.hamburger_img, R.drawable.banhmi_img, R.drawable.banhbao_img,
            R.drawable.banhu_img, R.drawable.banhgiochay_img, R.drawable.banhgionhanthit_img
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab8_food_manager);

        lvFoodMenu = findViewById(R.id.lvFoodMenu);

        // 1. Chuẩn bị dữ liệu
        foodList = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            // Nội dung sẽ là sự kết hợp giữa mô tả và giá
            String contentWithPrice = contents[i];
            foodList.add(new Product(imgs[i], titles[i], contentWithPrice));
        }

        // 2. Khởi tạo và gán Adapter
        MyListViewAdapter adapter = new MyListViewAdapter(this, foodList);
        lvFoodMenu.setAdapter(adapter);
    }
}