package com.example.lab6_lab7_lab8;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Lab7CustomControlsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab7_custom_controls);
    }


    public void showCustomToast(View view) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast_layout,
                (ViewGroup) findViewById(R.id.custom_toast_container));

        TextView text = layout.findViewById(R.id.toast_text);
        text.setText(getString(R.string.toast_message));

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setView(layout);
        toast.show();
    }

    public void showCustomDialog(View view) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog_layout);
        dialog.setTitle(getString(R.string.dialog_title));

        final EditText edtUsername = dialog.findViewById(R.id.edtUsername);
        final EditText edtPassword = dialog.findViewById(R.id.edtPassword);
        Button btnLogin = dialog.findViewById(R.id.btnDialogLogin);
        Button btnCancel = dialog.findViewById(R.id.btnDialogCancel);

        btnLogin.setOnClickListener(v -> {
            String username = edtUsername.getText().toString();
            String password = edtPassword.getText().toString();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(Lab7CustomControlsActivity.this, "Vui lòng nhập đầy đủ Tên và Mật khẩu!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(Lab7CustomControlsActivity.this, "Đăng nhập thành công! Chào " + username, Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        btnCancel.setOnClickListener(v -> dialog.dismiss());

        dialog.show();
    }
}