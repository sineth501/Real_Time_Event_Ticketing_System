package com.example.realtimeeventticketingsystem.service;

import com.example.realtimeeventticketingsystem.thread.Customer;
import com.example.realtimeeventticketingsystem.thread.Vendor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;

@Service
public class ThreadManagerService {

    private final ExecutorService threadPool;
    private final TicketService ticketService;

    public ThreadManagerService(ExecutorService threadPool, TicketService ticketService) {
        this.threadPool = threadPool;
        this.ticketService = ticketService;
    }

    public void startSystem() {
        threadPool.submit(new Vendor(ticketService, 10));
        threadPool.submit(new Customer(ticketService));
    }

    public void stopSystem() {
        threadPool.shutdownNow();
    }
}
