package ru.job4j.map;

public class DataItem<K, V> {
    private K key;
    private V data;

    public DataItem(K key, V data) {
        this.key = key;
        this.data = data;
    }

    public V getData() {
        return data;
    }

    public K getKey() {
        return key;
    }

    public void setData(V data) {
        this.data = data;
    }
}
