package ru.job4j.tiktaktoe;

public class Graphics {
    private final Figure[][] cells;

    public Graphics(Figure[][] cells) {
        this.cells = cells;
    }

    public void buildGrid() {
        StringBuilder rect = new StringBuilder();
        for (int i = 0; i < cells.length; i++) {
            if (i != 0) {
                rect.append(System.lineSeparator());
            }
            for (int j = 0; j < cells.length; j++) {
                rect.append("|");
                Figure cell = cells[i][j];
                if (cell.hasX()) {
                    rect.append("X");
                } else if (cell.hasO()) {
                    rect.append("O");
                } else {
                    rect.append(" ");
                }
            }
            rect.append("|");
        }
        System.out.println(rect);
    }

    public void initGrid() {
        for (int y = 0; y < cells.length; y++) {
            for (int x = 0; x < cells.length; x++) {
                cells[y][x] = new Figure();
            }
        }
    }
}
