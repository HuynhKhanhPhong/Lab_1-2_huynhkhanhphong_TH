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

public class Lab6CurrencyActivity extends AppCompatActivity {

    private EditText txtNumber;
    private Spinner spnUnits;
    private TextView[] lblResults;
    private DecimalFormat decimalFormat;


    private final double[][] ratio = {
            // USD      EUR      GBP      INR      AUD      CAD      ZAR      NZD      JPY      VND
            {1.00000, 0.80518, 0.64070, 63.3318, 1.21828, 1.16236, 11.7129, 1.29310, 118.337, 21385.7}, // USD (0)
            {1.24172, 1.00000, 0.79575, 78.6084, 1.51266, 1.44314, 14.5371, 1.60576, 146.927, 26561.8}, // EUR (1)
            {1.56044, 1.25667, 1.00000, 98.7848, 1.90091, 1.81355, 18.2683, 2.01791, 184.638, 33374.9}, // GBP (2)
            {0.01580, 0.01272, 0.01012, 1.00000, 0.01924, 0.01836, 0.18493, 0.02043, 1.86910, 337.811}, // INR (3)
            {0.82114, 0.66119, 0.52620, 52.0860, 1.00000, 0.95416, 9.61148, 1.06158, 97.1120, 17567.9}, // AUD (4)
            {0.86059, 0.69296, 0.55148, 54.5885, 1.04804, 1.00000, 10.0732, 1.11258, 101.777, 18401.7}, // CAD (5)
            {0.08541, 0.06877, 0.05473, 5.40852, 0.10398, 0.09924, 1.00000, 0.11037, 10.0996, 1825.87}, // ZAR (6)
            {0.77402, 0.62319, 0.49597, 49.0031, 0.94215, 0.89951, 9.06754, 1.00000, 91.5139, 16552.1}, // NZD (7)
            {0.00846, 0.00681, 0.00542, 0.53547, 0.01030, 0.00983, 0.09908, 0.01093, 1.00000, 180.837}, // JPY (8)
            {0.00005, 0.00004, 0.00003, 0.00296, 0.00006, 0.00005, 0.00055, 0.00006, 0.00553, 1.00000}  // VND (9)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab6_currency);


        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        decimalFormat = new DecimalFormat("#.00000", symbols);


        txtNumber = findViewById(R.id.txtNumber);
        spnUnits = findViewById(R.id.spnUnit);

        // Kết nối mảng TextView kết quả
        lblResults = new TextView[] {
                findViewById(R.id.Lblusd), findViewById(R.id.lblEur), findViewById(R.id.lblGbp),
                findViewById(R.id.lblInr), findViewById(R.id.lblAud), findViewById(R.id.lblCad),
                findViewById(R.id.lblZar), findViewById(R.id.lblNzd), findViewById(R.id.lblJpy),
                findViewById(R.id.lblVnd)
        };


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.currency_units_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spnUnits.setAdapter(adapter);

        setupListeners();
    }

    private void setupListeners() {

        spnUnits.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> argo, View arg1, int arg2, long arg3) {
                changeMoneyUnit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) { }
        });


        txtNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence argo, int arg1, int arg2, int arg3) { }

            @Override
            public void onTextChanged(CharSequence argo, int arg1, int arg2, int arg3) {
                changeMoneyUnit();
            }

            @Override
            public void afterTextChanged(Editable arg) { }
        });


        changeMoneyUnit();
    }

    private void changeMoneyUnit() {

        int rowIdx = spnUnits.getSelectedItemPosition();
        if (rowIdx < 0) rowIdx = 0;


        String input = txtNumber.getText().toString();

        double number = 0;
        try {
            if (!input.isEmpty()) {
                number = Double.parseDouble(input);
            }
        } catch (NumberFormatException e) {

            number = 0;
        }

        for (int i = 0; i < lblResults.length; i++) {
            double temp = number * ratio[rowIdx][i];
            lblResults[i].setText(decimalFormat.format(temp));
        }
    }
}
