package com.proyectoFinal.proyectof.Objectos;

import java.util.ArrayList;

public class Usuario {
    int fotoPerfil;
    ArrayList<String> amigos;
    String idUsuario;
    ArrayList<String> tickets;
    String nombre_real;
    String apellido;
    String contrasenya;
    String correo;
    String ciudad;
    String cod_postal;
    String  num_tlf;

    public Usuario(){

    }

    public Usuario(int fotoPerfil, ArrayList<String> amigos, String idUsuario, ArrayList<String> tickets, String nombre_real, String apellido, String contrasenya, String correo, String ciudad, String cod_postal, String  num_tlf) {
        this.fotoPerfil = fotoPerfil;
        this.amigos = amigos;
        this.idUsuario = idUsuario;
        this.tickets = tickets;
        this.nombre_real = nombre_real;
        this.apellido = apellido;
        this.contrasenya = contrasenya;
        this.correo = correo;
        this.ciudad = ciudad;
        this.cod_postal = cod_postal;
        this.num_tlf = num_tlf;
    }

    public String getNombre_real() {
        return nombre_real;
    }

    public void setNombre_real(String nombre_real) {
        this.nombre_real = nombre_real;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCod_postal() {
        return cod_postal;
    }

    public void setCod_postal(String cod_postal) {
        this.cod_postal = cod_postal;
    }

    public String  getNum_tlf() {
        return num_tlf;
    }

    public void setNum_tlf(String  num_tlf) {
        this.num_tlf = num_tlf;
    }

    public int getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(int fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public ArrayList<String> getAmigos() {
        return amigos;
    }

    public void setAmigos(ArrayList<String> amigos) {
        this.amigos = amigos;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public ArrayList<String> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<String> tickets) {
        this.tickets = tickets;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "fotoPerfil=" + fotoPerfil +
                ", amigos=" + amigos +
                ", idUsuario='" + idUsuario + '\'' +
                ", tickets=" + tickets +
                ", nombre_real='" + nombre_real + '\'' +
                ", apellido='" + apellido + '\'' +
                ", contrasenya='" + contrasenya + '\'' +
                ", correo='" + correo + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", cod_postal=" + cod_postal +
                ", num_tlf=" + num_tlf +
                '}';
    }
}
