package com.proyectoFinal.proyectof.Objectos;

public class Ticket {

    int event_id;
    int cantidad_ticket;

    public Ticket() {

    }

    public Ticket(int event_id, int cantidad_ticket) {
        this.event_id = event_id;
        this.cantidad_ticket = cantidad_ticket;
    }

    public int getCantidad_ticket() {
        return cantidad_ticket;
    }
    public void setCantidad_ticket(int cantidad_ticket) {
        this.cantidad_ticket = cantidad_ticket;
    }
    public int getEvent_id() {
        return event_id;
    }
    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "event_id=" + event_id +
                ", cantidad_ticket=" + cantidad_ticket +
                '}';
    }
}