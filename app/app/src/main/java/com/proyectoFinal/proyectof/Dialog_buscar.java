package com.proyectoFinal.proyectof;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.proyectoFinal.proyectof.Objectos.Evento;

public class Dialog_buscar extends AppCompatDialogFragment {
    private EditText input_buscar;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_dialog_buscar,null);
        builder.setView(view).setTitle("Busqueda").setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Eventos.this,"funcion no disponible",Toast.LENGTH_SHORT).show();
            }
        });
        input_buscar = (EditText) view.findViewById(R.id.edit_buscar);
        return builder.create();
    }
}
