package com.example.realtimeeventticketingsystem.thread;

import com.example.realtimeeventticketingsystem.model.Ticket;
import com.example.realtimeeventticketingsystem.service.TicketService;

public class Customer implements Runnable {

    private final TicketService ticketService;

    public Customer(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Ticket ticket = ticketService.removeTicket();
                System.out.println("Customer purchased: " + ticket);
                Thread.sleep(2000); // Simulates customer purchase interval
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
