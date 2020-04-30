package com.proyectoFinal.proyectof.Objectos;

import java.util.Date;
import java.util.List;

public class Evento {
    String fecha_evento;
    String nombre_evento;
    double precio_evento;
    int    foto_evento;
    List<String> horario_evento;
    public Evento() {

    }

    public Evento(String fecha_evento, String nombre_evento, double precio_evento, int foto_evento,List<String> horario_evento) {
        super();
        this.fecha_evento = fecha_evento;
        this.nombre_evento = nombre_evento;
        this.precio_evento = precio_evento;
        this.foto_evento = foto_evento;
        this.horario_evento = horario_evento;
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
    public int getFoto_evento() {
        return foto_evento;
    }
    public void setFoto_evento(int foto_evento) {
        this.foto_evento = foto_evento;
    }
    public List<String> getHorario_evento() {
        return horario_evento;
    }
    public void setHorario_evento(List<String> horario_evento) {
        this.horario_evento = horario_evento;
    }
}
