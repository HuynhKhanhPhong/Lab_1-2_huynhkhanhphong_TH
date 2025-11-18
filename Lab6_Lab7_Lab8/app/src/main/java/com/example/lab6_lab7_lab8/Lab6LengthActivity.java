package com.example.lab6_lab7_lab8;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Lab6LengthActivity extends AppCompatActivity {

    private EditText txtLengthNumber;
    private Spinner spnLengthUnit;
    private TextView[] lblLengthResults;
    private DecimalFormat decimalFormat;

    private final double[][] lengthRatio = {
            // Hải lý   Dặm      Km       Lý       Mét      Yard     Foot     Inch
            {1.00000000, 1.15077945, 1.8520000, 20.2537183, 1852.0000, 2025.37183, 6076.11549, 72913.38583}, // Hải lý
            {0.86897624, 1.00000000, 1.6093440, 17.6000000, 1609.3440, 1760.00000, 5280.00000, 63360.00000}, // Dặm
            {0.53995680, 0.62137119, 1.0000000, 10.9361330, 1000.0000, 1093.61330, 3280.83990, 39370.07874}, // Km
            {0.04937365, 0.05681818, 0.0914400, 1.0000000, 91.4400, 100.00000, 300.00000, 3600.00000},     // Lý
            {0.00053996, 0.00062137, 0.0010000, 0.0109361, 1.0000, 1.09361, 3.28084, 39.37008},             // Mét
            {0.00049374, 0.00056818, 0.0009144, 0.0100000, 0.9144, 1.00000, 3.00000, 36.00000},             // Yard
            {0.00016458, 0.00018939, 0.0003048, 0.0033333, 0.3048, 0.33333, 1.00000, 12.00000},             // Foot
            {0.00001371, 0.00001578, 0.0000254, 0.0002778, 0.0254, 0.02778, 0.08333, 1.00000}              // Inch
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab6_length);

        // Định dạng số để giữ độ chính xác cao hơn
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        decimalFormat = new DecimalFormat("#.0000", symbols);

        // 1. Kết nối các đối tượng View
        txtLengthNumber = findViewById(R.id.txtLengthNumber);
        spnLengthUnit = findViewById(R.id.spnLengthUnit);


        lblLengthResults = new TextView[] {
                findViewById(R.id.lblLengthNautical), findViewById(R.id.lblLengthMile), findViewById(R.id.lblLengthKm),
                findViewById(R.id.lblLengthLi), findViewById(R.id.lblLengthMet), findViewById(R.id.lblLengthYard),
                findViewById(R.id.lblLengthFoot), findViewById(R.id.lblLengthInch)
        };


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.length_units_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spnLengthUnit.setAdapter(adapter);

        // 3. Thiết lập các hàm xử lý sự kiện
        setupListeners();
    }

    private void setupListeners() {
        // Xử lý sự kiện khi thay đổi đơn vị gốc trong Spinner
        spnLengthUnit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> argo, View arg1, int arg2, long arg3) {
                changeLengthUnit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) { }
        });


        txtLengthNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence argo, int arg1, int arg2, int arg3) { }

            @Override
            public void onTextChanged(CharSequence argo, int arg1, int arg2, int arg3) {
                changeLengthUnit();
            }

            @Override
            public void afterTextChanged(Editable arg) { }
        });

        // Cập nhật kết quả lần đầu tiên
        changeLengthUnit();
    }


    private void changeLengthUnit() {
        int rowIdx = spnLengthUnit.getSelectedItemPosition();
        if (rowIdx < 0) rowIdx = 0;

        String input = txtLengthNumber.getText().toString();

        double number = 0;
        try {
            if (!input.isEmpty()) {
                number = Double.parseDouble(input);
            }
        } catch (NumberFormatException e) {
            number = 0;
        }

        // Tính toán và hiển thị kết quả
        for (int i = 0; i < lblLengthResults.length; i++) {
            double temp = number * lengthRatio[rowIdx][i];

            // Hiển thị kết quả
            lblLengthResults[i].setText(decimalFormat.format(temp));
        }
    }
}
