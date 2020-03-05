package ru.job4j.lsp;

import java.time.LocalDate;

public class Cake extends Food {
    protected Cake(String name, LocalDate expaireDate, LocalDate createDate, double price, double discount) {
        super(name, expaireDate, createDate, price, discount);
    }
}
