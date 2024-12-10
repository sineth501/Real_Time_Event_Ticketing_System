package com.example.realtimeeventticketingsystem.model;

public class Ticket {
    private String ticketId;
    private String eventName;
    private String seatNumber;

    public Ticket(String ticketId, String eventName, String seatNumber) {
        this.ticketId = ticketId;
        this.eventName = eventName;
        this.seatNumber = seatNumber;
    }

    // Getters and setters omitted for brevity
}
