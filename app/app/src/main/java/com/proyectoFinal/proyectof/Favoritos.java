package com.proyectoFinal.proyectof;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.proyectoFinal.proyectof.Adapters.adaptador_fav;
import com.proyectoFinal.proyectof.Objectos.Favorito;

import java.util.ArrayList;
import java.util.List;

public class Favoritos extends AppCompatActivity {
    public static String IDFavoritos;
    public static List<Favorito>  arrayFavoritos;
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
        lista_fav.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Favoritos.this, arrayFavoritos.get(position).getNombre_evento_fav(),Toast.LENGTH_SHORT).show();
                IDFavoritos = arrayFavoritos.get(position).getEvento_id_fav();
                Intent pagInfoFavortios = new Intent(Favoritos.this, InfoFavoritos.class);
                InfoFavoritos.IDFavoritosPasar="";
                startActivity(pagInfoFavortios);
            }
        });

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
        arrayFavoritos = new ArrayList<Favorito>();
            Log.i("TAMAÑO ARRAY EVENTOS",Eventos.arrayEventos.size()+"");
            for(int i=0;i<Login.favoritos.size();i++){
                for(int j=0;j<Eventos.arrayEventos.size();j++){
                    if(Login.favoritos.get(i).equals(Eventos.arrayEventos.get(j).getEvento_id())){
                        arrayFavoritos.add(new Favorito(Eventos.arrayEventos.get(j).getEvento_id(),Eventos.arrayEventos.get(j).getDescripcion(),Eventos.arrayEventos.get(j).getFecha_evento(),
                                Eventos.arrayEventos.get(j).getNombre_evento(),Eventos.arrayEventos.get(j).getPrecio_evento(),Eventos.arrayEventos.get(j).getFoto_evento(),
                                Eventos.arrayEventos.get(j).getHorario_evento(),Eventos.arrayEventos.get(j).getImagen_url(),Eventos.arrayEventos.get(j).getStatus(),Eventos.arrayEventos.get(j).getLocalizacion()));
                    }
                }
            }
        return (ArrayList<Favorito>) arrayFavoritos;
    }


    }
