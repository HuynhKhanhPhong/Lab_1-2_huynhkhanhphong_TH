package com.example.lab6_lab7_lab8.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab6_lab7_lab8.R;
import com.example.lab6_lab7_lab8.models.Product;

import java.util.ArrayList;
import java.util.List;


public class MyListViewAdapter extends BaseAdapter {

    private final List<Product> list;
    private final Context context;

    // Constructor [cite: 392, 394]
    public MyListViewAdapter(Context context, List<Product> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            // Inflate layout cho từng dòng (row.xml) [cite: 409]
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.row_product, parent, false);
        }

        Product product = (Product) getItem(position);

        // Ánh xạ và gán dữ liệu
        ImageView img = view.findViewById(R.id.imgRow);
        img.setImageResource(product.image);

        TextView txtTitle = view.findViewById(R.id.txtTitle);
        txtTitle.setText(product.title);

        TextView txtContent = view.findViewById(R.id.txtContent);
        txtContent.setText(product.content);

        return view;
    }
}