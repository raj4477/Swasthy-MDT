package com.example.swasthy;

import android.app.Activity;
import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class MyListView extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] sensorName;
    private final int[] sensorId;
    customButtonListener customListner;

    public interface customButtonListener {
        public void onButtonClickListner(int position,String value);
    }
    public void setCustomButtonListner(customButtonListener listener) {
        this.customListner = listener;
    }


    public MyListView(Activity context, String[] sensorName, int[] sensorId) {
        super(context, R.layout.list_item, sensorName);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.sensorName = sensorName;
        this.sensorId = sensorId;


    }

//    public MyListView(SensorList context, List sensorName, List sensorIds) {
//        super();
//    }

    public View getView(int position, View view, ViewGroup parent) {
        View rowView = view;
        if(rowView == null){

        LayoutInflater inflater = context.getLayoutInflater();

        rowView = inflater.inflate(R.layout.list_item, parent, false);
        }
        TextView sName = (TextView) rowView.findViewById(R.id.sensorName);
        TextView sType = (TextView) rowView.findViewById(R.id.sensorType);

        sName.setText(sensorName[position]);
        sType.setText("");
        Button checkButton = (Button) rowView.findViewById(R.id.SensorCheckButton);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (customListner != null) {
                    customListner.onButtonClickListner(position,sensorName[position]);

                }
            }
        });
        return rowView;


    }
}
