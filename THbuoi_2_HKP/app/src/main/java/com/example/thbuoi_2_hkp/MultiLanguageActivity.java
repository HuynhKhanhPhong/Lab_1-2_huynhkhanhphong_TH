package com.example.thbuoi_2_hkp;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class MultiLanguageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login_multilang);
        setTitle(R.string.app_name);
    }

    // ----------------------------------------------------------------
    // 1. Tạo Option Menu (Sử dụng res/menu/language_menu.xml)
    // ----------------------------------------------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.language_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.language_vietnamese) {
            setLocale("vi");
            return true;
        } else if (id == R.id.language_english) {
            setLocale("en");
            return true;
        } else if (id == R.id.language_french) {
            setLocale("fr");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void setLocale(String languageCode) {
        Locale locale = new Locale(languageCode);

        Resources resources = getResources();
        Configuration config = resources.getConfiguration();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            config.setLocale(locale);
        } else {
            config.locale = locale;
        }

        resources.updateConfiguration(config, resources.getDisplayMetrics());

        // Khởi tạo lại Activity để áp dụng ngôn ngữ mới ngay lập tức
        Intent refresh = new Intent(this, MultiLanguageActivity.class);
        startActivity(refresh);
        finish();
    }
}