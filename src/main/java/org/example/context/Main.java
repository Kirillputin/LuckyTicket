package org.example.context;

import org.example.application.LuckyServiceImp;
import org.example.application.LuckyTicketService;
import org.example.infastracture.TicketGenImpl;
import org.example.infastracture.TicketGenerator;

public class Main {
    private static final TicketGenerator generator = new TicketGenImpl();
    private static final LuckyTicketService service = new LuckyServiceImp();

    public static void main(String[] args) {
        System.out.println(service.count(generator.getTickets(6)));
    }
}