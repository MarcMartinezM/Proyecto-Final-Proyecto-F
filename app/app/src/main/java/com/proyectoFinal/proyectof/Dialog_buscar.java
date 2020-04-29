package com.proyectoFinal.proyectof;
/*
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatDialogFragment;

import static com.proyectoFinal.proyectof.Eventos.arrayEventos;


public class Dialog_buscar extends AppCompatDialogFragment {
    private EditText input_buscar;
    private dialog_buscar_Listener listener;
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
                String nombreBuscar = input_buscar.getText().toString();
                boolean existe=false;
                for(int i=0;i< arrayEventos.size();i++){
                    if(nombreBuscar.equalsIgnoreCase(arrayEventos.get(i).getNombre_evento())){
                        existe=true;
                    }
                }
                listener.applyTexts(nombreBuscar,existe);
            }
        });
        input_buscar = (EditText) view.findViewById(R.id.edit_buscar);
        return builder.create();
    }

    @Override
    public void onAttach( Context context) {
        super.onAttach(context);
        try {
            listener = (dialog_buscar_Listener) context;
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public interface  dialog_buscar_Listener{
        void applyTexts(String nombreBuscar,boolean existe);
    }
}
*/