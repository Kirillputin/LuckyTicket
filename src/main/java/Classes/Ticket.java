package Classes;

import java.util.Iterator;

public class Ticket {
    public static boolean is_luck(int ticketNumber, int placeNumber) {
        int number;
        int leftSide = 0;
        int rightSide = 0;

        int middle = placeNumber / 2;

        for (int count = 0; count < placeNumber; count++) {

            number = (int) (( ticketNumber / Math.pow( 10, count ) ) % 10);

            if (count < middle) {
               leftSide += number;

            } else {
               rightSide += number;
            }
        }

        return  leftSide == rightSide;
    }

    public static int getLuckyNumber(int placeNumber) {
        int luckyNumber = 0;
        double maxNumberTicket = 1;
        int ticket = 0;

        maxNumberTicket = Math.pow( 10, placeNumber );


        while (ticket < (maxNumberTicket)) {
            if (Ticket.is_luck(ticket, placeNumber)) {
                luckyNumber++;
            }
            ticket++;
        }
        return luckyNumber;
    }
}