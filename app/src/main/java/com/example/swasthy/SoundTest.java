package com.example.swasthy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class SoundTest extends AppCompatActivity {
    Button start,pause;
    SeekBar seekBar;
    AudioManager audioManager;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        seekBar=findViewById(R.id.seekBar);
        audioManager = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
//        seekBar.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
//        seekBar.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
        setContentView(R.layout.activity_sound_test);
        start=(Button)findViewById(R.id.PlaySound);
        pause=(Button)findViewById(R.id.PauseSound);
         mp= MediaPlayer.create(SoundTest.this, R.raw.music);
        try{
            mp.prepare();
        }catch(Exception e){e.printStackTrace();}
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.pause();
    }
}