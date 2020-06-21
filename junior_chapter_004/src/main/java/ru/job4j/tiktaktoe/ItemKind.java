package ru.job4j.tiktaktoe;

public class ItemKind {
    private int index;
    private String header;
    private IKindOfGame kind;

    public ItemKind(int index, String header, IKindOfGame kind) {
        this.index = index;
        this.header = header;
        this.kind = kind;
    }

    public int getIndex() {
        return index;
    }

    public String getHeader() {
        return header;
    }

    public IKindOfGame getKind() {
        return kind;
    }
}
