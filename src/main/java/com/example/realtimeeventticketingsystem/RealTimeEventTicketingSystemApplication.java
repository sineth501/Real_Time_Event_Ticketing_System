package com.example.realtimeeventticketingsystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RealTimeEventTicketingSystemApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RealTimeEventTicketingSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Real-Time Event Ticketing System Application Started...");
        // Initialize or preload any configurations if needed.
    }
}
