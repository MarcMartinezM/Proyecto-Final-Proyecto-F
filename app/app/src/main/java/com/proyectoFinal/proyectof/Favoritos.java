package com.proyectoFinal.proyectof;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.proyectoFinal.proyectof.Adapters.adaptador_fav;
import com.proyectoFinal.proyectof.Objectos.Favorito;

import java.util.ArrayList;
import java.util.List;

public class Favoritos extends AppCompatActivity {
    public static List<Favorito>  arrayFavoritos = new ArrayList<Favorito>();
    private ListView lista_fav;
    private ImageView icono_eventos,icono_entradas,icono_favoritos,icono_perfil;
    public static adaptador_fav adaptador;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);
    }

    @Override
    protected void onResume() {
        super.onResume();
        lista_fav = (ListView) findViewById(R.id.lista_fav);

        adaptador = new adaptador_fav(getTrueArray(),this);

        lista_fav.setAdapter(adaptador);


        icono_eventos = (ImageView) findViewById(R.id.icono_eventos_fav);
        icono_eventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagEventos = new Intent(Favoritos.this, Eventos.class);
                startActivity(pagEventos);
            }
        });

        icono_entradas = (ImageView) findViewById(R.id.icono_ticket_fav);
        icono_entradas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagTickets = new Intent(Favoritos.this, Tickets.class);
                startActivity(pagTickets);
            }
        });
        icono_favoritos = (ImageView) findViewById(R.id.icono_guardados_fav);
        icono_favoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Favoritos.this,"Y a estas en la ventana Favoritos",Toast.LENGTH_SHORT).show();
            }
        });
        icono_perfil = (ImageView) findViewById(R.id.icono_perfil_fav);
        icono_perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagPerfil = new Intent(Favoritos.this,Perfil.class);
                startActivity(pagPerfil);
            }
        });
    }
    private ArrayList<Favorito> getTrueArray(){

            Log.i("TAMAÑO ARRAY EVENTOS",Eventos.arrayEventos.size()+"");
        for(int i=0;i<Eventos.arrayEventos.size();i++){
                if(Eventos.arrayEventos.get(i).getFavorito_evento()==true)
                arrayFavoritos.add(new Favorito(Eventos.arrayEventos.get(i).getFecha_evento(),Eventos.arrayEventos.get(i).getNombre_evento(),Eventos.arrayEventos.get(i).getPrecio_evento(),Eventos.arrayEventos.get(i).getFoto_evento(),Eventos.arrayEventos.get(i).getHorario_evento(),Eventos.arrayEventos.get(i).getFavorito_evento()));
        }
        return (ArrayList<Favorito>) arrayFavoritos;
    }
    }
