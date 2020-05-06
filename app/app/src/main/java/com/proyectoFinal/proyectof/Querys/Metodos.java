package com.proyectoFinal.proyectof.Querys;

import android.util.Log;

import com.proyectoFinal.proyectof.Conexiones.Get;
import com.proyectoFinal.proyectof.Conexiones.Post;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;

public class Metodos {

    public String postLogin(){
        try {
            JSONObject postDataParams = new JSONObject();
            postDataParams.put("email", "vctor_navarro@gmail.com");
            postDataParams.put("password", "123456");
            URL url = new URL("http://proyectof.tk/api/user/login");

            return Post.post(url,postDataParams);
        }
        catch(Exception e){
            return new String("Exception: " + e.getMessage());
        }
    }

    public String postRegistrar(){
        try {
            JSONObject postDataParams = new JSONObject();
            postDataParams.put("name", "Rober");
            postDataParams.put("last_name", "Wido");
            postDataParams.put("email", "roberwido@gmail.com");
            postDataParams.put("password", "scarlet123321");
            postDataParams.put("city", "Madrid");
            postDataParams.put("zipcode", "28042");
            postDataParams.put("phone", "937889669");
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
