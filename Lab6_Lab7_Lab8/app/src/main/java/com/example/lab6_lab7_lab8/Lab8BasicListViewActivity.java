package com.example.lab6_lab7_lab8;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab6_lab7_lab8.adapters.MyListViewAdapter;
import com.example.lab6_lab7_lab8.models.Product;

import java.util.ArrayList;

public class Lab8BasicListViewActivity extends AppCompatActivity {

    private ListView lvMain;
    private TextView txtDisplay;

    // Khai báo dữ liệu
    private final String[] titles = new String[] {
            getString(R.string.title_android),
            getString(R.string.title_ios),
            getString(R.string.title_wp)
    };
    private final String[] contents = new String[] {
            getString(R.string.content_android),
            getString(R.string.content_ios),
            getString(R.string.content_wp)
    };

    private final int[] imgs = new int[] {
            R.drawable.android_icon,
            R.drawable.ios_icon,
            R.drawable.windows_mobile_icon
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab8_basic_listview);

        // 1. Ánh xạ View
        lvMain = findViewById(R.id.lvMain);
        txtDisplay = findViewById(R.id.txtDisplay);

        // 2. Chuẩn bị dữ liệu cho Custom Adapter
        ArrayList<Product> list = new ArrayList<>();
        for(int i = 0; i < titles.length; i++){
            list.add(new Product(imgs[i], titles[i], contents[i]));
        }

        // 3. Khởi tạo và gán Custom Adapter
        MyListViewAdapter adapter = new MyListViewAdapter(this, list);
        lvMain.setAdapter(adapter);

        // 4. Xử lý sự kiện click
        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedTitle = titles[position];
                txtDisplay.setText(getString(R.string.selected_item) + " " + selectedTitle);
            }
        });
    }
}
