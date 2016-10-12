package com.example.tadeu_000.myapplication;

import android.app.ListActivity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    SeekBar sb;
    AudioManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer mp = MediaPlayer.create(this,R.raw.testsound);
        Button playSound = (Button) this.findViewById(R.id.btnplay);
        Button stopSound = (Button) this.findViewById(R.id.btnstop);

        sb = (SeekBar)findViewById(R.id.sbVolume);
        am = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        int maxV = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curV = am.getStreamVolume(AudioManager.STREAM_MUSIC);
        sb.setMax(maxV);
        sb.setProgress(curV);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                am.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        playSound.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mp.start();
            }
        });

        stopSound.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mp.pause();
            }
        });

    }
}
