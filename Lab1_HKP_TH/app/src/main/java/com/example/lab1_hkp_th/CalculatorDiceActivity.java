package com.example.lab1_hkp_th;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class CalculatorDiceActivity extends AppCompatActivity {

    // Khai báo cho MÁY TÍNH
    private EditText etSoHang1;
    private EditText etSoHang2;
    private TextView tvKetQuaMayTinh;

    // Khai báo cho XÚC XẮC
    private TextView tvKetQuaXucXac;
    private ImageView ivXucXac;
    private Random random = new Random();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Sử dụng layout gộp Máy tính và Xúc xắc
        setContentView(R.layout.activity_calculator_dice);

        // 1. Ánh xạ VIEW của MÁY TÍNH
        etSoHang1 = findViewById(R.id.et_so_hang_1);
        etSoHang2 = findViewById(R.id.et_so_hang_2);
        tvKetQuaMayTinh = findViewById(R.id.tv_ket_qua_may_tinh);

        // Thiết lập sự kiện cho các nút phép tính
        findViewById(R.id.btn_cong).setOnClickListener(v -> tinhToan('+'));
        findViewById(R.id.btn_tru).setOnClickListener(v -> tinhToan('-'));
        findViewById(R.id.btn_nhan).setOnClickListener(v -> tinhToan('*'));
        findViewById(R.id.btn_chia).setOnClickListener(v -> tinhToan('/'));
        findViewById(R.id.btn_phan_du).setOnClickListener(v -> tinhToan('%'));

        // 2. Ánh xạ VIEW của XÚC XẮC
        tvKetQuaXucXac = findViewById(R.id.tv_ket_qua_xuc_xac);
        // btnTungXucXac không cần khai báo biến vì dùng findViewById trực tiếp
        ivXucXac = findViewById(R.id.iv_xuc_xac);

        // Thiết lập sự kiện tung xúc xắc
        findViewById(R.id.btn_tung_xuc_xac).setOnClickListener(v -> tungXucXacBangSo());
        // Đặt ảnh mặc định
        ivXucXac.setImageResource(R.drawable.ic_dice_1);
    }

    private void tinhToan(char phepTinh) {
        String s1 = etSoHang1.getText().toString();
        String s2 = etSoHang2.getText().toString();

        if (s1.isEmpty() || s2.isEmpty()) {
            Toast.makeText(this, "MT: Vui lòng nhập đủ hai số.", Toast.LENGTH_SHORT).show();
            return;
        }
        // ... (Logic tinhToan giữ nguyên như code trước đó)
        try {
            double so1 = Double.parseDouble(s1);
            double so2 = Double.parseDouble(s2);
            double ketQua = 0;

            switch (phepTinh) {
                case '+': ketQua = CalculatorCore.cong(so1, so2); break;
                case '-': ketQua = CalculatorCore.tru(so1, so2); break;
                case '*': ketQua = CalculatorCore.nhan(so1, so2); break;
                case '/':
                    ketQua = CalculatorCore.chia(so1, so2);
                    break;
                case '%':
                    ketQua = CalculatorCore.phanDu(so1, so2);
                    break;
            }

            tvKetQuaMayTinh.setText(String.valueOf(ketQua));

        } catch (NumberFormatException e) {
            Toast.makeText(this, "MT: Đầu vào phải là số hợp lệ.", Toast.LENGTH_LONG).show();
            tvKetQuaMayTinh.setText("Lỗi nhập liệu");
        } catch (ArithmeticException e) {
            Toast.makeText(this, "MT: " + e.getMessage(), Toast.LENGTH_LONG).show();
            tvKetQuaMayTinh.setText("Lỗi toán học");
        }
    }

    private void tungXucXacBangSo() {
        int soNgauNhien = random.nextInt(6) + 1;
        tvKetQuaXucXac.setText(String.valueOf(soNgauNhien));

        int drawableResourceId = getResources().getIdentifier(
                "ic_dice_" + soNgauNhien,
                "drawable",
                getPackageName()
        );
        ivXucXac.setImageResource(drawableResourceId);
    }
}