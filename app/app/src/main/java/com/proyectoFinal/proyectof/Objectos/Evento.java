package com.proyectoFinal.proyectof.Objectos;

import java.util.Date;

public class Evento {
    String fecha_evento;
    String nombre_evento;
    double precio_evento;
    String foto_evento;

    public Evento() {

    }

    public Evento(String fecha_evento, String nombre_evento, double precio_evento, String foto_evento) {
        super();
        this.fecha_evento = fecha_evento;
        this.nombre_evento = nombre_evento;
        this.precio_evento = precio_evento;
        this.foto_evento = foto_evento;
    }
    public String getFecha_evento() {
        return fecha_evento;
    }
    public void setFecha_evento(String fecha_evento) {
        this.fecha_evento = fecha_evento;
    }
    public String getNombre_evento() {
        return nombre_evento;
    }
    public void setNombre_evento(String nombre_evento) {
        this.nombre_evento = nombre_evento;
    }
    public double getPrecio_evento() {
        return precio_evento;
    }
    public void setPrecio_evento(double precio_evento) {
        this.precio_evento = precio_evento;
    }
    public String getFoto_evento() {
        return foto_evento;
    }
    public void setFoto_evento(String foto_evento) {
        this.foto_evento = foto_evento;
    }

}
