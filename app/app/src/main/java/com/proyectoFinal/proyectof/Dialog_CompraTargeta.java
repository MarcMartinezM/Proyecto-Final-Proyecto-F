package com.proyectoFinal.proyectof;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ParseException;
import android.os.Bundle;
import android.util.Log;
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
                      Log.i("tamaño ","targeta: "+input_numTargeta.getText().length()+" cvc: "+input_cvc.getText().length()+" FECHA: "+input_fechaCaducacion.getText().length());
                      if(input_numTargeta.getText().length()!=16 && input_cvc.getText().length()!=3 && input_fechaCaducacion.getText().length()!=7){
                          Toast.makeText(getActivity(), "no se han introducido bien los datos", Toast.LENGTH_SHORT).show();
                      }else{
                          String numeroTargeta= input_numTargeta.getText().toString();
                          String CVC =input_cvc.getText().toString();
                          String caducacion = input_fechaCaducacion.getText().toString();
                              char simbolo = caducacion.charAt(2);
                              if(simbolo == '/'){
                                  String [] parse = caducacion.split("/");
                                  if(isNumeric(parse[0]) && isNumeric(parse[1]) && isNumericLong(numeroTargeta) && isNumeric(CVC)){
                                      int mes = Integer.parseInt(parse[0]);
                                      int año = Integer.parseInt(parse[1]);
                                      if(mes>6 && año>2020){
                                          Toast.makeText(getActivity(), "Su targeta esta Caducada", Toast.LENGTH_SHORT).show();
                                      }else{
                                          Toast.makeText(getActivity(), "GRACIAS POR SU COMPRA", Toast.LENGTH_SHORT).show();
                                          listener.applyText(Long.parseLong(numeroTargeta),caducacion,Integer.parseInt(CVC));
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
       void  applyText (Long numeroTargeta,String fecha,int CVC );
    }


    public static boolean isNumeric(String cadena){
        try {
            Integer.parseInt(cadena);
            Log.i("si es numero: ",""+cadena);
            return true;
        } catch (NumberFormatException nfe){
            Log.i("no es numero: ",""+cadena);
            return false;
        }
    }
    public static boolean isNumericLong(String cadena){
        try {
            Long.parseLong(cadena);
            Log.i("si es numero: ",""+cadena);
            return true;
        } catch (NumberFormatException nfe){
            Log.i("no es numero: ",""+cadena);
            return false;
        }
    }
}
