package ru.job4j.tiktaktoe;

public class Figure {
    private boolean markX = false;
    private boolean markO = false;

    public Figure() {
    }

    public Figure(boolean markX, boolean markO) {
        this.markX = markX;
        this.markO = markO;
    }

    public void take(boolean markX) {
        this.markX = markX;
        this.markO = !markX;
    }

    public boolean hasX() {
        return markX;
    }

    public boolean hasO() {
        return markO;
    }
}
