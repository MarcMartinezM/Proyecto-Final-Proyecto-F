package com.proyectoFinal.proyectof;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ParseException;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Dialog_CompraTargeta  extends AppCompatDialogFragment {

    private EditText input_numTargeta ,input_fechaCaducacion,input_cvc;
    private dialogListener listener;
   @Override
   public Dialog onCreateDialog(Bundle savedInstanceState) {
       AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

       LayoutInflater inflater = getActivity().getLayoutInflater();
       View view = inflater.inflate(R.layout.activity_dialog_targeta,null);

       input_numTargeta = view.findViewById(R.id.input_numeroTargeta);
       input_fechaCaducacion = view.findViewById(R.id.input_caducacion);
       input_cvc = view.findViewById(R.id.input_cvc);

       builder.setView(view)
               .setTitle("DATOS TARGETA")
               .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {

                   }
               }).setPositiveButton("Comprar", null);

      final AlertDialog dialog = builder.create();
      dialog.setOnShowListener(new DialogInterface.OnShowListener() {
          @Override
          public void onShow(DialogInterface dialogInterface) {
              Button positivo = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
              positivo.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      if(input_numTargeta.getText().length()!=9 && input_cvc.getText().length()!=3 && input_fechaCaducacion.getText().length()!=8){
                          Toast.makeText(getActivity(), "no se han introducido bien los datos", Toast.LENGTH_SHORT).show();
                      }else{
                          String numeroTargeta= input_numTargeta.getText().toString();
                          String CVC =input_cvc.getText().toString();
                          String caducacion = input_fechaCaducacion.getText().toString();
                          for(int i=0;i<caducacion.length();i++){
                              char simbolo = caducacion.charAt(i);
                              if(simbolo == '/'){
                                  String [] parse = caducacion.split("/");
                                  if(isNumeric(parse[0]) && isNumeric(parse[1]) && isNumeric(numeroTargeta) && isNumeric(CVC)){
                                      int mes = Integer.parseInt(parse[0]);
                                      int año = Integer.parseInt(parse[1]);
                                      if(mes>6 && año>2020){
                                          Toast.makeText(getActivity(), "Su targeta esta Caducada", Toast.LENGTH_SHORT).show();
                                      }else{
                                          Toast.makeText(getActivity(), "GRACIAS POR SU COMPRA", Toast.LENGTH_SHORT).show();
                                          listener.applyText(Integer.parseInt(numeroTargeta),caducacion,Integer.parseInt(CVC));
                                          dismiss();
                                      }

                                  }else{
                                      Toast.makeText(getActivity(), "no has introducido bien la fecha", Toast.LENGTH_SHORT).show();
                                  }
                              }else{
                                  Toast.makeText(getActivity(), "no has introducido bien la fecha", Toast.LENGTH_SHORT).show();
                              }
                          }



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
       void  applyText (int numeroTargeta,String fecha,int CVC );
    }


    public static boolean isNumeric(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }
}
