package com.rizkyandra3008.kalkulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et1, et2;
    TextView tvhasil;
    Button btTambah, btKurang, btKali, btBagi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.number1);
        et2 = (EditText) findViewById(R.id.number2);
        tvhasil = (TextView) findViewById(R.id.textViewHasil);
        btTambah = (Button) findViewById(R.id.buttonTambah);
        btKurang = (Button) findViewById(R.id.buttonKurang);
        btKali = (Button) findViewById(R.id.buttonKali);
        btBagi = (Button) findViewById(R.id.buttonBagi);

        btTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x1 = Integer.parseInt(et1.getText().toString().trim());
                int x2 = Integer.parseInt(et2.getText().toString().trim());
                int hasil = x1 + x2;
                String jumlah = String.valueOf(hasil);
                tvhasil.setText(jumlah);
            }
        });

        btKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x1 = Integer.parseInt(et1.getText().toString().trim());
                int x2 = Integer.parseInt(et2.getText().toString().trim());
                int hasil = x1 - x2;
                String kurang = String.valueOf(hasil);
                tvhasil.setText(kurang);
            }
        });

        btKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x1 = Integer.parseInt(et1.getText().toString().trim());
                int x2 = Integer.parseInt(et2.getText().toString().trim());
                int hasil = x1 * x2;
                String kali = String.valueOf(hasil);
                tvhasil.setText(kali);
            }
        });

        btBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x1 = Integer.parseInt(et1.getText().toString().trim());
                int x2 = Integer.parseInt(et2.getText().toString().trim());
                int hasil = x1 / x2;
                String bagi = String.valueOf(hasil);
                tvhasil.setText(bagi);
            }
        });
    }
}