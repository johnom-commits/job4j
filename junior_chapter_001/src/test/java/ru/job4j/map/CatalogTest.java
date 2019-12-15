package ru.job4j.map;

import org.junit.Test;
import java.util.GregorianCalendar;
import static org.junit.Assert.*;

public class CatalogTest {

    @Test
    public void whenEqualsTwoObjectHashCodeEqualsToo() {
        User user = new User("Ivan", 2, new GregorianCalendar(1908, 11, 10));
        Catalog catalog1 = new Catalog(1, "Test", user);
        Catalog catalog2 = new Catalog(1, "Test", user);
        int result = catalog1.hashCode();
        int expected = catalog2.hashCode();
        assertEquals(result, expected);
    }

    @Test
    public void whenDiffTwoObjectHashCodeEqualsDiff() {
        User user = new User("Ivan", 2, new GregorianCalendar(1908, 11, 10));
        Catalog catalog1 = new Catalog(1, "Test", user);
        Catalog catalog2 = new Catalog(2, "Test", user);
        int result = catalog1.hashCode();
        int expected = catalog2.hashCode();
        assertNotEquals(result, expected);
    }
}