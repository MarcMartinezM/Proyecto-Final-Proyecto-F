package com.proyectoFinal.proyectof;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatDialogFragment;

import net.glxn.qrgen.android.QRCode;

public class Dialog_infoTicket extends AppCompatDialogFragment {
    private TextView codigo_ticket;
    private ImageView imagen_QR;



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_dialog_ticket,null);
        builder.setView(view)
                .setTitle("QR TICKET")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        codigo_ticket  = view.findViewById(R.id.Texto_codigo);
        codigo_ticket.setText(Tickets.codigo);
        imagen_QR = view.findViewById(R.id.img_QR);
        String textoQR = "ACEPTADA LA CONFIRMACION DE ENTRADA/S CODIGO: "+codigo_ticket.getText().toString();
        Bitmap bitmap = QRCode.from(textoQR).bitmap();
        imagen_QR.setImageBitmap(bitmap);
        return builder.create();
    }
}
