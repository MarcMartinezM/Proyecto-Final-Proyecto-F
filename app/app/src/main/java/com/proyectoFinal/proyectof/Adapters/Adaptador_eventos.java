package com.proyectoFinal.proyectof.Adapters;


import android.content.Context;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.proyectoFinal.proyectof.Eventos;
import com.proyectoFinal.proyectof.Objectos.Evento;
import com.proyectoFinal.proyectof.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Adaptador_eventos extends  ArrayAdapter<Evento> implements Filterable {
    private Context context;
    private static List<Evento> arrayEventos;
   private static List<Evento> origArrayEventos;
    private Filter EventosFilter;

    public Adaptador_eventos(List<Evento> arrayEventos,Context context){
        super(context, R.layout.item_lista_eventos,arrayEventos);
        this.context = context;
        this.arrayEventos = arrayEventos;
        this.origArrayEventos = arrayEventos;
    }

    @Override
    public int getCount() {
        return arrayEventos.size();
    }

    @Override
    public Evento getItem(int position) {

            return arrayEventos.get(position);

    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Evento eve = (Evento) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.item_lista_eventos,null);
        TextView text_fecha = convertView.findViewById(R.id.text_fecha);
        TextView text_nombre_evento = convertView.findViewById(R.id.text_nombre_evento);
        TextView text_preco = convertView.findViewById(R.id.text_precio);
        ImageView imagen_evento = convertView.findViewById(R.id.imageView);

        text_fecha.setText(eve.getFecha_evento());
        text_nombre_evento.setText(eve.getNombre_evento());
        text_preco.setText(eve.getPrecio_evento()+" €");
        if(!eve.getRuta_evento().equalsIgnoreCase("default")){
               Picasso.get().load(eve.getRuta_evento()).resize(300, 95).into(imagen_evento);
        }
        else{
            imagen_evento.setImageResource(eve.getFoto_evento());
        }


        return convertView;
    }
    public void setData( List<Evento> arrayeventos){
        this.arrayEventos = arrayeventos;
        notifyDataSetChanged();
    }
public Filter getFilter() {
        if(EventosFilter == null){
            EventosFilter = new EventosFilter();
        }
        return EventosFilter;
}
    public void resetData() {
        arrayEventos =  origArrayEventos;
    }
private class EventosFilter extends Filter{


    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        if(constraint== null || constraint.length()==0){
            results.values = arrayEventos;
            results.count = arrayEventos.size();
        }else{
            List<Evento> nEventoList = new ArrayList<Evento>();
            for(Evento e : arrayEventos){
                if(e.getNombre_evento().toUpperCase().startsWith(constraint.toString().toUpperCase()));
                nEventoList.add(e);
            }
            results.values = nEventoList;
            results.count = nEventoList.size();
        }
        return results;
    }


    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        if (results.count == 0){
            notifyDataSetInvalidated();
        }else{
            Eventos.arrayEventos = (List<Evento>) results.values;
            notifyDataSetChanged();
        }
    }
}
}


