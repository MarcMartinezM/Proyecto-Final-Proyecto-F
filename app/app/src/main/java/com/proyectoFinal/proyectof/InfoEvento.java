package com.proyectoFinal.proyectof;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ThemedSpinnerAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.proyectoFinal.proyectof.Adapters.Adaptador_entrada;
import com.proyectoFinal.proyectof.Objectos.Evento;

import java.util.ArrayList;
import java.util.List;

import static com.proyectoFinal.proyectof.R.drawable.icono_corazon_llemo;

public class InfoEvento extends AppCompatActivity {
    public static String nombreEventoPasar;
    ImageView imagen_evento,imagen_atras;
    TextView text_titulo,text_precio_entrada,text_horario,text_hora,text_Cantidad;
    Button boton_comprar,boton_mas,boton_menos,boton_fav;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor_evento);
    }
    @Override
    protected void onResume() {
        super.onResume();
        nombreEventoPasar = Eventos.nombreEvento;
        imagen_evento = (ImageView) findViewById(R.id.imagen_evento);


        imagen_atras = (ImageView) findViewById(R.id.image_atras);
        imagen_atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagEvento = new Intent(InfoEvento.this, Eventos.class);
                startActivity(pagEvento);
            }
        });

        boton_fav = (Button) findViewById(R.id.button_fav);
        boton_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(boton_fav.getBackground().equals(R.drawable.icono_corazon_vacio)){
                    boton_fav.setBackgroundResource(R.drawable.icono_corazon_llemo);
                }else{
                    boton_fav.setBackgroundResource(R.drawable.icono_corazon_llemo);
                }
            }
        });
        /*
        imagen_deseado=(ImageView) findViewById(R.id.imagen_deseado);
        imagen_deseado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imagen_deseado.getBackground().equals(R.drawable.icono_corazon_vacio)){
                    imagen_deseado.setBackgroundResource(R.drawable.icono_corazon_llemo);

                }else{
                    imagen_deseado.setBackgroundResource(R.drawable.icono_corazon_vacio);
                }
            }
        });
*/
        text_titulo = (TextView) findViewById(R.id.text_titulo_evento);
        text_precio_entrada = (TextView) findViewById(R.id.text_precio_entrada);
        text_horario = (TextView) findViewById(R.id.text_horario);
        text_hora = (TextView) findViewById(R.id.text_Hora);
        text_Cantidad =(TextView) findViewById(R.id.text_cantidad);
        text_Cantidad.setText("0 x");
        boton_comprar = (Button) findViewById(R.id.boton_comprar);



        for(int i=0;i<Eventos.arrayEventos.size();i++){
            if(nombreEventoPasar.equalsIgnoreCase(Eventos.arrayEventos.get(i).getNombre_evento())){
                imagen_evento.setImageResource(Eventos.arrayEventos.get(i).getFoto_evento());
                text_titulo.setText(Eventos.arrayEventos.get(i).getNombre_evento());
                text_precio_entrada.setText(text_precio_entrada.getText()+" "+Eventos.arrayEventos.get(i).getPrecio_evento()+"€");
                text_horario.setText(text_horario.getText()+" "+Eventos.arrayEventos.get(i).getFecha_evento());
                text_hora.setText(Eventos.arrayEventos.get(i).getHorario_evento());


            }
        }
        boton_mas = (Button) findViewById(R.id.boton_mas);
        boton_mas.setText("+");
        boton_mas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          //      Log.i("cantidad",text_cantidad.getText().toString());
                String sumar;
                sumar =  text_Cantidad.getText().toString();
                String[] separar = sumar.split(" ");
                int numero = Integer.parseInt(separar[0]);
                Log.i("cantidad",numero+"");
                numero=numero+1;
                sumar=numero+" "+separar[1];
                text_Cantidad.setText(sumar);
            }
        });


        boton_menos = (Button) findViewById(R.id.boton_menos);

        boton_menos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( text_Cantidad.getText().toString().equals("0 x")){
                    Toast.makeText(InfoEvento.this,"No puedes disminuir mas",Toast.LENGTH_SHORT).show();
                }else{
                    String restar=  text_Cantidad.getText().toString();
                    String[] separar = restar.split(" ");
                    int numero = Integer.parseInt(separar[0]);
                    numero=numero-1;
                    restar=numero+" "+separar[1];
                    text_Cantidad.setText(restar);

                }
            }
        });

    }
}
