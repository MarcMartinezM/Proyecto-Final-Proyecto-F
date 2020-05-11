package com.proyectoFinal.proyectof.Objectos;

import android.util.EventLogTags;

import java.util.Date;
import java.util.List;

public class Evento {
    String evento_id;
    String buisness_id;
    String Descripcion;
    String fecha_evento;
    String nombre_evento;
    double precio_evento;
    int    foto_evento;
    String horario_evento;
    boolean favorito_evento;
    String imagen_url;
    int status;
    String localizacion;
    int tickets_en_venta;
    int tickets_disponibles;

    public Evento() {

    }

    public Evento(String evento_id, String buisness_id, String fecha_evento, String nombre_evento, double precio_evento, int foto_evento, String horario_evento, boolean favorito_evento, String imagen_url, int status, String localizacion, int tickets_en_venta, int tickets_disponibles,String Descripcion) {
        this.evento_id = evento_id;
        this.buisness_id = buisness_id;
        this.fecha_evento = fecha_evento;
        this.nombre_evento = nombre_evento;
        this.precio_evento = precio_evento;
        this.foto_evento = foto_evento;
        this.horario_evento = horario_evento;
        this.favorito_evento = favorito_evento;
        this.imagen_url = imagen_url;
        this.status = status;
        this.localizacion = localizacion;
        this.tickets_en_venta = tickets_en_venta;
        this.tickets_disponibles = tickets_disponibles;
        this.Descripcion =Descripcion;
    }


    public String getEvento_id() {
        return evento_id;
    }

    public void setEvento_id(String evento_id) {
        this.evento_id = evento_id;
    }

    public String getBuisness_id() {
        return buisness_id;
    }

    public void setBuisness_id(String buisness_id) {
        this.buisness_id = buisness_id;
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

    public String getHorario_evento() {
        return horario_evento;
    }

    public void setHorario_evento(String horario_evento) {
        this.horario_evento = horario_evento;
    }

    public boolean isFavorito_evento() {
        return favorito_evento;
    }

    public void setFavorito_evento(boolean favorito_evento) {
        this.favorito_evento = favorito_evento;
    }

    public String getImagen_url() {
        return imagen_url;
    }

    public void setImagen_url(String imagen_url) {
        this.imagen_url = imagen_url;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public int getTickets_en_venta() {
        return tickets_en_venta;
    }

    public void setTickets_en_venta(int tickets_en_venta) {
        this.tickets_en_venta = tickets_en_venta;
    }

    public int getTickets_disponibles() {
        return tickets_disponibles;
    }

    public void setTickets_disponibles(int tickets_disponibles) {
        this.tickets_disponibles = tickets_disponibles;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
