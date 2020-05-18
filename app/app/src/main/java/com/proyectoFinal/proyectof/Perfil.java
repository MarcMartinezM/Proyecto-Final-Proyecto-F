package com.proyectoFinal.proyectof;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Perfil extends AppCompatActivity {
    Button button_cerrar, button_saldo, button_amigos, button_config_cuenta;
    ImageView icono_perfil, icono_guardados_Perfil, icono_ticket_Perfil, icono_eventos_Perfil, icono_mensajes,imagen_fotoPerfil;
    TextView textNomUser, textPerfil;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
    }

    public void onResume() {
        super.onResume();

        button_cerrar = (Button) findViewById(R.id.button_cerrar);
        button_cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagLogin = new Intent(Perfil.this, Login.class);
                startActivity(pagLogin);
            }
        });
        button_saldo = (Button) findViewById(R.id.button_saldo);
        button_saldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagSaldo = new Intent(Perfil.this, Descuento.class);
                startActivity(pagSaldo);
            }
        });
        button_amigos = (Button) findViewById(R.id.button_amigos);
        button_amigos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagAmigos = new Intent(Perfil.this, Amigos.class);
                startActivity( pagAmigos);
            }
        });
        button_config_cuenta = (Button) findViewById(R.id.button_config_cuenta);
        button_config_cuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagConf= new Intent (Perfil.this,ConfigurarCuenta.class);
                startActivity(pagConf);
            }
        });
        icono_perfil = (ImageView) findViewById(R.id.icono_perfil);
        icono_perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Perfil.this,"Y a estas en la ventana Perfil",Toast.LENGTH_SHORT).show();
            }
        });
        icono_guardados_Perfil = (ImageView) findViewById(R.id.icono_guardados_perfil);
        icono_guardados_Perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagFav = new Intent(Perfil.this, Favoritos.class);
                startActivity(pagFav);
            }
        });
        icono_ticket_Perfil = (ImageView) findViewById(R.id.icono_ticket_perfil);
        icono_ticket_Perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagTicket = new Intent(Perfil.this, Tickets.class);
                startActivity(pagTicket);
            }
        });
        icono_eventos_Perfil = (ImageView) findViewById(R.id.icono_eventos_perfil);
        icono_eventos_Perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagEventos = new Intent(Perfil.this, Eventos.class);
                startActivity(pagEventos);
            }
        });
        icono_mensajes = (ImageView) findViewById(R.id.icono_mensajes);
        icono_mensajes.setVisibility(View.INVISIBLE);
        textNomUser = (TextView) findViewById(R.id.textNomUser);
        textNomUser.setText(Login.arrayUsuario.get(0).getNombre_real());
        textPerfil = (TextView) findViewById(R.id.textPerfil);
        imagen_fotoPerfil = (ImageView) findViewById(R.id.imagePerfil);
        if(!Login.arrayUsuario.get(0).getRuta_foto_perfil().equalsIgnoreCase("default")){
            Picasso.get().load(Login.arrayUsuario.get(0).getRuta_foto_perfil()).into(imagen_fotoPerfil);
        }else{
            imagen_fotoPerfil.setBackgroundResource(Login.arrayUsuario.get(0).getFotoPerfil());
        }
    }

}
