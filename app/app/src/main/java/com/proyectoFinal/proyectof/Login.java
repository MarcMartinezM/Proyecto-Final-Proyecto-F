package com.proyectoFinal.proyectof;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.proyectoFinal.proyectof.Conexiones.Post;

import org.json.JSONObject;

import java.io.IOException;

public class Login extends AppCompatActivity {
    TextView text_titulo,text_usuario,text_pass,click_registrarse;
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
                boolean click=true;
                if(input_usuario.getText().toString()==null || input_usuario.getText().toString().equals("")){
                    Toast.makeText(Login.this,"Introduzca un nombre de usuario",Toast.LENGTH_SHORT).show();
                }
                if(input_pass.getText().toString()==null || input_pass.getText().toString().equals("")){
                    Toast.makeText(Login.this,"Introduzca una contraseña",Toast.LENGTH_SHORT).show();
                }
                if( esCorrecto()==true){
                Toast.makeText(Login.this,"usuario correcto",Toast.LENGTH_SHORT).show();
                Intent pagEventos = new Intent(Login.this,Eventos.class);
                startActivity(pagEventos);
                }else{
                    Toast.makeText(Login.this,"usuario no correcto",Toast.LENGTH_SHORT).show();
                }
            }
        });
        click_registrarse = (TextView) findViewById(R.id.click_registrarse);
        click_registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagRegistrarse = new Intent(Login.this,Registrarse.class);
                startActivity(pagRegistrarse);
            }
        });
    }
    public Boolean esCorrecto() {

        try {
            JSONObject user = new JSONObject();
            user.put("email", input_usuario.getText().toString());
            user.put("password", input_pass.getText().toString());
            JSONObject job = Post.getJSONObjectFromURL("http://proyectof.tk/api/user/login", user);
            System.out.println(job.toString());
            String status = job.optString("status");
            if (status.equalsIgnoreCase("OK")) {
                return true;

            } else {
                return false;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
