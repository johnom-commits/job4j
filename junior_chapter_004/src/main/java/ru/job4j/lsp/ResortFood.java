package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResortFood implements ControlQuality {
    List<Storage> storageList = new ArrayList<>();

    public ResortFood(List<Storage> storageList) {
        this.storageList = storageList;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void resort() {
        ControlQuality quality;
        Map<String, Storage> storageMap = StorageLib.getStorageMap();
        List<IFood> iFoodList = new ArrayList<>();
        // собираем продукты
        for (Storage storage : storageList) {
            iFoodList.addAll(storage.getFoodList());
        }
        // распределяем
        for (IFood food : iFoodList) {
            quality = StorageLib.defineStorage(food.getCreateDate(), food.getExpaireDate());
            food.setQuality(quality);
            food.executeSort(storageMap.get(quality.getName()));
        }
    }
}
