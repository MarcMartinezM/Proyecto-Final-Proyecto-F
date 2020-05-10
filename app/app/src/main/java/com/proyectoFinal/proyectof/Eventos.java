package com.proyectoFinal.proyectof;

import android.content.Intent;
import android.content.SyncStatusObserver;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.proyectoFinal.proyectof.Adapters.Adaptador_eventos;
import com.proyectoFinal.proyectof.Conexiones.Get;
import com.proyectoFinal.proyectof.Objectos.Evento;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Eventos extends AppCompatActivity {
    public static String nombreEvento;
    public static  List<Evento> arrayEventos;
    public static Adaptador_eventos adapter;
    public static  ListView listaEventos;
    private ImageView icono_eventos,icono_entradas,icono_favoritos,icono_perfil;
    private EditText input_busqueda;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        String rutaURL = new String("http://proyectof.tk/api/events");
        try {
            JSONObject job = Get.getJSONObjectFromURL(rutaURL);
            System.out.println(job.toString());
            JSONArray arr = job.getJSONArray("data");
            for(int i=0;i<arr.length();i++){
                JSONObject jObj = arr.getJSONObject(i);
                String date = jObj.getString("name");
                System.out.println(date);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);
    }
    private ArrayList<Evento> getArray(){
        arrayEventos = new ArrayList<Evento>();
        arrayEventos.add(new Evento("27/4/2020", "Pacha Barcelona", 12.00, R.drawable.pacha, "23:00-05:00",true));

        arrayEventos.add(new Evento("27/4/2020", "Sala Apolo", 15.00, R.drawable.pacha, "23:00-05:00",false));
        return (ArrayList<Evento>) arrayEventos;
    }
    @Override
    protected void onResume() {
        super.onResume();


        listaEventos = (ListView) findViewById(R.id.lista_Tickets);
        adapter = new Adaptador_eventos(getArray(),this);
        listaEventos.setAdapter(adapter);



        input_busqueda =(EditText) findViewById(R.id.input_buscar);
        input_busqueda.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(count<before){
                    adapter.resetData();
                }
                adapter.getFilter().filter(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        listaEventos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Eventos.this, arrayEventos.get(position).getNombre_evento(),Toast.LENGTH_SHORT).show();
                nombreEvento = arrayEventos.get(position).getNombre_evento();
                Intent pagEntrada = new Intent(Eventos.this, InfoEvento.class);
                InfoEvento.nombreEventoPasar="";
                startActivity(pagEntrada);

            }
        });


        icono_eventos = (ImageView) findViewById(R.id.icono_eventos);
        icono_eventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Eventos.this,"Y a estas en la ventana eventos",Toast.LENGTH_SHORT).show();
            }
        });

        icono_entradas = (ImageView) findViewById(R.id.icono_ticket);
        icono_entradas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagTickets = new Intent(Eventos.this, Tickets.class);
                startActivity(pagTickets);
            }
        });
        icono_favoritos = (ImageView) findViewById(R.id.icono_guardados);
        icono_favoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagFavoritos = new Intent(Eventos.this, Favoritos.class);
                startActivity(pagFavoritos);
            }
        });

        icono_perfil = (ImageView) findViewById(R.id.icono_perfil);
        icono_perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagPerfil = new Intent(Eventos.this, Perfil.class);
                startActivity(pagPerfil);
            }
        });

        }
        /*
        public void openDialog(){
        Dialog_buscar db = new Dialog_buscar();
        db.show(getSupportFragmentManager(),"dialog buscar");
        }

    @Override
    public void applyTexts(String nombreBuscar,boolean existe) {

        nombre_evento=nombreBuscar;
        if(existe==true){
            text_busquerda.setText(nombreBuscar+" a sido encontrado.");
        }else{
            text_busquerda.setText(nombreBuscar+" no a sido encontrado.");
        }
    }*/

}

