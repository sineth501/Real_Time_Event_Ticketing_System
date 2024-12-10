package com.example.realtimeeventticketingsystem.service;

import com.example.realtimeeventticketingsystem.model.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class TicketService {

    private final Queue<Ticket> ticketPool = new ConcurrentLinkedQueue<>();
    private final int maxCapacity = 100;

    public synchronized boolean addTickets(List<Ticket> tickets) {
        if (ticketPool.size() + tickets.size() <= maxCapacity) {
            ticketPool.addAll(tickets);
            notifyAll();
            return true;
        }
        return false;
    }

    public synchronized Ticket removeTicket() throws InterruptedException {
        while (ticketPool.isEmpty()) {
            wait();
        }
        return ticketPool.poll();
    }

    public int getAvailableTickets() {
        return ticketPool.size();
    }
}
