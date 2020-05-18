package com.proyectoFinal.proyectof;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.proyectoFinal.proyectof.Conexiones.Post;

import org.json.JSONObject;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registrarse extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    EditText input_nombreReal,input_apellido,input_pass,input_repetirPass,input_correo,input_codigoPostal,input_telefono,input_ciudad;
    Button b_registrarse;
    ImageView imagen_atras;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
    }
    public void onResume() {
        super.onResume();
       input_nombreReal = (EditText) findViewById(R.id.registrarse_input_nombre_real);
       input_apellido = (EditText) findViewById(R.id.registrarse_input_apellido);
       input_pass = (EditText) findViewById(R.id.registrarse_input_pass);
       input_repetirPass = (EditText) findViewById(R.id.registrarse_input_pass_repetir);
       input_correo = (EditText) findViewById(R.id.registrarse_input_correo);
       input_codigoPostal = (EditText) findViewById(R.id.registrarse_input_codigopostal);
       input_telefono = (EditText) findViewById(R.id.registrarse_input_telefono);
        input_ciudad = (EditText) findViewById(R.id.registrarse_ciudad);
       b_registrarse = (Button) findViewById(R.id.button_registrarse);
       imagen_atras = (ImageView) findViewById(R.id.icono_atras);
       imagen_atras.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent pagLogin = new Intent(Registrarse.this,Login.class);
               startActivity(pagLogin);
           }
       });
       b_registrarse.setOnClickListener(new View.OnClickListener() {
           @Override
           //COMPROVACIONES DE LOS DATOS PARA REGISTRARSE
           public void onClick(View v) {
               boolean crear = true;
               //SI ALGO ESTA VACIO MENSAJE TOAST
               if((input_nombreReal.getText().toString()== null || input_nombreReal.getText().toString().equals("")) && (input_apellido.getText().toString()== null || input_apellido.getText().toString().equals("")) ||
                       (input_pass.getText().toString()== null || input_pass.getText().toString().equals("")) ||
                       (input_repetirPass.getText().toString()== null || input_repetirPass.getText().toString().equals("")) && (input_correo.getText().toString()== null || input_correo.getText().toString().equals("")) ||
                       (input_codigoPostal.getText().toString()== null || input_codigoPostal.getText().toString().equals(""))&& (input_telefono.getText().toString()== null || input_telefono.getText().toString().equals(""))){
                   crear = false;
                   Toast.makeText(Registrarse.this,"TODOS LOS DATOS TIENES QUE ESTAR RELLENADOS.",Toast.LENGTH_SHORT).show();
               }else{
                   //COMPROVACION CAMPOS PASS

                   if(!input_pass.getText().toString().contentEquals(input_repetirPass.getText().toString())) {
                       crear = false;
                       Toast.makeText(Registrarse.this,"LOS CAMPOS DE CONTRASEÑA NO COINCIDEN",Toast.LENGTH_SHORT).show();
                   }
                   Pattern pattern = Pattern
                           .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                                   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

                   // El email a validar
                   String email = input_correo.getText().toString();

                   Matcher mather = pattern.matcher(email);

                   if (!mather.find() == true) {
                       crear = false;
                       Toast.makeText(Registrarse.this,"EL FORMATO DEL CORREO ES INCORRECTO",Toast.LENGTH_SHORT).show();
                   }

                   //COMPROVACION CAMPO COD POSTAL
                   if(input_codigoPostal.length() != 5){
                       crear = false;
                       Toast.makeText(Registrarse.this,"CODIGO POSTAL INCORRECTO(NO TIENE 5 VALORES)",Toast.LENGTH_SHORT).show();
                   }
                   //COMPROVACION CAMPO NUM TLF
                   if(input_telefono.length() != 9){
                       crear = false;
                       Toast.makeText(Registrarse.this,"NUM TLF INCORRECTO(NO TIENE 9 VALORES)",Toast.LENGTH_SHORT).show();
                   }
               }

               if(crear == true){
                   if(esCorrecto() == true){
                       Toast.makeText(Registrarse.this,"USUARIO REGISTRADO",Toast.LENGTH_SHORT).show();
                        input_nombreReal.setText("");
                        input_apellido.setText("");
                        input_correo.setText("");
                        input_pass.setText("");
                        input_ciudad.setText("");
                        input_codigoPostal.setText("");
                        input_telefono.setText("");
                        input_repetirPass.setText("");
                   } else{
                       Toast.makeText(Registrarse.this,"USUARIO INVALIDO",Toast.LENGTH_SHORT).show();
                   }
               }
           }
       });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String ciudad_Seleccionada = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),ciudad_Seleccionada,Toast.LENGTH_LONG).show();
  }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public Boolean esCorrecto() {
        try {
            JSONObject user = new JSONObject();
            user.put("name", input_nombreReal.getText().toString());
            user.put("last_name", input_apellido.getText().toString());
            user.put("email", input_correo.getText().toString());
            user.put("password", input_pass.getText().toString());
            user.put("city", input_ciudad.getText().toString());
            user.put("zipcode", input_codigoPostal.getText().toString());
            user.put("phone", input_telefono.getText().toString());

            JSONObject job = Post.getJSONObjectFromURL("https://proyectof.tk/api/user/create", user);
            System.out.println(job.toString());

            String status = job.optString("status");

            if (status.equalsIgnoreCase("OK")) {
                return true;
            } else {
                status = job.optString("msg");
                Toast.makeText(Registrarse.this,status,Toast.LENGTH_SHORT).show();
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

