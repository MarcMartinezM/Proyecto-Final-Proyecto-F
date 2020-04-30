package com.proyectoFinal.proyectof;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;

public class InfoEvento extends AppCompatActivity {
    public static String nombreEventoPasar = Eventos.nombreEvento;
    ImageView imagen_evento;
    TextView text_titulo,text_precio_entrada,text_horario;
    ListView lista_horario;
    Button boton_comprar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor_evento);
    }
    @Override
    protected void onResume() {
        super.onResume();
        imagen_evento = (ImageView) findViewById(R.id.imagen_evento);
        text_titulo = (TextView) findViewById(R.id.text_titulo_evento);
        text_precio_entrada = (TextView) findViewById(R.id.text_precio_entrada);
        text_horario = (TextView) findViewById(R.id.text_horario);
        lista_horario = (ListView) findViewById(R.id.lista_horario);
        boton_comprar = (Button) findViewById(R.id.boton_comprar);
        for(int i=0;i<Eventos.arrayEventos.size();i++){
            if(nombreEventoPasar.equalsIgnoreCase(Eventos.arrayEventos.get(i).getNombre_evento())){
                text_titulo.setText(Eventos.arrayEventos.get(i).getNombre_evento());
                text_precio_entrada.setText(text_precio_entrada.getText()+" "+Eventos.arrayEventos.get(i).getPrecio_evento()+"€");
                text_horario.setText(text_horario.getText()+" "+Eventos.arrayEventos.get(i).getFecha_evento());
            }
        }
    }
}
