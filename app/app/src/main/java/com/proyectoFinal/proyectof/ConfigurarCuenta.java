package com.proyectoFinal.proyectof;

import android.content.Intent;
import android.os.Bundle;
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
    EditText input_pass,input_repetirPass,input_codigoPostal,input_telefono;
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
        input_codigoPostal.setText(Login.arrayUsuario.get(0).getCod_postal());

        input_telefono = (EditText) findViewById(R.id.input_TelefonoConf);
        input_telefono.setText(Login.arrayUsuario.get(0).getNum_tlf());
        button_confirmar = (Button) findViewById(R.id.button);
        button_confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONObject params = new JSONObject();
                    try {
                        params.put("uid",Login.usu.getIdUsuario());
                        if (input_pass.getText().equals(input_repetirPass.getText())) {
                            params.put("oldPassword", Login.usu.getContrasenya());
                            params.put("newPassword", input_pass.getText());
                        } else if(!input_codigoPostal.getText().equals(null)){
                            params.put("zipcode", input_codigoPostal.getText());
                        } else if(!input_telefono.getText().equals(null)){
                            params.put("phone", input_telefono.getText());
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
