package com.example.fragments_27_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class SecondActivity extends AppCompatActivity implements InterfazMenu{
    private int boton;
    private Fragment [] fragments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //inicializar fragments
        inicializarFragments();
        cargarDatos();
    }
    public void cargarDatos(){
        Bundle datos=new Bundle();
        datos=getIntent().getExtras();
        boton=datos.getInt(MainActivity.BOTONPULSADO);
        botonPulsado(boton);

    }
    public void inicializarFragments(){
        fragments=new Fragment[3];
        fragments[0]=new SensorFragment();
        fragments[1]=new LinternaFragment();
        fragments[2]=new MusicaFragment();
    }

    @Override
    public void botonPulsado(int id) {
        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        //-----------------------
        Fragment menuIluminado= new MenuFragment();
        Bundle datos=new Bundle();
        datos.putInt(MainActivity.BOTONPULSADO,id);
        menuIluminado.setArguments(datos);
        ft.replace(R.id.frangmentMenu2,menuIluminado);

        //Reemplaza lo que haya en el layour vertical por el frangment elegido a traves del imagebutton.
        ft.replace(R.id.lyContenedor,fragments[id]);
        ft.commit();

    }
}
