package org.example.application;

import org.example.domain.Ticket;

import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public interface LuckyTicketService {
    default long count(Iterator<Ticket> tickets) {
        Iterable<Ticket> iterableTicket = () -> tickets;
        Stream<Ticket> streamTicket = StreamSupport.stream(iterableTicket.spliterator(), false);
        return streamTicket.filter(Ticket::isLuck).count();
    }
}

