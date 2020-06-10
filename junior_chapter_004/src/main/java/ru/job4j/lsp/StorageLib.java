package ru.job4j.lsp;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class StorageLib {

    public static Map<String, Storage> getStorageMap() {
        Map<String, Storage> storageMap = new HashMap<>();
        Storage shop = new Shop();
        Storage warehouse = new Warehouse();
        Storage trash = new Trash();
        storageMap.put("DateMore75percent", shop);
        storageMap.put("Date25to75percent", shop);
        storageMap.put("Date25percent", warehouse);
        storageMap.put("DateExpaire", trash);
        return storageMap;
    }

    public static ControlQuality defineStorage(LocalDate dataCreate, LocalDate dataExpaire) {
        ControlQuality quality;

        LocalDate today = LocalDate.now();
        long storagePeriod = ChronoUnit.DAYS.between(dataCreate, dataExpaire);
        long lastPeriod = ChronoUnit.DAYS.between(dataCreate, today);

        if (storagePeriod == 0) {
            throw new ArithmeticException("division by zero");
        }
        double percExpaire = lastPeriod * 100d / storagePeriod;
        if (percExpaire >= 75d & percExpaire <= 100) {
            quality = new DateMore75percent();
        } else if (percExpaire < 75d & percExpaire >= 25d) {
            quality = new Date25to75percent();
        } else if (percExpaire < 25d & percExpaire > 0d) {
            quality = new Date25percent();
        } else {
            quality = new DateExpaire();
        }
        return quality;
    }
}
