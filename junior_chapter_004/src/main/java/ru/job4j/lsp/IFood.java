package ru.job4j.lsp;

import java.time.LocalDate;

public interface IFood {
    void setQuality(ControlQuality controlQuality);

    void executeSort(Storage storage);

    LocalDate getExpaireDate();

    LocalDate getCreateDate();
}
