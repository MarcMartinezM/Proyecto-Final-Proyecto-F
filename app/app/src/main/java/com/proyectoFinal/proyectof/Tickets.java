package com.proyectoFinal.proyectof;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
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
    public static List<Ticket> arrayTickets;
    private String[] arrayNombreTicket;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets);
    }
    public String[] getArrayNombreTicket(){
        arrayTickets = new ArrayList<Ticket>();
        arrayTickets.add(new Ticket("Pacha Barcelona",3));
        arrayTickets.add(new Ticket("Sala Apolo",1));
        arrayNombreTicket = new String[arrayTickets.size()];
        for(int i=0;i<arrayTickets.size();i++) {
            arrayNombreTicket[i] = arrayTickets.get(i).getNombre_Ticket();
        }
       return arrayNombreTicket;
    }
    @Override
    protected void onResume() {
        super.onResume();


        lista_Tickets = (ListView)findViewById(R.id.lista_Tickets);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,getArrayNombreTicket());
        lista_Tickets.setAdapter(adapter);
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
                Toast.makeText(Tickets.this,"Y a estas en la ventana Tickets",Toast.LENGTH_SHORT).show();
            }
        });
        icono_favoritos = (ImageView) findViewById(R.id.icono_guardados_ticket);
        icono_perfil = (ImageView) findViewById(R.id.icono_perfil_ticket);
    }
}
