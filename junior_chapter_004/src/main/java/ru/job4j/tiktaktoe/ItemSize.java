package ru.job4j.tiktaktoe;

public class ItemSize {
    private int index;
    private String header;
    private ISize fieldSize;

    public ItemSize(int index, String header, ISize fieldSize) {
        this.index = index;
        this.header = header;
        this.fieldSize = fieldSize;
    }

    public ISize getFieldSize() {
        return fieldSize;
    }

    public int getIndex() {
        return index;
    }

    public String getHeader() {
        return header;
    }
}
