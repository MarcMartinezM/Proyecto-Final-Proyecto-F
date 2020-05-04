package com.proyectoFinal.proyectof.Objectos;

public class Ticket {
    String nombre_Ticket;
    int cantidad_ticket;
    public Ticket() {
        super();
    }
    public Ticket(String nombre_Ticket, int cantidad_ticket) {
        super();
        this.nombre_Ticket = nombre_Ticket;
        this.cantidad_ticket = cantidad_ticket;
    }
    public String getNombre_Ticket() {
        return nombre_Ticket;
    }
    public void setNombre_Ticket(String nombre_Ticket) {
        this.nombre_Ticket = nombre_Ticket;
    }
    public int getCantidad_ticket() {
        return cantidad_ticket;
    }
    public void setCantidad_ticket(int cantidad_ticket) {
        this.cantidad_ticket = cantidad_ticket;
    }
    @Override
    public String toString() {
        return "Ticket [nombre_Ticket=" + nombre_Ticket + ", cantidad_ticket=" + cantidad_ticket + "]";
    }


}