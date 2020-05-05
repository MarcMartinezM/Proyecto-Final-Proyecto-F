package com.proyectoFinal.proyectof.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.proyectoFinal.proyectof.Objectos.Favorito;
import com.proyectoFinal.proyectof.R;

import java.util.List;

public class adaptador_fav extends ArrayAdapter<Favorito> {
    private Context context;
    private static List<Favorito> arrayFavoritos;

    public adaptador_fav(List<Favorito> arrayFavoritos,Context context) {
        super(context, R.layout.item_lista_eventos,arrayFavoritos);
        this.context = context;
        this.arrayFavoritos = arrayFavoritos;
    }

    @Override
    public int getCount() {
        return arrayFavoritos.size();
    }

    @Override
    public Favorito getItem(int position) {
        return arrayFavoritos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Favorito eve = (Favorito) getItem(position);
        if(eve.getFavorito_evento_fav()==true){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_lista_eventos,null);
            TextView text_fecha = convertView.findViewById(R.id.text_fecha);
            TextView text_nombre_evento = convertView.findViewById(R.id.text_nombre_evento);
            TextView text_preco = convertView.findViewById(R.id.text_precio);
            ImageView imagen_evento = convertView.findViewById(R.id.imageView);

            text_fecha.setText(eve.getFecha_evento_fav());
            text_nombre_evento.setText(eve.getNombre_evento_fav());
            text_preco.setText(eve.getPrecio_evento_fav()+" €");
            imagen_evento.setImageResource(eve.getFoto_evento_fav());
        }


        return convertView;
    }
}
