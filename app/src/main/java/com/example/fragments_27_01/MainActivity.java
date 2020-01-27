package com.example.fragments_27_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements InterfazMenu{

    public static final String BOTONPULSADO="b";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void botonPulsado(int id) {
        Intent i=new Intent(this,SecondActivity.class);
        i.putExtra(BOTONPULSADO,id);
        startActivity(i);
    }
}
