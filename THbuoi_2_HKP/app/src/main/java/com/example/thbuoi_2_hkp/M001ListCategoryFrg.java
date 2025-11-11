package com.example.thbuoi_2_hkp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class M001ListCategoryFrg extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Tải layout danh sách chủ đề
        View rootView = inflater.inflate(R.layout.m001_frg_category_list, container, false);

        // Giả sử: Lấy container chứa các category item (từ layout XML)
        // Trong layout m001_frg_category_list.xml, đây là LinearLayout bên trong ScrollView
        LinearLayout containerLayout = rootView.findViewById(R.id.ln_categories_container);

        // Ví dụ: Thêm sự kiện click cho mục đầu tiên ("Công sở")
        if (containerLayout != null && containerLayout.getChildCount() > 0) {
            // Lấy item đầu tiên trong danh sách
            View firstItem = containerLayout.getChildAt(0);
            firstItem.setOnClickListener(v -> {
                // Khi click vào chủ đề, chuyển sang màn hình danh sách truyện (M002)
                gotoM002Screen("Công sở");
            });
        }

        return rootView;
    }

    private void gotoM002Screen(String topicName) {
        // Kiểm tra Activity có tồn tại không và gọi phương thức chuyển màn hình
        if (getActivity() instanceof TruyenCuoiActivity) {
            // Gọi phương thức trong Activity để chuyển Fragment
            ((TruyenCuoiActivity) getActivity()).gotoM002Screen(topicName);
        }
    }
}