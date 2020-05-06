package com.proyectoFinal.proyectof.Querys;

import android.util.Log;

import com.proyectoFinal.proyectof.Conexiones.Get;
import com.proyectoFinal.proyectof.Conexiones.Post;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;

public class Metodos {

    public String postLogin(JSONObject postDataParams){
        try {
            URL url = new URL("http://proyectof.tk/api/user/login");
            return Post.post(url,postDataParams);
        }
        catch(Exception e){
            return new String("Exception: " + e.getMessage());
        }
    }

    public String postRegistrar(JSONObject postDataParams){
        try {
            URL url = new URL("http://proyectof.tk/api/user/create");
            return Post.post(url,postDataParams);
        }
        catch(Exception e){
            return new String("Exception: " + e.getMessage());
        }
    }

    public String getEventos() throws MalformedURLException {
        URL url = new URL("http://proyectof.tk/api/events");
        try {
            Log.i("USRS",Get.metodoGet(url));
          return Get.metodoGet(url);
        }
        catch(Exception e){
            return new String("Exception: " + e.getMessage());
        }
    }

}
