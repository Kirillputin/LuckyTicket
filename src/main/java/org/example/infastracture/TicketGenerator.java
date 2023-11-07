package org.example.infastracture;

import org.example.domain.Ticket;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;

public interface TicketGenerator {
    default Iterator<Ticket> getTickets(int placeNumber) {
        double maxNumberTicket = Math.pow(10, placeNumber);
        int numberTicket = 0;

        List<Ticket> ticketsList = new ArrayList<>();

        while (numberTicket < maxNumberTicket) {
            var finelNumberTicket = numberTicket;

           Supplier<Boolean> supplier = () -> isLuck( finelNumberTicket, placeNumber);

            ticketsList.add(supplier::get);
            numberTicket++;
        }
        return ticketsList.iterator();
    }

    static boolean isLuck( int ticketNumber, int  placeNumber  ){
        int number;
        int leftSide = 0;
        int rightSide = 0;

        int middle = placeNumber / 2;

        for (int count = 0; count < placeNumber; count++) {

            number = (int) ((ticketNumber / Math.pow(10, count)) % 10);

            if (count < middle) {
                leftSide += number;

            } else {
                rightSide += number;
            }
        }
        return leftSide == rightSide;
    }
}
