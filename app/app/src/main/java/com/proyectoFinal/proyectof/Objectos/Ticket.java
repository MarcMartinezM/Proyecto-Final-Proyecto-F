package com.proyectoFinal.proyectof.Objectos;

public class Ticket {

    String event_id;
    int cantidad_ticket;
    String fecha_compra;
    String ticket_id;

    public Ticket() {

    }

    public Ticket(String event_id, int cantidad_ticket) {
        this.event_id = event_id;
        this.cantidad_ticket = cantidad_ticket;
    }

    public Ticket(String event_id, int cantidad_ticket, String fecha_compra, String ticket_id) {
        this.event_id = event_id;
        this.cantidad_ticket = cantidad_ticket;
        this.fecha_compra = fecha_compra;
        this.ticket_id = ticket_id;
    }

    public int getCantidad_ticket() {
        return cantidad_ticket;
    }
    public void setCantidad_ticket(int cantidad_ticket) {
        this.cantidad_ticket = cantidad_ticket;
    }
    public String getEvent_id() {
        return event_id;
    }
    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public String getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(String ticket_id) {
        this.ticket_id = ticket_id;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "event_id='" + event_id + '\'' +
                ", cantidad_ticket=" + cantidad_ticket +
                ", fecha_compra='" + fecha_compra + '\'' +
                ", ticket_id='" + ticket_id + '\'' +
                '}';
    }
}