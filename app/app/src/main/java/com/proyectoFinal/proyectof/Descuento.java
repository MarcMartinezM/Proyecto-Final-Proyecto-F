package com.proyectoFinal.proyectof;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Descuento extends AppCompatActivity {
    TextView text_euros, text_saldo_disponible;
    Button button_canjear_codigo;
    ImageView image_atras;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descuento);
    }

    public void onResume() {
        super.onResume();

        text_euros = (TextView) findViewById(R.id.text_descuento);
        text_saldo_disponible = (TextView) findViewById(R.id.text_descuento_disponible);
        button_canjear_codigo = (Button) findViewById(R.id.button_canjear_codigo);
        button_canjear_codigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Descuento.this,"funcion no disponible",Toast.LENGTH_SHORT).show();
            }
        });
        image_atras = (ImageView) findViewById(R.id.image_atras_saldo);
        image_atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagPerfil = new Intent(Descuento.this,Perfil.class);
                startActivity(pagPerfil);
            }
        });
    }



}
