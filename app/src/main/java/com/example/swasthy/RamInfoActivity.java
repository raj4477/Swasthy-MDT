package com.example.swasthy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.widget.TextView;

import java.text.DecimalFormat;

public class RamInfoActivity extends AppCompatActivity {
    long bytesAvailable, megAvailable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ram_info);
        StatFs statFs = new StatFs(Environment.getDownloadCacheDirectory().getPath());
        bytesAvailable = statFs.getBlockCountLong()  * statFs.getAvailableBlocksLong();

        megAvailable = bytesAvailable / (1024 * 1024 );
//        megAvailable *= 0.0009765625;
        TextView tx = findViewById(R.id.ramInfoText);
        tx.setText(getMemoryInfo());
    }
    private String getMemoryInfo(){
        Context context = getApplicationContext();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);

        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);

        DecimalFormat twoDecimalFormate = new DecimalFormat( "#.##");

        String finalvalue = "";
        long totalMemory = memoryInfo.totalMem;

        double kb = totalMemory/1024.0;
        double mb = totalMemory/1048576.0;
        double gb = totalMemory/1073741824.0;
        double tb = totalMemory/1099511627776.0;

        if (tb>1){
            finalvalue = twoDecimalFormate.format(tb).concat(" TB");
        } else if (gb > 1) {
            finalvalue = twoDecimalFormate.format(gb).concat(" GB");

        }
        else if (mb > 1) {
            finalvalue = twoDecimalFormate.format(mb).concat(" MB");
        }
        else if (kb > 1){
            finalvalue = twoDecimalFormate.format(kb).concat(" KB");
        }
        else
        {
            finalvalue = twoDecimalFormate.format(totalMemory).concat(" Bytes");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RAM: ").append(finalvalue).append("\n").
                append("Available Internal/External free space: " + megAvailable + "MB");
        return stringBuilder.toString();
    }
}


