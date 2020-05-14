package com.proyectoFinal.proyectof;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dialog_añadirAmigo extends AppCompatDialogFragment {
    private EditText input_correoAmigo;
    private dialogListener listener;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_dialog_anadir_amigo,null);

        input_correoAmigo = view.findViewById(R.id.input_amigo_añadir);

        builder.setView(view)
                .setTitle("AÑADIR AMIGO")
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setPositiveButton("Añadir", null);
        final AlertDialog dialog = builder.create();
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                Button positivo = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
                positivo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Pattern pattern = Pattern
                                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

                        String email = input_correoAmigo.getText().toString();
                        Matcher mather = pattern.matcher(email);
                        if (mather.find() == true) {
                            listener.applyText(email);
                            dismiss();
                        }else{
                            Toast.makeText(getActivity(),"EL FORMATO DEL CORREO ES INCORRECTO",Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });
        return  dialog;
    }
    @Override
    public void onAttach( Context context) {
        super.onAttach(context);
        try {
            listener =(dialogListener) context;
        }catch (ClassCastException e){
            throw  new ClassCastException(context.toString()+"must inplement");
        }

    }

    public interface  dialogListener{
        void  applyText (String correo );
    }
}
