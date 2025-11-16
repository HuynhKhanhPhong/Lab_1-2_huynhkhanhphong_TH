package com.example.lab4_lab5_hkp;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private TextView btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m001_act_login);


        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);

        // Logic Bài tập 1: Custom Toast
        btnLogin.setOnClickListener(v -> showLoginSuccessToast());
    }

    private void showLoginSuccessToast() {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();


        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast_login,
                (ViewGroup) findViewById(R.id.custom_toast_container));

        TextView textDetails = layout.findViewById(R.id.toast_details);
        String details = String.format("Email: %s | Mật khẩu: %s", email, password);
        textDetails.setText(details);

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 100);
        toast.setView(layout);
        toast.show();
    }
}