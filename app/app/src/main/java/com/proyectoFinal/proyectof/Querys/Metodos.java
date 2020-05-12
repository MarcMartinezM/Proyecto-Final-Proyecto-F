package com.proyectoFinal.proyectof.Querys;

import android.util.Log;

import com.proyectoFinal.proyectof.Conexiones.Get;
import com.proyectoFinal.proyectof.Conexiones.Post;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;

public class Metodos {

    public static String postLogin(JSONObject postDataParams){
        try {
            URL url = new URL("http://proyectof.tk/api/user/login");
            return Post.post(url,postDataParams);
        }
        catch(Exception e){
            return new String("Exception: " + e.getMessage());
        }
    }

    public static String postRegistrar(JSONObject postDataParams){
        try {
            URL url = new URL("http://proyectof.tk/api/user/create");
            return Post.post(url,postDataParams);
        }
        catch(Exception e){
            return new String("Exception: " + e.getMessage());
        }
    }

    public static String getEventos() throws MalformedURLException {
        URL url = new URL("http://proyectof.tk/api/events");
        try {
            Log.i("USRS",Get.metodoGet(url));
          return Get.metodoGet(url);
        }
        catch(Exception e){
            return new String("Exception: " + e.getMessage());
        }
    }

    public static String postConfigCuenta(JSONObject postDataParams){
        try {
            URL url = new URL("http://proyectof.tk/api/user/update");
            return Post.post(url,postDataParams);
        }
        catch(Exception e){
            return new String("Exception: " + e.getMessage());
        }
    }

    public static String postComprarTickets(JSONObject postDataParams){
        try {
            URL url = new URL("http://proyectof.tk/api/tickets/buy");
            return Post.post(url,postDataParams);
        }
        catch(Exception e){
            return new String("Exception: " + e.getMessage());
        }
    }

}
