package com.example.swasthy;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Accelerometer_Sensor extends AppCompatActivity {
    SensorManager sm = null;
    TextView textView = null;
    List list;
    SensorEventListener sel = new SensorEventListener(){
        public void onAccuracyChanged(Sensor sensor, int accuracy) {}
        public void onSensorChanged(SensorEvent event) {
            if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
//                ViewGroup.LayoutParams paramsz = null;
                View vz=findViewById(R.id.line_id_z);
                ViewGroup.LayoutParams  paramsz = vz.getLayoutParams();

//                ViewGroup.LayoutParams paramsx = null;
                View vx=findViewById(R.id.line_id_x);
                ViewGroup.LayoutParams paramsx = vx.getLayoutParams();


//                ViewGroup.LayoutParams paramsy = null;
                View vy=findViewById(R.id.line_id_y);
                ViewGroup.LayoutParams   paramsy = vy.getLayoutParams();

                float[] values = event.values;
                textView.setText("x: "+values[0]+"\ny: "+values[1]+"\nz: "+values[2]);
                paramsz.width = 100 + (((int) values[2]) *10);
                paramsx.width = 100 + (((int) values[0]) *10);
                paramsy.width = 100 + (((int) values[1]) *10);

                vz .setLayoutParams(paramsz);
                vx .setLayoutParams(paramsx);
                vy .setLayoutParams(paramsy);

            }

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer_sensor);
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        textView = (TextView)findViewById(R.id.accelerometerTextValue);
        list = sm.getSensorList(Sensor.TYPE_ACCELEROMETER);
        if(list.size()>0){
            sm.registerListener(sel, (Sensor) list.get(0), SensorManager.SENSOR_DELAY_NORMAL);
        }else{
            Toast.makeText(getBaseContext(), "Error: No Accelerometer.", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    protected void onStop() {
        if(list.size()>0){
            sm.unregisterListener(sel);
        }
        super.onStop();
    }
}