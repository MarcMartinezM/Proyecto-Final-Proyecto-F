package com.proyectoFinal.proyectof;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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

    public static  List<Evento> arrayEventos;
    private Adaptador_eventos adapter;
    private ListView listaEventos;
    private ImageView icono_eventos,icono_entradas,icono_favoritos,icono_buscar,icono_perfil;
    private EditText input_busqueda;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);
    }
    private ArrayList<Evento> getArray(){
        arrayEventos = new ArrayList<Evento>();
        arrayEventos.add(new Evento("27/4/2020", "Pacha Barcelona", 12.00, R.drawable.pacha));
        arrayEventos.add(new Evento("27/4/2020", "Sala Apolo", 15.00, R.drawable.pacha));
        return (ArrayList<Evento>) arrayEventos;
    }
    @Override
    protected void onResume() {
        super.onResume();


        listaEventos = (ListView) findViewById(R.id.lista_eventos);
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


        icono_buscar = (ImageView) findViewById(R.id.icono_buscar);
        icono_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
        icono_favoritos = (ImageView) findViewById(R.id.icono_guardados);
        icono_perfil = (ImageView) findViewById(R.id.icono_perfil);

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

