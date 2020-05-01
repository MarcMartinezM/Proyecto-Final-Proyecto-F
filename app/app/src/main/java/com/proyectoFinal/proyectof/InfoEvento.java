package com.proyectoFinal.proyectof;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.proyectoFinal.proyectof.Adapters.Adaptador_entrada;
import com.proyectoFinal.proyectof.Objectos.Evento;

import java.util.ArrayList;
import java.util.List;

import static com.proyectoFinal.proyectof.R.drawable.icono_corazon_llemo;

public class InfoEvento extends AppCompatActivity {
    public static String nombreEventoPasar;
    ImageView imagen_evento, imagen_deseado,imagen_atras;

    TextView text_titulo,text_precio_entrada,text_horario,text_hora,text_cantidad;

    Button boton_comprar,boton_mas,boton_menos;
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


        imagen_deseado=(ImageView) findViewById(R.id.imagen_deseado);
        imagen_deseado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imagen_deseado.getBackground().equals(R.drawable.icono_corazon_vacio)){
                    imagen_deseado.setImageResource(icono_corazon_llemo);

                }else{
                    imagen_deseado.setImageResource(R.drawable.icono_corazon_vacio);
                }
            }
        });

        text_titulo = (TextView) findViewById(R.id.text_titulo_evento);
        text_precio_entrada = (TextView) findViewById(R.id.text_precio_entrada);
        text_horario = (TextView) findViewById(R.id.text_horario);
        text_hora = (TextView) findViewById(R.id.text_Hora);
        text_cantidad = (TextView) findViewById(R.id.text_cantidad);
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
                Log.i("cantidad",text_cantidad.getText().toString());
                String sumar;
                sumar = text_cantidad.getText().toString();
                String[] separar = sumar.split(" ");
                int numero = Integer.parseInt(separar[0]);
                numero=numero++;
                sumar=numero+separar[1];
                text_cantidad.setText(sumar);
            }
        });


        boton_menos = (Button) findViewById(R.id.boton_menos);

        boton_menos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text_cantidad.getText().equals("0x")){
                    Toast.makeText(InfoEvento.this,"No puedes disminuir mas",Toast.LENGTH_SHORT).show();
                }else{
                    String restar= text_cantidad.getText().toString();
                    String[] separar = restar.split(" ");
                    int numero = Integer.parseInt(separar[0]);
                    numero=numero--;
                    restar=numero+separar[1];
                    text_cantidad.setText(restar);

                }
            }
        });

    }
}
