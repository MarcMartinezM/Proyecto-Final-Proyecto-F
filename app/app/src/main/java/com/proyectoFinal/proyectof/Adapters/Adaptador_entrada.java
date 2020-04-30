package com.proyectoFinal.proyectof.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.proyectoFinal.proyectof.Objectos.Evento;
import com.proyectoFinal.proyectof.R;

import java.util.List;

public class Adaptador_entrada extends BaseAdapter {
    private Context context;
    private static  List<String> arrayHorario;

    public Adaptador_entrada(List<String> arrayHorario,Context context) {
        this.arrayHorario = arrayHorario;
        this.context = context;

    }

    @Override
    public int getCount() {
        return arrayHorario.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayHorario.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_lista_horario_entrada,null);
        TextView text_hora = convertView.findViewById(R.id.text_horario);
        TextView text_Cantidad = convertView.findViewById(R.id.text_cantidad);
        Button boton_mas = convertView.findViewById(R.id.button_añadir);
        Button boton_menos = convertView.findViewById(R.id.button_restar);

        text_hora.setText(arrayHorario.get(position));
        text_Cantidad.setText("0x");
        return convertView;
    }
}
