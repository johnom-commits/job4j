package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RoleStoreTest {

    @Test
    public void whenRoleStoreAdd() {
        RoleStore list = new RoleStore();
        Role role1 = new Role("00001", "Ivan");
        list.add(role1);
        Role role2 = new Role("00002", "Boris");
        list.add(role2);
        Role role3 = new Role("00003", "Vova");
        list.add(role3);

        assertThat(list.findById("00002"), is(role2));
    }

    @Test
    public void whenRoleDelete() {
        RoleStore list = new RoleStore();
        Role role1 = new Role("00001", "Ivan");
        list.add(role1);
        Role role2 = new Role("00002", "Boris");
        list.add(role2);
        Role role3 = new Role("00003", "Vova");
        list.add(role3);

        list.delete("00002");

        assertThat(list.size(), is(2));
    }

    @Test
    public void whenRoleReplace() {
        RoleStore list = new RoleStore();
        Role role1 = new Role("00001", "Ivan");
        list.add(role1);
        Role role2 = new Role("00002", "Boris");
        list.add(role2);
        Role role3 = new Role("00003", "Vova");
        list.add(role3);

        Role newUser = new Role("00005", "Makar");

        list.replace("00002", newUser);

        assertThat(list.findById("00005").getDescription(), is("Makar"));
    }

}