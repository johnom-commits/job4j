package ru.job4j.tdd;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CinemaTest {
    @Ignore
    @Test
    public void buy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Ignore
    @Test
    public void find() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

    // при покупке билета любитель синематографа не выбрал места
    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenBuyWithoutPlaces() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 0, 0, date);
    }

    // пользователь не нашёл нужный сеанс
    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenDoNotFoundSession() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> false);
    }

    // когда пользователь указал неправильную дату
    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenSetWrongDate() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2002, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 4, 4, date);
    }

    // пользователь приобрёл два билета на места для поцелуев
    @Ignore
    @Test
    public void whenBuyTwoTickets() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(cinema.buy(account, 20, 11, date));
        ticketList.add(cinema.buy(account, 20, 12, date));
        assertEquals(2, ticketList.size());
    }
}
