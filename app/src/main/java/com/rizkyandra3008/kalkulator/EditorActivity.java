package com.rizkyandra3008.kalkulator;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rizkyandra3008.kalkulator.helper.Helper;

import java.text.DateFormat;
import java.util.Calendar;

public class EditorActivity extends AppCompatActivity implements SensorEventListener {

    private TextView tv_suhu, tv_date, tv_time;
    private Button btSimpan;
    private Helper db = new Helper(this);
    private String suhu, date, time;

    private SensorManager sensorManager;
    private Sensor tempSensor;
    private Boolean isTempAvailable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
        setTitle("Tambah Data");

        Calendar calendar = Calendar.getInstance();
        date = DateFormat.getDateInstance(android.icu.text.DateFormat.FULL).format(calendar.getTime());

        tv_suhu = findViewById(R.id.text_suhu);
        tv_date = findViewById(R.id.text_date);
        tv_time = findViewById(R.id.text_time);
        btSimpan = findViewById(R.id.btnSimpan);

        tv_date.setText(date);
        tv_time.setText(date);

        //SENSOR
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        if (sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE) != null) {
            tempSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
            isTempAvailable = true;
        } else {
            tv_suhu.setText("Sensor tidak tersedia");
            isTempAvailable = false;
        }

        btSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    add();
                } catch (Exception e) {
                    Log.e("Saving", e.getMessage());
                }
            }
        });
    }

    private void add() {
        if (String.valueOf(tv_suhu.getText()).equals("") || String.valueOf(tv_date.getText()).equals("") || String.valueOf(tv_time.getText()).equals("")) {
            Toast.makeText(getApplicationContext(), "Silahkan isi semua data!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Data berhasil disimpan!", Toast.LENGTH_SHORT).show();
            db.insert(tv_suhu.getText().toString(), tv_date.getText().toString(), tv_time.getText().toString());
            finish();
        }
    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        tv_suhu.setText(sensorEvent.values[0] + " °C");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isTempAvailable) {
            sensorManager.registerListener(this, tempSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isTempAvailable) {
            sensorManager.unregisterListener(this);
        }
    }
}