package com.proyectoFinal.proyectof;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.proyectoFinal.proyectof.Conexiones.Post;

import org.json.JSONObject;

import java.io.IOException;

public class Amigos extends AppCompatActivity implements Dialog_añadirAmigo.dialogListener{
    ImageView img_atras;
    EditText buscar_amigo;
    ListView lista_amigos;
    Button boton_añadir_amigos;
    ArrayAdapter<String> adapter;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amigos);
    }

    @Override
    protected void onResume() {
        super.onResume();
        img_atras = (ImageView) findViewById(R.id.image_atras_amigos);
        img_atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagPerfil = new Intent(Amigos.this, Perfil.class);
                startActivity(pagPerfil);
            }
        });
        lista_amigos = (ListView) findViewById(R.id.lista_amigos);
        adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Login.amigos);
        lista_amigos.setAdapter(adapter);
        buscar_amigo = (EditText) findViewById(R.id.input_buscar_amigos);
        buscar_amigo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        boton_añadir_amigos = (Button) findViewById(R.id.button_añadir_amigo);
        boton_añadir_amigos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogAmigos();
            }
        });
    }
    public void openDialogAmigos(){
        Dialog_añadirAmigo dialog_añadir = new Dialog_añadirAmigo();
        dialog_añadir.show(getSupportFragmentManager(),"dialog añadir amigo");
    }

    @Override
    public void applyText(String correo) {
        boolean yaExiste=false;
        if(Login.arrayUsuario.get(0).getCorreo().equalsIgnoreCase(correo)){
            Toast.makeText(Amigos.this,"No te puedes añadir ati mismo",Toast.LENGTH_SHORT).show();
        }else{
            for(int i=0;i< Login.amigos.size();i++){
                if(Login.amigos.get(i).equalsIgnoreCase(correo)){
                    yaExiste=true;
                }
            }
            if(yaExiste==true){
                Toast.makeText(Amigos.this,"Ya tienes a "+correo+" como amigo",Toast.LENGTH_SHORT).show();
            }else{
                try {
                    JSONObject email = new JSONObject();
                    email.put("uid",Login.arrayUsuario.get(0).getIdUsuario());
                    email.put("email",correo);
                    JSONObject job = Post.getJSONObjectFromURL("http://proyectof.tk/api/user/add", email);
                    System.out.println(job.toString());
                    String status = job.optString("status");
                    if (status.equalsIgnoreCase("OK")) {
                        Toast.makeText(Amigos.this,"NUEVO AMIGO AÑADIDO",Toast.LENGTH_SHORT).show();

                        Login.amigos.add(correo);
                        adapter.notifyDataSetChanged();
                    }else{

                        status = job.optString("msg");
                        Toast.makeText(Amigos.this,status,Toast.LENGTH_SHORT).show();
                    }
                }catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }



    }
}
