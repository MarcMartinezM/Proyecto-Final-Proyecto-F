package com.proyectoFinal.proyectof.Objectos;

public class Favorito {
    String evento_id_fav;
    String buisness_id_fav;
    String Descripcion_fav;
    String fecha_evento_fav;
    String nombre_evento_fav;
    double precio_evento_fav;
    int    foto_evento_fav;
    String horario_evento_fav;
    boolean favorito_evento_fav;
    String imagen_url_fav;
    int status_fav;
    String localizacion_fav;
    int tickets_en_venta_fav;
    int tickets_disponibles_fav;

    public Favorito() {
    }

    public Favorito(String evento_id_fav, String descripcion_fav, String fecha_evento_fav, String nombre_evento_fav, double precio_evento_fav, int foto_evento_fav, String horario_evento_fav, String imagen_url_fav, int status_fav, String localizacion_fav) {
        this.evento_id_fav = evento_id_fav;
        this.Descripcion_fav = descripcion_fav;
        this.fecha_evento_fav = fecha_evento_fav;
        this.nombre_evento_fav = nombre_evento_fav;
        this.precio_evento_fav = precio_evento_fav;
        this.foto_evento_fav = foto_evento_fav;
        this.horario_evento_fav = horario_evento_fav;
        this.imagen_url_fav = imagen_url_fav;
        this.status_fav = status_fav;
        this.localizacion_fav = localizacion_fav;
    }

    public String getEvento_id_fav() {
        return evento_id_fav;
    }

    public void setEvento_id_fav(String evento_id_fav) {
        this.evento_id_fav = evento_id_fav;
    }

    public String getBuisness_id_fav() {
        return buisness_id_fav;
    }

    public void setBuisness_id_fav(String buisness_id_fav) {
        this.buisness_id_fav = buisness_id_fav;
    }

    public String getDescripcion_fav() {
        return Descripcion_fav;
    }

    public void setDescripcion_fav(String descripcion_fav) {
        Descripcion_fav = descripcion_fav;
    }

    public String getFecha_evento_fav() {
        return fecha_evento_fav;
    }

    public void setFecha_evento_fav(String fecha_evento_fav) {
        this.fecha_evento_fav = fecha_evento_fav;
    }

    public String getNombre_evento_fav() {
        return nombre_evento_fav;
    }

    public void setNombre_evento_fav(String nombre_evento_fav) {
        this.nombre_evento_fav = nombre_evento_fav;
    }

    public double getPrecio_evento_fav() {
        return precio_evento_fav;
    }

    public void setPrecio_evento_fav(double precio_evento_fav) {
        this.precio_evento_fav = precio_evento_fav;
    }

    public int getFoto_evento_fav() {
        return foto_evento_fav;
    }

    public void setFoto_evento_fav(int foto_evento_fav) {
        this.foto_evento_fav = foto_evento_fav;
    }

    public String getHorario_evento_fav() {
        return horario_evento_fav;
    }

    public void setHorario_evento_fav(String horario_evento_fav) {
        this.horario_evento_fav = horario_evento_fav;
    }

    public boolean isFavorito_evento_fav() {
        return favorito_evento_fav;
    }

    public void setFavorito_evento_fav(boolean favorito_evento_fav) {
        this.favorito_evento_fav = favorito_evento_fav;
    }

    public String getImagen_url_fav() {
        return imagen_url_fav;
    }

    public void setImagen_url_fav(String imagen_url_fav) {
        this.imagen_url_fav = imagen_url_fav;
    }

    public int getStatus_fav() {
        return status_fav;
    }

    public void setStatus_fav(int status_fav) {
        this.status_fav = status_fav;
    }

    public String getLocalizacion_fav() {
        return localizacion_fav;
    }

    public void setLocalizacion_fav(String localizacion_fav) {
        this.localizacion_fav = localizacion_fav;
    }

    public int getTickets_en_venta_fav() {
        return tickets_en_venta_fav;
    }

    public void setTickets_en_venta_fav(int tickets_en_venta_fav) {
        this.tickets_en_venta_fav = tickets_en_venta_fav;
    }

    public int getTickets_disponibles_fav() {
        return tickets_disponibles_fav;
    }

    public void setTickets_disponibles_fav(int tickets_disponibles_fav) {
        this.tickets_disponibles_fav = tickets_disponibles_fav;
    }

    @Override
    public String toString() {
        return "Favorito{" +
                "evento_id_fav='" + evento_id_fav + '\'' +
                ", buisness_id_fav='" + buisness_id_fav + '\'' +
                ", Descripcion_fav='" + Descripcion_fav + '\'' +
                ", fecha_evento_fav='" + fecha_evento_fav + '\'' +
                ", nombre_evento_fav='" + nombre_evento_fav + '\'' +
                ", precio_evento_fav=" + precio_evento_fav +
                ", foto_evento_fav=" + foto_evento_fav +
                ", horario_evento_fav='" + horario_evento_fav + '\'' +
                ", favorito_evento_fav=" + favorito_evento_fav +
                ", imagen_url_fav='" + imagen_url_fav + '\'' +
                ", status_fav=" + status_fav +
                ", localizacion_fav='" + localizacion_fav + '\'' +
                ", tickets_en_venta_fav=" + tickets_en_venta_fav +
                ", tickets_disponibles_fav=" + tickets_disponibles_fav +
                '}';
    }
}
