package com.example.risha.splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Handler h=new Handler();
        h.postDelayed(new Runnable() {      //creating thread;
            @Override
            public void run() {
                Intent i;
                i = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        },3000);
    }
}
