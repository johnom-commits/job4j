package ru.job4j.lsp;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static ru.job4j.lsp.StorageLib.defineStorage;

public class Client {
    private static final double DISCOUNT = 30;

    public static void main(String[] args) {
        LocalDate dataCreate;
        LocalDate dataExpaire;
        ControlQuality quality;
        Map<String, Storage> storageMap = StorageLib.getStorageMap();

        Map<String, Double> discountMap = new HashMap<>();
        discountMap.put("DateMore75percent", 0D);
        discountMap.put("Date25to75percent", 0D);
        discountMap.put("Date25percent", DISCOUNT);
        discountMap.put("DateExpaire", 0D);

        dataCreate = LocalDate.of(2020, 5, 20);
        dataExpaire = LocalDate.of(2020, 8, 20);
        quality = defineStorage(dataCreate, dataExpaire);
        IFood milk = new Milk("A house in village", dataExpaire, dataCreate, 50, discountMap.get(quality.getName()));
        milk.setQuality(quality);
        milk.executeSort(storageMap.get(quality.getName()));

        dataCreate = LocalDate.of(2019, 9, 20);
        dataExpaire = LocalDate.of(2020, 7, 20);
        quality = defineStorage(dataCreate, dataExpaire);
        IFood apple = new Apple("Antonovka", dataExpaire, dataCreate, 100, discountMap.get(quality.getName()));
        apple.setQuality(quality);
        apple.executeSort(storageMap.get(quality.getName()));

        dataCreate = LocalDate.of(2019, 12, 20);
        dataExpaire = LocalDate.of(2020, 05, 20);
        quality = defineStorage(dataCreate, dataExpaire);
        IFood chocolate = new Chocolate("Alenka", dataExpaire, dataCreate, 80, discountMap.get(quality.getName()));
        chocolate.setQuality(quality);
        chocolate.executeSort(storageMap.get(quality.getName()));

        dataCreate = LocalDate.of(2020, 05, 27);
        dataExpaire = LocalDate.of(2020, 06, 20);
        quality = defineStorage(dataCreate, dataExpaire);
        IFood cake = new Cake("Kartoshka", dataExpaire, dataCreate, 150, discountMap.get(quality.getName()));
        cake.setQuality(quality);
        cake.executeSort(storageMap.get(quality.getName()));

        List<Storage> storageList = storageMap.values().stream().distinct().collect(toList());
        ControlQuality resortFood = new ResortFood(storageList);
        resortFood.resort();
    }
}
