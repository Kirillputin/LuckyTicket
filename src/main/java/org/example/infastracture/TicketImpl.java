package org.example.infastracture;

import org.example.domain.Ticket;

public class TicketImpl implements Ticket {
    private final int ticketNumber;
    private final int placeNumber;

    public TicketImpl(int placeNumber, int ticketNumber) {
        this.ticketNumber = ticketNumber;
        this.placeNumber = placeNumber;
    }
    @Override
    public boolean isLuck() {
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
