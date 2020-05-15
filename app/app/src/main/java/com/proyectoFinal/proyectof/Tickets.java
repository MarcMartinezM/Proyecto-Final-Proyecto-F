package com.proyectoFinal.proyectof;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.proyectoFinal.proyectof.Objectos.Ticket;

import java.util.ArrayList;
import java.util.List;

public class Tickets extends AppCompatActivity {
    private EditText text_Buscar;
    private ListView lista_Tickets;
    private ImageView icono_eventos,icono_entradas,icono_favoritos,icono_perfil;
    private ArrayAdapter<String> adapter;
    private String[] arrayNombreTicket;
    private String[] arrayCodigoTicket;
    public static String codigo;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets);
    }

    public String[] getArrayNombreTicket(){
        arrayNombreTicket = new String[Login.tickets.size()];
        arrayCodigoTicket = new String[Login.tickets.size()];
        for(int i=0;i<Login.tickets.size();i++) {
            for(int j=0;j<Eventos.arrayEventos.size();j++){
                if(Login.tickets.get(i).getEvent_id().equals(Eventos.arrayEventos.get(j).getEvento_id())){
                    arrayNombreTicket[i]="EVENTO: "+ Eventos.arrayEventos.get(j).getNombre_evento()+" FECHA COMPRA: "+Login.tickets.get(i).getFecha_compra();
                    arrayCodigoTicket[i]=Login.tickets.get(i).getTicket_id();
                }
            }
        }
       return arrayNombreTicket;
    }


    @Override
    protected void onResume() {
        super.onResume();


        lista_Tickets = (ListView)findViewById(R.id.lista_Tickets);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,getArrayNombreTicket());
        lista_Tickets.setAdapter(adapter);
        lista_Tickets.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                codigo= arrayCodigoTicket[position];
                openDialogTicket();
            }
        });
        text_Buscar = (EditText) findViewById(R.id.input_buscar_ticket);
        text_Buscar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        icono_eventos = (ImageView) findViewById(R.id.icono_eventos_ticket);
        icono_eventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagEventos = new Intent(Tickets.this,Eventos.class );
                startActivity(pagEventos);
            }
        });
        icono_entradas = (ImageView) findViewById(R.id.icono_ticket_ticket);
        icono_entradas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Tickets.this,"Ya estas en la ventana Tickets",Toast.LENGTH_SHORT).show();
            }
        });
        icono_favoritos = (ImageView) findViewById(R.id.icono_guardados_ticket);
        icono_favoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagFavoritos = new Intent(Tickets.this,Favoritos.class);
                startActivity(pagFavoritos);
            }
        });
        icono_perfil = (ImageView) findViewById(R.id.icono_perfil_ticket);
        icono_perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagPerfil = new Intent(Tickets.this,Perfil.class);
                startActivity(pagPerfil);
            }
        });
    }
    public void openDialogTicket(){
        Dialog_infoTicket dialogTicket = new Dialog_infoTicket();
        dialogTicket.show(getSupportFragmentManager(),"dialog ticket");
    }
}
