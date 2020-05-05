package com.proyectoFinal.proyectof;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.proyectoFinal.proyectof.R;

public class Saldo extends AppCompatActivity {
    TextView text_euros, text_saldo_disponible;
    Button button_canjear_codigo;
    ImageView image_atras;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saldo);
    }

    public void onResume() {
        super.onResume();

        text_euros = (TextView) findViewById(R.id.text_euros);
        text_saldo_disponible = (TextView) findViewById(R.id.text_saldo_disponible);
        button_canjear_codigo = (Button) findViewById(R.id.button_canjear_codigo);
        image_atras = (ImageView) findViewById(R.id.image_atras);
        image_atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagPerfil = new Intent(Saldo.this,Perfil.class);
                startActivity(pagPerfil);
            }
        });
    }



}
