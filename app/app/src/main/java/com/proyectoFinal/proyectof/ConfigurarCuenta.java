package com.proyectoFinal.proyectof;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.proyectoFinal.proyectof.Conexiones.Post;
import com.proyectoFinal.proyectof.Querys.Metodos;

import org.json.JSONException;
import org.json.JSONObject;

public class ConfigurarCuenta extends AppCompatActivity {
    EditText input_pass,input_repetirPass,input_codigoPostal,input_telefono, input_ciudad;
    ImageView icono_atras;
    Button button_confirmar;
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
        input_repetirPass = (EditText) findViewById(R.id.input_PassNew);
        input_codigoPostal = (EditText) findViewById(R.id.input_CodigoPostalConf);
        input_telefono = (EditText) findViewById(R.id.input_TelefonoConf);
        input_ciudad = (EditText) findViewById(R.id.input_ciudadConf);
        button_confirmar = (Button) findViewById(R.id.button);
        button_confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONObject params = new JSONObject();
                    try {
                        params.put("uid",Login.usu.getIdUsuario());
                        if (input_pass.getText().toString().equals(input_repetirPass.getText().toString()) ) {
                            params.put("oldPassword", Login.usu.getContrasenya());
                            params.put("newPassword", input_pass.getText().toString());
                        } else if(input_pass.getText().toString().equals(null) || input_repetirPass.getText().toString().equals(null)){
                            params.put("oldPassword", Login.usu.getContrasenya());
                            params.put("newPassword", Login.usu.getContrasenya());
                        }
                        if(!input_ciudad.getText().toString().equals(null)){
                            Log.i("Ciudad",input_ciudad.getText().toString());
                            params.put("city", input_ciudad.getText().toString());
                        }
                        if(!input_codigoPostal.getText().toString().equals(null) && input_codigoPostal.getText().length()==5){
                            Log.i("zip",input_codigoPostal.getText().toString());
                            params.put("zipcode", input_codigoPostal.getText().toString());
                        }
                        if(!input_telefono.getText().toString().equals(null) && input_telefono.getText().length()==9  ){
                            Log.i("tel",input_telefono.getText().toString());
                            params.put("phone", input_telefono.getText().toString());
                        }

                        JSONObject job = Post.getJSONObjectFromURL("http://proyectof.tk/api/user/update", params);
                        System.out.println(job.toString());
                        String status = job.optString("status");

                        if (status.equalsIgnoreCase("OK")) {
                            Toast.makeText(ConfigurarCuenta.this,"DATOS MODIFICADOS CON EXITO",Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ConfigurarCuenta.this,"IMPOSIBLE MODIFICAR DATOS",Toast.LENGTH_SHORT).show();
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
            });
    }
}
