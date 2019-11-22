package ru.job4j.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AddressTest {
    @Test
    public void listAddressTest() {
        List<Profile> list = new ArrayList<>();
        Address address = new Address("Moscow", "Lenina", 12, 6);
        list.add(new Profile(address));
        Address address1 = new Address("Moscow", "Polkovaya", 3, 10);
        list.add(new Profile(address1));

        Profiles profiles = new Profiles();
        List<Address> result = profiles.collect(list);

        List<Address> expected = List.of(address, address1);
        assertThat(result, is(expected));
    }
}
