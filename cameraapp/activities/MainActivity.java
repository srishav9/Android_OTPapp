package com.example.risha.cameraapp.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.risha.cameraapp.R;

import static com.example.risha.cameraapp.utils.Constants.CAMERA_OPN_CODE;
import static com.example.risha.cameraapp.utils.Constants.CAMERA_REQ_CODE;

public class MainActivity extends AppCompatActivity {
    ImageView iv;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv=findViewById(R.id.iv);
        btn=findViewById(R.id.btn_capture);
    }

    public void onClick(View view) {
        if (view.getId()==R.id.btn_capture){
            if (Build.VERSION.SDK_INT>=23) {
                /*
                23 os for MarshMallow
                String str[]=Manifest.permission.CAMERA
                101 any integer number for reference to this permission result.
                */
                requestPermissions(new String[]{Manifest.permission.CAMERA}, CAMERA_REQ_CODE);
                //popup generated yes or no.
            }
            else
                openCamera();
        }
    }

    //callback from the permission.

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                if(requestCode== CAMERA_REQ_CODE){
                    if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
                        openCamera();
                    }

                    //camera request code is for permission
                    //include this in a for look if manny permissions required to check for [0],[1],.....
                }
    }

    public void openCamera() {


        Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//implicit intent
        // choosing window will be implicit
        //implicit done at compile time.
        //requestCode is for camera open code
        startActivityForResult(i, CAMERA_OPN_CODE);
    }
    //callback method from startActivityForResult : onActivityForResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode== CAMERA_OPN_CODE && resultCode==RESULT_OK) {
            //result_ok means we clicked an image and didn't just click back!
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                iv.setImageBitmap(bitmap);
        }
    }
    public static class
}
