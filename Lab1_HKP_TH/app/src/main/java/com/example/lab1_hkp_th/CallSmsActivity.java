package com.example.lab1_hkp_th;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class CallSmsActivity extends AppCompatActivity {

    private EditText etPhoneNumber;
    private final int REQUEST_CALL_PERMISSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_sms); // Sử dụng layout riêng

        etPhoneNumber = findViewById(R.id.et_phone_number);

        findViewById(R.id.btn_call).setOnClickListener(v -> checkCallPermissionAndCall());
        findViewById(R.id.btn_sms).setOnClickListener(v -> sendSms());
    }

    // --- LOGIC GỌI ĐIỆN ---
    private void checkCallPermissionAndCall() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL_PERMISSION);
        } else {
            makeCall();
        }
    }

    private void makeCall() {
        String phoneNumber = etPhoneNumber.getText().toString().trim();
        if (phoneNumber.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập số điện thoại.", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + phoneNumber));
            startActivity(callIntent);
        } catch (SecurityException e) {
            Toast.makeText(this, "Lỗi quyền truy cập gọi điện.", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makeCall();
            } else {
                Toast.makeText(this, "Quyền CALL_PHONE bị từ chối.", Toast.LENGTH_LONG).show();
            }
        }
    }

    // --- LOGIC GỬI TIN NHẮN ---
    private void sendSms() {
        String phoneNumber = etPhoneNumber.getText().toString().trim();
        String messageBody = "Xin chào, đây là tin nhắn thử nghiệm.";

        if (phoneNumber.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập số điện thoại.", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent smsIntent = new Intent(Intent.ACTION_VIEW);
        smsIntent.setData(Uri.parse("sms:" + phoneNumber));
        smsIntent.putExtra("sms_body", messageBody);

        if (smsIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(smsIntent);
        } else {
            Toast.makeText(this, "Không tìm thấy ứng dụng nhắn tin nào.", Toast.LENGTH_SHORT).show();
        }
    }
}