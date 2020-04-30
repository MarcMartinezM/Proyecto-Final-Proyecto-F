package com.proyectoFinal.proyectof.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;

import com.proyectoFinal.proyectof.Objectos.Evento;

import java.util.List;

public class Adaptador_entrada extends BaseAdapter {
    private Context context;
    private static String[] arrayHorario;

    public Adaptador_entrada(String[] arrayHorario,Context context) {
        this.arrayHorario = arrayHorario;
        this.context = context;

    }

    @Override
    public int getCount() {
        return arrayHorario.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
