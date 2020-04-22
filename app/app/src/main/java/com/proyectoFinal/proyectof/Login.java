package com.proyectoFinal.proyectof;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    TextView text_titulo,text_usuario,text_pass;
    EditText input_usuario,input_pass;
    Button b_inicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        text_titulo=(TextView) findViewById(R.id.titulo);
        text_usuario =(TextView) findViewById(R.id.nombre_usuario);
        input_usuario = (EditText) findViewById(R.id.input_usuario);
        text_pass=(TextView) findViewById(R.id.password_usuario);
        input_pass = (EditText) findViewById(R.id.input_password);
        b_inicio = (Button) findViewById(R.id.button_inicio);
        b_inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Login.this,"hola que tal",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
