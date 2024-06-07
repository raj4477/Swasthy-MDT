package com.example.swasthy;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SensorList extends AppCompatActivity  implements MyListView.customButtonListener {
    SensorManager sm = null;
    TextView textView = null;
    List<Sensor> sensorsLists;
    ListView list;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_list);
//        textView = (TextView) findViewById(R.id.SensorText);
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensorsLists = sm.getSensorList(Sensor.TYPE_ALL);
        list = (ListView) findViewById(R.id.list);

        int [] sensorIds = new int[sensorsLists.size()];
        String [] sensorName = new String[sensorIds.length];
        String str = "";

        for(int i = 0; i<sensorsLists.size();i++){
            String strSensor =sensorsLists.get(i).getStringType();
            if(strSensor.length() > 15)
            sensorName[i] = (strSensor.substring(15));
            sensorIds[i] = (sensorsLists.get(i).getId());
            long l = 1000;
            try {
//                sensorsLists.get(i).wait(l);
                System.out.println("----------*****----------");
                System.out.println(sensorsLists.get(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
            String s = sensorsLists.get(i).getStringType() + "-----"+sensorsLists.get(i).getName()+"\n";
            str  = str + s;
//            textView.setText(str);
        }
        MyListView myListView = new MyListView(this,sensorName,sensorIds);
        myListView.setCustomButtonListner(SensorList.this);
        list.setAdapter(myListView);




    }

    @Override
    public void onButtonClickListner(int position, String value) {
        Toast.makeText(SensorList.this,value,Toast.LENGTH_SHORT).show();
        Intent in = new Intent(SensorList.this,SensorActivityTemplate.class);
        if(value.equals("accelerometer") ){
        Intent i = new Intent(SensorList.this,Accelerometer_Sensor.class);
//            i.putExtra("SensorName",value);
            startActivity(i);

        }
        else{
            in.putExtra("SensorName", value);
            startActivity(in);
        }

    }
}