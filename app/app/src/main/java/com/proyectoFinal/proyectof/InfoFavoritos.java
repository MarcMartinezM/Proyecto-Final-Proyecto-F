package com.proyectoFinal.proyectof;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InfoFavoritos extends AppCompatActivity {
    public static String IDFavoritosPasar;
    ImageView imagen_evento,imagen_atras;
    TextView text_titulo,text_precio_entrada,text_horario,text_hora,text_descrip,text_cantidad_tickets,text_localidad,text_Cantidad;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_favoritos);
    }
    @Override
    protected void onResume() {
        super.onResume();
        IDFavoritosPasar = Favoritos.IDFavoritos;
        imagen_evento = (ImageView) findViewById(R.id.imagen_evento_fav);


        imagen_atras = (ImageView) findViewById(R.id.image_atras_favo);
        imagen_atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagFavoritos = new Intent(InfoFavoritos.this, Favoritos.class);
                startActivity(pagFavoritos);
            }
        });
        text_titulo = (TextView) findViewById(R.id.text_titulo_evento_fav);
        text_descrip = (TextView) findViewById(R.id.text_descripcion_fav);
        text_localidad = (TextView) findViewById(R.id.text_localidad_fav);
        text_precio_entrada = (TextView) findViewById(R.id.text_precio_entrada_fav);
        text_horario = (TextView) findViewById(R.id.text_horario_fav);
        text_hora = (TextView) findViewById(R.id.text_Hora_fav);

        for (int i = 0; i < Favoritos.arrayFavoritos.size(); i++) {
            if (IDFavoritosPasar.equalsIgnoreCase(Favoritos.arrayFavoritos.get(i).getEvento_id_fav())) {
                imagen_evento.setImageResource(Favoritos.arrayFavoritos.get(i).getFoto_evento_fav());
                text_titulo.setText(Favoritos.arrayFavoritos.get(i).getNombre_evento_fav());
                text_descrip.setText(Favoritos.arrayFavoritos.get(i).getDescripcion_fav());
                text_localidad.setText(Favoritos.arrayFavoritos.get(i).getLocalizacion_fav());
                text_precio_entrada.setText(text_precio_entrada.getText() + " " + Favoritos.arrayFavoritos.get(i).getPrecio_evento_fav() + "€");
                text_horario.setText(text_horario.getText() + " " + Favoritos.arrayFavoritos.get(i).getFecha_evento_fav());
                text_hora.setText(Favoritos.arrayFavoritos.get(i).getHorario_evento_fav());


            }
        }
    }
}
