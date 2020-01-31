package com.example.fragments_27_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements InterfazMenu{

    public static final String BOTONPULSADO="b";
    public static CameraManager camManager = null;
    public static final int REQUEST_CAMARA=223;
    public static boolean encendido=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mandarDatos();
    }

    @Override
    public void botonPulsado(int id) {
        Intent i=new Intent(this,SecondActivity.class);
        i.putExtra(BOTONPULSADO,id);
        startActivity(i);
    }
    public void mandarDatos(){
        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CAMERA},REQUEST_CAMARA);
        encendido=getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        camManager=(CameraManager)getSystemService(Context.CAMERA_SERVICE);
    }

}
