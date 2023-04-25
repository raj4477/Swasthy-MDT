package com.example.swasthy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
   Button deviceInfo;
   Button lightSensor;
   Button accelerometer;
   Button camera;
   Button battery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        deviceInfo = (Button) findViewById(R.id.deviceInfo);
        lightSensor = (Button) findViewById(R.id.lightSensor);
        accelerometer = (Button) findViewById(R.id.accelerometer_sensor_button);
        camera = (Button) findViewById(R.id.camera);
        battery = (Button) findViewById(R.id.batteryButtton);
                deviceInfo.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent in = new Intent(MainActivity.this,Device_Info.class);
                        startActivity(in);
                    }
                }
        );
        lightSensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this,Light_Sensor.class);
                startActivity(in);
            }
        });
        accelerometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this,Accelerometer_Sensor.class);
                startActivity(in);
            }
        });
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this,CameraActivity.class);
                startActivity(in);
            }
        });
        battery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this,BatteryActivity.class);
                startActivity(in);
            }
        });
    }
}