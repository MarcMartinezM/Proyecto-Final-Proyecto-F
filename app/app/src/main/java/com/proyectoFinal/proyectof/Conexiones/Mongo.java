package com.proyectoFinal.proyectof.Conexiones;


import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import java.net.UnknownHostException;

public class Mongo {

    public static MongoClient crearConexion() throws UnknownHostException {

        MongoClientURI uri = new MongoClientURI(
                "mongodb+srv://adrian98:1234567890@cluster0-zuhjh.mongodb.net/test?retryWrites=true&w=majority");

        MongoClient mongoClient = new MongoClient(uri);

        return mongoClient;
    }

}
