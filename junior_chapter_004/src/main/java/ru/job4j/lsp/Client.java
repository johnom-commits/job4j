package ru.job4j.lsp;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class Client {
    private static final double DISCOUNT = 30;

    public static void main(String[] args) {
        LocalDate dataCreate;
        LocalDate dataExpaire;
        ControlQuality quality;
        Storage shop = new Shop();
        Storage warehouse = new Warehouse();
        Storage trash = new Trash();
        Map<String, Storage> storageMap = new HashMap<>();
        storageMap.put("DateMore75percent", shop);
        storageMap.put("Date25to75percent", shop);
        storageMap.put("Date25percent", warehouse);
        storageMap.put("DateExpaire", trash);

        Map<String, Double> discountMap = new HashMap<>();
        discountMap.put("DateMore75percent", 0D);
        discountMap.put("Date25to75percent", 0D);
        discountMap.put("Date25percent", DISCOUNT);
        discountMap.put("DateExpaire", 0D);

        dataCreate = LocalDate.of(2020, 1, 20);
        dataExpaire = LocalDate.of(2020, 3, 20);
        quality = defineStorage(dataCreate, dataExpaire);
        IFood milk = new Milk("A house in village", dataExpaire, dataCreate, 50, discountMap.get(quality.getName()));
        milk.setQuality(quality);
        milk.executeSort(storageMap.get(quality.getName()));

        dataCreate = LocalDate.of(2019, 9, 20);
        dataExpaire = LocalDate.of(2020, 2, 20);
        quality = defineStorage(dataCreate, dataExpaire);
        IFood apple = new Apple("Antonovka", dataCreate, dataExpaire, 100, discountMap.get(quality.getName()));
        apple.setQuality(quality);
        apple.executeSort(storageMap.get(quality.getName()));

        dataCreate = LocalDate.of(2019, 12, 20);
        dataExpaire = LocalDate.of(2020, 12, 20);
        quality = defineStorage(dataCreate, dataExpaire);
        IFood chocolate = new Chocolate("Alenka", dataCreate, dataExpaire, 80, discountMap.get(quality.getName()));
        chocolate.setQuality(quality);
        chocolate.executeSort(storageMap.get(quality.getName()));

        dataCreate = LocalDate.of(2020, 02, 27);
        dataExpaire = LocalDate.of(2020, 03, 10);
        quality = defineStorage(dataCreate, dataExpaire);
        IFood cake = new Cake("Kartoshka", dataCreate, dataExpaire, 150, discountMap.get(quality.getName()));
        cake.setQuality(quality);
        cake.executeSort(storageMap.get(quality.getName()));
    }

    private static ControlQuality defineStorage(LocalDate dataCreate, LocalDate dataExpaire) {
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
