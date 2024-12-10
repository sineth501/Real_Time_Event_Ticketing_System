package com.example.realtimeeventticketingsystem.controller;

import com.example.realtimeeventticketingsystem.service.ThreadManagerService;
import com.example.realtimeeventticketingsystem.service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/system")
public class SystemController {

    private final TicketService ticketService;
    private final ThreadManagerService threadManagerService;

    public SystemController(TicketService ticketService, ThreadManagerService threadManagerService) {
        this.ticketService = ticketService;
        this.threadManagerService = threadManagerService;
    }

    @PostMapping("/start")
    public String startSystem() {
        threadManagerService.startSystem();
        return "System started with vendors and customers.";
    }

    @PostMapping("/stop")
    public String stopSystem() {
        threadManagerService.stopSystem();
        return "System stopped.";
    }

    @GetMapping("/status")
    public Map<String, Integer> getStatus() {
        return Map.of("Available Tickets", ticketService.getAvailableTickets());
    }
}
