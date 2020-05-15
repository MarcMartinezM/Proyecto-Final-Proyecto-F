package com.proyectoFinal.proyectof;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ThemedSpinnerAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.proyectoFinal.proyectof.Adapters.Adaptador_entrada;
import com.proyectoFinal.proyectof.Conexiones.Post;
import com.proyectoFinal.proyectof.Objectos.Evento;
import com.proyectoFinal.proyectof.Objectos.Favorito;
import com.proyectoFinal.proyectof.Objectos.Ticket;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.proyectoFinal.proyectof.R.drawable.icono_corazon_llemo;

public class InfoEvento extends AppCompatActivity implements Dialog_CompraTargeta.dialogListener{
    public static String IDEventoPasar;
    ImageView imagen_evento,imagen_atras;
    TextView text_titulo,text_precio_entrada,text_horario,text_hora,text_descrip,text_cantidad_tickets,text_localidad;
    public static TextView text_Cantidad;
    public static int tickets_dispo, numero;
    boolean estalleno ;
    Button boton_comprar,boton_mas,boton_menos,boton_fav;
    Ticket ticket1 = new Ticket();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor_evento);
    }
    @Override
    protected void onResume() {
        super.onResume();
        IDEventoPasar = Eventos.IDEvento;
        imagen_evento = (ImageView) findViewById(R.id.imagen_evento);


        imagen_atras = (ImageView) findViewById(R.id.image_atras);
        imagen_atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagEvento = new Intent(InfoEvento.this, Eventos.class);
                startActivity(pagEvento);
            }
        });
        text_titulo = (TextView) findViewById(R.id.text_titulo_evento);
        text_descrip = (TextView) findViewById(R.id.text_descripcion);
        text_localidad = (TextView) findViewById(R.id.text_localidad);
        text_precio_entrada = (TextView) findViewById(R.id.text_precio_entrada);
        text_horario = (TextView) findViewById(R.id.text_horario);
        text_hora = (TextView) findViewById(R.id.text_Hora);
        text_cantidad_tickets = (TextView) findViewById(R.id.text_cantidad_ticket_disponibles);
        text_Cantidad = (TextView) findViewById(R.id.text_cantidad);
        text_Cantidad.setText("0 x");
        boton_comprar = (Button) findViewById(R.id.boton_comprar);
        boton_comprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean abrir =false;
                int noEsta=0;
                int suma=0;
                if(text_Cantidad.getText().toString().equalsIgnoreCase("0 x")){
                    Toast.makeText(InfoEvento.this, "la cantidad de tickets es 0", Toast.LENGTH_SHORT).show();
                }else if(tickets_dispo==0 || tickets_dispo<numero){
                        Toast.makeText(InfoEvento.this, "No quedan suficientes tickets", Toast.LENGTH_SHORT).show();
                }
                else{

                    if(Login.tickets.size()!=0){
                        for(int i=0;i<Login.tickets.size();i++) {
                            if(Login.tickets.get(i).getEvent_id().equals(IDEventoPasar)){
                                suma= suma+Login.tickets.get(i).getCantidad_ticket();
                                Log.i("tickets que poses", Login.tickets.get(i).getCantidad_ticket() + "");
                                //    SI ES MAS PEQUEÑO ENTRA

                            }else{
                                noEsta ++;
                            }
                        }
                        if(suma<5){
                            suma = suma + numero;
                            Log.i("la suma", suma + "");
                            if(suma<=5){
                                abrir = true;
                            }else{
                                Toast.makeText(InfoEvento.this, "no puedes comprar mas de los que tienes", Toast.LENGTH_SHORT).show();
                                abrir = false;
                            }
                        }else{
                            Toast.makeText(InfoEvento.this, "Ya tienes el maximo posibles.", Toast.LENGTH_SHORT).show();
                        }
                        Log.i("klk",abrir+"");
                        if(abrir==true){
                            openDialog();
                        }
                        if(noEsta== Login.tickets.size()){
                            openDialog();
                        }
                    }else{
                        openDialog();
                    }


                }

            }
        });

        for (int i = 0; i < Eventos.arrayEventos.size(); i++) {
            if (IDEventoPasar.equalsIgnoreCase(Eventos.arrayEventos.get(i).getEvento_id())) {
                imagen_evento.setImageResource(Eventos.arrayEventos.get(i).getFoto_evento());
                text_titulo.setText(Eventos.arrayEventos.get(i).getNombre_evento());
                text_descrip.setText(Eventos.arrayEventos.get(i).getDescripcion());
                text_localidad.setText(Eventos.arrayEventos.get(i).getLocalizacion());
                text_precio_entrada.setText(text_precio_entrada.getText() + " " + Eventos.arrayEventos.get(i).getPrecio_evento() + "€");
                text_horario.setText(text_horario.getText() + " " + Eventos.arrayEventos.get(i).getFecha_evento());
                text_hora.setText(Eventos.arrayEventos.get(i).getHorario_evento());
                text_cantidad_tickets.setText(text_cantidad_tickets.getText()+" "+Eventos.arrayEventos.get(i).getTickets_disponibles());
                tickets_dispo= Eventos.arrayEventos.get(i).getTickets_disponibles();

            }
        }

        boton_mas = (Button) findViewById(R.id.boton_mas);
        boton_mas.setText("+");
        boton_mas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //      Log.i("cantidad",text_cantidad.getText().toString());
                if(text_Cantidad.getText().toString().equals("5 x")){
                    Toast.makeText(InfoEvento.this, "No puedes adquirir mas", Toast.LENGTH_SHORT).show();
                }else{
                    String sumar;
                    sumar = text_Cantidad.getText().toString();
                    String[] separar = sumar.split(" ");
                    numero = Integer.parseInt(separar[0]);
                    numero = numero + 1;
                    Log.i("cantidad", numero + "");
                    sumar = numero + " " + separar[1];
                    text_Cantidad.setText(sumar);
                }

            }
        });


        boton_menos = (Button) findViewById(R.id.boton_menos);

        boton_menos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text_Cantidad.getText().toString().equals("0 x")) {
                    Toast.makeText(InfoEvento.this, "No puedes disminuir mas", Toast.LENGTH_SHORT).show();
                } else {
                    String restar = text_Cantidad.getText().toString();
                    String[] separar = restar.split(" ");
                    numero = Integer.parseInt(separar[0]);
                    numero = numero - 1;
                    restar = numero + " " + separar[1];
                    text_Cantidad.setText(restar);

                }
            }
        });

        boton_fav = (Button) findViewById(R.id.button_fav);
        if(Login.arrayUsuario.get(0).getFavoritos().size()==0){
            boton_fav.setBackgroundResource(R.drawable.icono_corazon_vacio);
            estalleno=false;
        }else{
            for(int i=0;i<Login.arrayUsuario.get(0).getFavoritos().size();i++){
                if(!Login.arrayUsuario.get(0).getFavoritos().equals(null)){
                    if(Login.arrayUsuario.get(0).getFavoritos().get(i).equalsIgnoreCase(IDEventoPasar)){
                        boton_fav.setBackgroundResource(R.drawable.icono_corazon_llemo);
                        estalleno=true;
                    }else{
                        boton_fav.setBackgroundResource(R.drawable.icono_corazon_vacio);
                        estalleno=false;
                    }
                }

            }
        }

        boton_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(estalleno==false){
                    boton_fav.setBackgroundResource(icono_corazon_llemo);
                    Login.favoritos.add(IDEventoPasar);
                    estalleno=true;
                }else{
                    boton_fav.setBackgroundResource(R.drawable.icono_corazon_vacio);
                    Login.favoritos.remove(IDEventoPasar);
                    estalleno=false;
                }

                try {
                    Evento ev = new Evento();
                    for (int i = 0; i < Eventos.arrayEventos.size(); i++){
                        if(Eventos.arrayEventos.get(i).getEvento_id().equals(IDEventoPasar)){
                            ev = Eventos.arrayEventos.get(i);
                        }
                    }

                    JSONObject evFav = new JSONObject();
                    evFav.put("uid", Login.usu.getIdUsuario());
                    evFav.put("event_id", ev.getEvento_id());
                    evFav.put("fav", estalleno);
                    JSONObject job = Post.getJSONObjectFromURL("http://proyectof.tk/api/user/fav-event", evFav);

                }catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });



        }

    public void openDialog(){
        Dialog_CompraTargeta dialog_comprar = new Dialog_CompraTargeta();
        dialog_comprar.show(getSupportFragmentManager(),"dialog Compra Targeta");
    }

    @Override
    public void applyText(Long numeroTargeta, String fecha, int CVC) {
        String nombreTextDip= "Tickets Disponibles:";
        text_cantidad_tickets.setText(nombreTextDip+" "+tickets_dispo);
        Evento ev = new Evento();
        for (int i = 0; i < Eventos.arrayEventos.size(); i++){
            if(Eventos.arrayEventos.get(i).getEvento_id().equals(IDEventoPasar)){
                ev = Eventos.arrayEventos.get(i);
            }
        }

        try {
            JSONObject tick = new JSONObject();
            tick.put("event_id", ev.getEvento_id());
            tick.put("qty", numero);
            tick.put("uid", Login.usu.getIdUsuario());
            tick.put("number", numeroTargeta);
            tick.put("expires", fecha);
            tick.put("ccv", CVC);
            tick.put("nameOnCard", Login.usu.getNombre_real());

            JSONObject job = Post.getJSONObjectFromURL("http://proyectof.tk/api/tickets/buy", tick);

            System.out.println(job.toString());
            String status = job.optString("status");
            JSONObject respu= job.getJSONObject("ticket");
            String fechaCompra = respu.getString("bought_at");
            String ticket_id = respu.getString("ticket_code");

            ticket1.setCantidad_ticket(numero);
            ticket1.setEvent_id(ev.getEvento_id());
            ticket1.setFecha_compra(fechaCompra);
            ticket1.setTicket_id(ticket_id);

            Login.tickets.add(ticket1);
            Login.arrayUsuario.get(0).setTickets(Login.tickets);

            if (status.equalsIgnoreCase("OK")) {
                Toast.makeText(InfoEvento.this,"COMPRADO",Toast.LENGTH_SHORT).show();
                text_Cantidad.setText("0 x");
            } else {
                Toast.makeText(InfoEvento.this,"NO COMPRADO",Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
