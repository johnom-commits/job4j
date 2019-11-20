package ru.job4j.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AddressTest2 {
    @Test
    public void listAddressTest() {
        List<Profile> list = new ArrayList<>();
        Address address = new Address("Vladivostok", "Lenina", 12, 6);
        list.add(new Profile(address));
        Address address1 = new Address("Moscow", "Polkovaya", 3, 10);
        list.add(new Profile(address1));
        Address address2 = new Address("Moscow", "Polkovaya", 3, 10);
        list.add(new Profile(address2));
        Address address3 = new Address("Kozelsk", "Kolskaya", 1, 7);
        list.add(new Profile(address3));

        Profiles2 profiles = new Profiles2();
        List<Address> result = profiles.collect(list);

        List<Address> expected = new ArrayList<>();
        expected.add(address3);     // Сначала Козельск
        expected.add(address1);     // Потом Москва
        expected.add(address);      // Потом Vladivostok
        assertThat(result, is(expected));
    }
}
