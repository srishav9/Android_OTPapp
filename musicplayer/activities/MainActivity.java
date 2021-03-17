package com.example.risha.musicplayer.activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.risha.musicplayer.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button play,pause;
    MediaPlayer song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play=(Button)findViewById(R.id.play);
        pause=(Button)findViewById(R.id.pause);
        song=MediaPlayer.create(this,R.raw.robbers);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(MainActivity.this,MyServices.class));
            }
        });

        pause.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        stopService(new Intent(MainActivity.this,MyServices.class));
    }

    @Override
    protected void onDestroy() {
        Log.i("Activity: ","Destroy() callled");
        stopService(new Intent(MainActivity.this,MyServices.class));
        super.onDestroy();
    }
}
