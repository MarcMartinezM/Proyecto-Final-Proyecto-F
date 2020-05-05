package com.proyectoFinal.proyectof.Objectos;

public class Favorito {
    String fecha_evento_fav;
    String nombre_evento_fav;
    double precio_evento_fav;
    int    foto_evento_fav;
    String horario_evento_fav;
    boolean favorito_evento_fav;

    public Favorito() {
    }

    public Favorito(String fecha_evento_fav, String nombre_evento_fav, double precio_evento_fav, int foto_evento_fav, String horario_evento_fav, boolean favorito_evento_fav) {
        this.fecha_evento_fav = fecha_evento_fav;
        this.nombre_evento_fav = nombre_evento_fav;
        this.precio_evento_fav = precio_evento_fav;
        this.foto_evento_fav = foto_evento_fav;
        this.horario_evento_fav = horario_evento_fav;
        this.favorito_evento_fav = favorito_evento_fav;
    }

    public String getFecha_evento_fav() {
        return fecha_evento_fav;
    }

    public String getNombre_evento_fav() {
        return nombre_evento_fav;
    }

    public double getPrecio_evento_fav() {
        return precio_evento_fav;
    }

    public int getFoto_evento_fav() {
        return foto_evento_fav;
    }

    public String getHorario_evento_fav() {
        return horario_evento_fav;
    }

    public boolean getFavorito_evento_fav() {
        return favorito_evento_fav;
    }

    public void setFecha_evento_fav(String fecha_evento_fav) {
        this.fecha_evento_fav = fecha_evento_fav;
    }

    public void setNombre_evento_fav(String nombre_evento_fav) {
        this.nombre_evento_fav = nombre_evento_fav;
    }

    public void setPrecio_evento_fav(double precio_evento_fav) {
        this.precio_evento_fav = precio_evento_fav;
    }

    public void setFoto_evento_fav(int foto_evento_fav) {
        this.foto_evento_fav = foto_evento_fav;
    }

    public void setHorario_evento_fav(String horario_evento_fav) {
        this.horario_evento_fav = horario_evento_fav;
    }

    public void setFavorito_evento_fav(boolean favorito_evento_fav) {
        this.favorito_evento_fav = favorito_evento_fav;
    }

    @Override
    public String toString() {
        return "Favorito{" +
                "fecha_evento_fav='" + fecha_evento_fav + '\'' +
                ", nombre_evento_fav='" + nombre_evento_fav + '\'' +
                ", precio_evento_fav=" + precio_evento_fav +
                ", foto_evento_fav=" + foto_evento_fav +
                ", horario_evento_fav='" + horario_evento_fav + '\'' +
                ", favorito_evento_fav=" + favorito_evento_fav +
                '}';
    }
}
