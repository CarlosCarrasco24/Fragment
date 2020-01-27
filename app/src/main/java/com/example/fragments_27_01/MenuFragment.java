package com.example.fragments_27_01;


import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {
    private int[] botonesMenu={R.id.ibSensor,R.id.ibLinterna,R.id.ibMusica};
    private int [] botonesIluminado={R.drawable.herramientasb,R.drawable.linterna2,R.drawable.musica2};
    private int botonPulsado;
    MediaPlayer mp;
    public MenuFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_menu, container, false);
        ImageButton boton;
        botonPulsado=300;
        if(getArguments()!=null){
            botonPulsado=getArguments().getInt(MainActivity.BOTONPULSADO);
        }
        for(int i=0;i<botonesMenu.length;i++){
            boton=v.findViewById(botonesMenu[i]);
            if(i==botonPulsado){
                boton.setImageResource(botonesIluminado[i]);
            }
            final int indice=i;
            //pongo el listener a cada boton
            boton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    mp=MediaPlayer.create(getContext(),R.raw.clickboton);
                    mp.start();
                    Activity miActivity =getActivity();
                    ((InterfazMenu)miActivity).botonPulsado(indice);
                }
            });
        }
        return v;
    }
}
