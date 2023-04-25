package com.example.swasthy;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class Light_Sensor extends AppCompatActivity {
    TextView textLIGHT_available, textLIGHT_reading;
    SensorManager mySensorManager;
    Sensor lightSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_sensor);
        textLIGHT_available
                = (TextView)findViewById(R.id.LIGHT_available);
        textLIGHT_reading
                = (TextView)findViewById(R.id.LIGHT_reading);



        mySensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);

        lightSensor = mySensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if(lightSensor != null){
        textLIGHT_available.setText("Sensor.TYPE_LIGHT Available");
        mySensorManager.registerListener(
                lightSensorListener,
                lightSensor,
                SensorManager.SENSOR_DELAY_NORMAL);

    } else {
        textLIGHT_available.setText("Sensor.TYPE_LIGHT NOT Available");
    }
}

    private final SensorEventListener lightSensorListener = new SensorEventListener(){

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            if(event.sensor.getType() == Sensor.TYPE_LIGHT){
                textLIGHT_reading.setText("LIGHT: " + event.values[0]);
            }
        }

    };


    @Override
    protected void onStop() {
//        mySensorManager.unregisterListener(lightSensorListener);
        super.onStop();
    }
}