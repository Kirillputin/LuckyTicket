package org.psu.java.example.application;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.psu.java.example.domain.Ticket;
import org.psu.java.example.infrastructure.TicketGenerator;

import java.util.Iterator;
import java.util.stream.IntStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Тесты для {@link FortunateTicketStreamImpl}
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FortunateTicketStreamImplTest {

    TicketGenerator ticketGenerator;
    int maxNumber;
    FortunateTicketService service;

    @Before
    public void setUp() {
        maxNumber = (int) Math.pow(10, 4);
        Iterator<Ticket> mockIterator = IntStream
                .range(0, maxNumber)
                .mapToObj(number -> {
                    Ticket mockTicket = Mockito.mock(Ticket.class);
                    when(mockTicket.getNumber()).thenReturn((long) number);
                    when(mockTicket.getLength()).thenReturn(4);
                    when(mockTicket.isFortunate()).thenReturn(true);
                    return mockTicket;
                })
                .iterator();
        ticketGenerator = Mockito.mock(TicketGenerator.class);
        when(ticketGenerator.getTickets()).thenReturn(mockIterator);
        service = new FortunateTicketStreamImpl();
    }

    @After
    public void tearDown() {
        service = null;
        ticketGenerator = null;
        maxNumber = 0;
    }

    @Test
    public void testCount() {
        // given
        // when
        int actual = service.count(ticketGenerator.getTickets());

        // then
        assertEquals("Должно быть 10 000 счастливых билетов", maxNumber, actual);
    }

}