package com.proyectoFinal.proyectof;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Registrarse extends AppCompatActivity {

    //TextView text_titulo,text_nombreReal,text_nombreUsuario,text_apellido,text_pass,text_repetirPass,text_correo,text_ciudad,text_codigoPostal,text_telefono;
    EditText input_nombreReal,input_nombreUsuario,input_apellido,input_pass,input_repetirPass,input_correo,input_codigoPostal,input_telefono;
    Spinner spinner_ciudad;
    Button b_registrarse;
    ImageView imagen_atras;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
    }
    public void onResume() {
        super.onResume();
       /*
        text_titulo = (TextView) findViewById(R.id.titulo_registrarse);
        text_nombreReal = (TextView) findViewById(R.id.registrar_nombre_real);
        text_nombreUsuario = (TextView) findViewById(R.id.registrar_nombre_usuario);
        text_apellido = (TextView) findViewById(R.id.registrar_apellido);
        text_pass = (TextView) findViewById(R.id.registrar_pass);
        text_repetirPass = (TextView) findViewById(R.id.registrar_pass_repetir);
*/
       input_nombreReal = (EditText) findViewById(R.id.registrarse_input_nombre_real);
       input_apellido = (EditText) findViewById(R.id.registrarse_input_apellido);
       input_nombreUsuario = (EditText) findViewById(R.id.registrarse_input_nombre_user);
       input_pass = (EditText) findViewById(R.id.registrarse_input_pass);
       input_repetirPass = (EditText) findViewById(R.id.registrarse_input_pass_repetir);
       input_correo = (EditText) findViewById(R.id.registrarse_input_correo);
       input_codigoPostal = (EditText) findViewById(R.id.registrarse_input_codigopostal);
       input_telefono = (EditText) findViewById(R.id.registrarse_input_telefono);
       spinner_ciudad = (Spinner) findViewById(R.id.registrarse_spinner);
       b_registrarse = (Button) findViewById(R.id.button_registrarse);
       imagen_atras = (ImageView) findViewById(R.id.icono_atras);
       b_registrarse.setOnClickListener(new View.OnClickListener() {
           @Override
           //COMPROVACIONES DE LOS DATOS PARA REGISTRARSE
           public void onClick(View v) {
               //SI ALGO ESTA VACIO MENSAJE TOAST
               if((input_nombreReal.getText().toString()== null || input_nombreReal.getText().toString().equals("")) && (input_apellido.getText().toString()== null || input_apellido.getText().toString().equals("")) &&
                       (input_nombreUsuario.getText().toString()== null || input_nombreUsuario.getText().toString().equals("")) && (input_pass.getText().toString()== null || input_pass.getText().toString().equals(""))&&
                       (input_repetirPass.getText().toString()== null || input_repetirPass.getText().toString().equals("")) && (input_correo.getText().toString()== null || input_correo.getText().toString().equals("")) &&
                       (input_codigoPostal.getText().toString()== null || input_codigoPostal.getText().toString().equals(""))&& (input_telefono.getText().toString()== null || input_telefono.getText().toString().equals(""))){
                   Toast.makeText(Registrarse.this,"TODOS LOS DATOS TIENES QUE ESTAR RELLENADOS.",Toast.LENGTH_SHORT).show();
               }else{
                   //COMPRO NOMBRE USER
                   if(input_nombreUsuario.getTextSize()<=4){
                       Toast.makeText(Registrarse.this,"EL NOMBRE DE USUARIO DEBE TENER MAS DE 4 CARACTERES",Toast.LENGTH_SHORT).show();
                   }
               }
           }
       });
    }

}

