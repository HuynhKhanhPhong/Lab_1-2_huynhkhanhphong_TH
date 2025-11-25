package com.example.lab10_11_hkp;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

import com.example.lab10_11_hkp.MainActivity;
import com.example.lab10_11_hkp.R;

import java.io.IOException;

public class M001TopicFrg extends Fragment implements View.OnClickListener {
    private Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.m001_frg_topic, container, false);
        initViews(rootView);
        return rootView;
    }

    private void initViews(View v) {
        LinearLayout lnMain = v.findViewById(R.id.In_topic);
        lnMain.removeAllViews();

        try {
            // Lấy danh sách tên tệp ảnh trong thư mục "photo" của assets
            String[] listItem = mContext.getAssets().list("photo");
            if (listItem == null) return;

            for (String fileName : listItem) {
                // Lấy tên chủ đề (tên file không có phần mở rộng .png, ví dụ: "Cong so.png" -> "Cong so")
                String name = fileName.substring(0, fileName.lastIndexOf("."));

                // Tạo View từ layout item_topic.xml
                View vTopic = LayoutInflater.from(mContext).inflate(R.layout.item_topic, null);

                // Ánh xạ View con
                ImageView ivTopic = vTopic.findViewById(R.id.iv_topic);
                TextView tvTopic = vTopic.findViewById(R.id.tv_topic);

                // Set ảnh cho ImageView bằng cách đọc từ assets
                ivTopic.setImageBitmap(BitmapFactory
                        .decodeStream(mContext.getAssets().open("photo/" + fileName)));

                // Set tên cho TextView
                tvTopic.setText(name);

                // Thêm View chủ đề vào LinearLayout chính
                lnMain.addView(vTopic);

                // Thiết lập LayoutParams cho marginBottom
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) vTopic.getLayoutParams();
                if (params != null) {
                    params.bottomMargin = 40; // Đặt margin 40 như trong hướng dẫn [cite: 373]
                    vTopic.setLayoutParams(params);
                }

                // Lưu tên chủ đề vào Tag của View để sử dụng khi click
                vTopic.setTag(name);
                vTopic.setOnClickListener(this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        // Chuyển sang màn hình M002StoryFrg khi click vào một chủ đề [cite: 383]
        String topicName = (String) v.getTag();
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).gotoM002Screen(topicName);
        }
    }
}