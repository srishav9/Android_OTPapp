package com.example.risha.musicplayer.activities;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.risha.musicplayer.R;

/**
 * Created by risha on 31-Dec-17.
 */

public class MyServices extends Service
{
    private MediaPlayer mediaPlayer;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }

    @Override
    public void onCreate() {
        mediaPlayer= MediaPlayer.create(this, R.raw.robbers);
        mediaPlayer.setLooping(false);  //to stop it from playing the same song always.
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        Log.i("Service: ","Stop() callled");
        super.onDestroy();
    }
}
