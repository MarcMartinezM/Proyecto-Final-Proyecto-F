package com.proyectoFinal.proyectof;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.proyectoFinal.proyectof.Objectos.Evento;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Eventos extends AppCompatActivity {

    public static List<Evento> arrayEventos = new ArrayList<Evento>();
    public ArrayAdapter<Evento> adapter;
    public ListView listaEventos;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);
    }

    @Override
    protected void onResume() {
        super.onResume();

        arrayEventos.add(new Evento("27/4/2020", "Pacha Barcelona", 12.00, "pacha"));
        arrayEventos.add(new Evento("27/4/2020", "Sala Apolo", 15.00, "pacha"));
        adapter = new ArrayAdapter<Evento>(this, R.layout.activity_eventos, arrayEventos) {

            @Override
            public View getView(int pos, View convertView, ViewGroup parent) {

                if (convertView == null) {
                    convertView = getLayoutInflater().inflate(R.layout.item_lista_eventos, parent, false);
                }
                ((TextView) convertView.findViewById(R.id.text_fecha)).setText(getItem(pos).getFecha_evento());
                ((TextView) convertView.findViewById(R.id.text_nombre_evento)).setText(getItem(pos).getNombre_evento());
                ((TextView)convertView.findViewById(R.id.text_precio)).setText(getItem(pos).getPrecio_evento()+" €");
                String arxiuImg = getItem(pos).getFoto_evento();
                Uri uri = (new Uri.Builder())
                        .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                        .authority(getResources().getResourcePackageName(R.drawable.pacha))
                        .appendPath(getResources().getResourceTypeName(R.drawable.pacha))
                        //.appendPath(getResources().getResourceEntryName(R.drawable.cocacola))
                        .appendPath( arxiuImg )
                        .build();
                ImageView imgview = (ImageView) convertView.findViewById(R.id.imageView);
                imgview.setImageURI(uri);
                return convertView;
            }
            };
        listaEventos = (ListView) findViewById(R.id.lista_eventos);
        listaEventos.setAdapter(adapter);
        }
    }

