package com.example.swasthy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SensorActivityTemplate extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_template);
        textView = (TextView) findViewById(R.id.textView2);
        String s =  getIntent().getStringExtra("SensorName");
        textView.setText(s);

    }
}