package com.example.realtimeeventticketingsystem.thread;

import com.example.realtimeeventticketingsystem.model.Ticket;
import com.example.realtimeeventticketingsystem.service.TicketService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Vendor implements Runnable {

    private final TicketService ticketService;
    private final int ticketsPerBatch;

    public Vendor(TicketService ticketService, int ticketsPerBatch) {
        this.ticketService = ticketService;
        this.ticketsPerBatch = ticketsPerBatch;
    }

    @Override
    public void run() {
        try {
            while (true) {
                List<Ticket> tickets = generateTickets();
                ticketService.addTickets(tickets);
                Thread.sleep(5000); // Simulates ticket release interval
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private List<Ticket> generateTickets() {
        return IntStream.range(0, ticketsPerBatch)
                .mapToObj(i -> new Ticket(UUID.randomUUID().toString(), "Event", "Seat-" + i))
                .collect(Collectors.toList());
    }
}
