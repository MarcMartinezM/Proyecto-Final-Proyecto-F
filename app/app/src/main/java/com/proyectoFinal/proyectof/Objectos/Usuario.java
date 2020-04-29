package com.proyectoFinal.proyectof.Objectos;

public class Usuario {
    String nombre_real;
    String apellido;
    String nombre_usuario;
    String contrasenya;
    String correo;
    int cod_postal;
    int num_tlf;

    public Usuario(){

    }

    public Usuario(String nombre_real, String apellido, String nombre_usuario, String contrasenya, String correo, int cod_postal, int num_tlf) {
        this.nombre_real = nombre_real;
        this.apellido = apellido;
        this.nombre_usuario = nombre_usuario;
        this.contrasenya = contrasenya;
        this.correo = correo;
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

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
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

    public int getCod_postal() {
        return cod_postal;
    }

    public void setCod_postal(int cod_postal) {
        this.cod_postal = cod_postal;
    }

    public int getNum_tlf() {
        return num_tlf;
    }

    public void setNum_tlf(int num_tlf) {
        this.num_tlf = num_tlf;
    }
}
