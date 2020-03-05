package ru.job4j.lsp;

import java.time.LocalDate;

public class Food implements IFood {
    private String name;
    private LocalDate expaireDate;
    private LocalDate createDate;
    private double price;
    private double discount;
    public ControlQuality quality;

    protected Food(String name, LocalDate expaireDate, LocalDate createDate, double price, double discount) {
        this.name = name;
        this.expaireDate = expaireDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public void setQuality(ControlQuality controlQuality) {
        quality = controlQuality;
    }

    public void executeSort(Storage storage) {
        quality.sort(this, storage);
    }
}
