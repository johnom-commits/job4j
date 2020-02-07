package ru.job4j.tracker;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class TrackerSQLTest {
    @Test
    public void checkConnection() throws Exception {
        try (TrackerSQL sql = new TrackerSQL()) {
            assertTrue(sql.init());
        } catch (SQLException e) {
            System.out.println(e.getStackTrace());
        }
    }
}