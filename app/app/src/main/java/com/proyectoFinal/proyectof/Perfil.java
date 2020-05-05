package com.proyectoFinal.proyectof;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Perfil extends AppCompatActivity {
    Button button_cerrar, button_saldo, button_compartir, button_config_cuenta;
    ImageView icono_perfil_ticket2, icono_guardados_ticket2, icono_ticket_ticket2, icono_eventos_ticket2, icono_mensajes, icono_guardados2;
    TextView textNomUser, textPerfil;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
    }

    public void onResume() {
        super.onResume();

        button_cerrar = (Button) findViewById(R.id.button_cerrar);
        button_saldo = (Button) findViewById(R.id.button_saldo);
        button_saldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagSaldo = new Intent(Perfil.this,Saldo.class);
                startActivity(pagSaldo);
            }
        });
        button_compartir = (Button) findViewById(R.id.button_compartir);
        button_config_cuenta = (Button) findViewById(R.id.button_config_cuenta);
        icono_perfil_ticket2 = (ImageView) findViewById(R.id.icono_perfil_ticket2);
        icono_guardados_ticket2 = (ImageView) findViewById(R.id.icono_guardados_ticket2);
        icono_ticket_ticket2 = (ImageView) findViewById(R.id.icono_ticket_ticket2);
        icono_eventos_ticket2 = (ImageView) findViewById(R.id.icono_eventos_ticket2);
        icono_mensajes = (ImageView) findViewById(R.id.icono_mensajes);
        icono_guardados2 = (ImageView) findViewById(R.id.icono_guardados2);
        textNomUser = (TextView) findViewById(R.id.textNomUser);
        textPerfil = (TextView) findViewById(R.id.textPerfil);
    }

}
