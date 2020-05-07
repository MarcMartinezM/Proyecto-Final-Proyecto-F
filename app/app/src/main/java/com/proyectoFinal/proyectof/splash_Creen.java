package com.proyectoFinal.proyectof;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;



import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Handler;
import android.os.StrictMode;
import android.view.View;
import android.view.WindowManager;

import com.google.gson.JsonObject;
import com.proyectoFinal.proyectof.Conexiones.Post;
import com.proyectoFinal.proyectof.Querys.Metodos;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class splash_Creen extends AppCompatActivity {
    private final int DURATION= 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_creen);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent= new Intent(splash_Creen.this, Login.class);
                startActivity(intent);
                finish();
            }
        },DURATION);

        try {
            JSONObject user = new JSONObject();
            user.put("email", "roberwido@gmail.com");
            user.put("password", "scarlet123321");
            JSONObject job = Post.getJSONObjectFromURL("http://proyectof.tk/api/user/login", user);
            System.out.println(job.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}