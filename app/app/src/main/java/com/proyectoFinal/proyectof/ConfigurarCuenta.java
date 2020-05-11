package com.proyectoFinal.proyectof;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ConfigurarCuenta extends AppCompatActivity {
    EditText input_pass,input_repetirPass,input_correo,input_codigoPostal,input_telefono;
    ImageView icono_atras;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar_cuenta);
    }

    public void onResume() {
        super.onResume();
        icono_atras = (ImageView) findViewById(R.id.icono_atras);
        icono_atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagPerfil = new Intent(ConfigurarCuenta.this, Perfil.class);
                startActivity(pagPerfil);
            }
        });

        input_pass = (EditText) findViewById(R.id.input_PassAntig);
        input_pass.setText(Login.arrayUsuario.get(0).getContrasenya());
        input_repetirPass = (EditText) findViewById(R.id.input_PassNew);

        input_correo =(EditText) findViewById(R.id.input_CorreConf);
        input_correo.setText(Login.arrayUsuario.get(0).getCorreo());

        input_codigoPostal = (EditText) findViewById(R.id.input_CodigoPostalConf);
        input_codigoPostal.setText(Login.arrayUsuario.get(0).getCod_postal());

        input_telefono = (EditText) findViewById(R.id.input_TelefonoConf);
        input_telefono.setText(Login.arrayUsuario.get(0).getNum_tlf());

    }
}
