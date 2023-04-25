package com.example.swasthy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Device_Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_info);
        String Model = "MODEL: " + Build.MODEL;
        String Id = "ID: " + Build.ID;
        String Manufacture = "MANUFACTURER: " + Build.MANUFACTURER;
        String Brand = "BRAND: " + Build.BRAND;
        String Type = "TYPE: " + Build.TYPE;
        String User = "USER: " + Build.USER;
        String Base = "BASE: " + Build.VERSION_CODES.BASE;
        String Incremental = "INCREMENTAL: " + Build.VERSION.INCREMENTAL;
        String sdk = "SDK: " + String.valueOf(Build.VERSION.SDK_INT);
        String Board = "BOARD: " + Build.BOARD;
        String Host = "HOST: " + Build.HOST;
        String FingerPrint = "FINGERPRINT" + Build.FINGERPRINT;
        String VersionRelease = "RELEASE: " + Build.VERSION.RELEASE;


        String text = Model + "\n" + Id + "\n" + Manufacture + "\n" + Brand + "\n" + Type+ "\n" + User + "\n" + Base + "\n" + Incremental + "\n" + sdk + "\n" + Board +"\n"+ Host +"\n"+ FingerPrint +"\n" + VersionRelease;

        TextView buildText = (TextView) findViewById(R.id.textView);
        buildText.setText(text);
    }
}