package ru.job4j.tiktaktoe;

public class FieldSize3 implements ISize {

    public int getSize() {
        return 3;
    }

    @Override
    public Boolean winX(Logic logic) {
        return logic.fill(Figure::hasX, 0, 0, 1, 0)
                || logic.fill(Figure::hasX, 0, 0, 0, 1)
                || logic.fill(Figure::hasX, 1, 0, 0, 1)
                || logic.fill(Figure::hasX, 2, 0, 0, 1)
                || logic.fill(Figure::hasX, 0, 1, 1, 0)
                || logic.fill(Figure::hasX, 0, 0, 1, 1)
                || logic.fill(Figure::hasX, 2, 0, -1, 1)
                || logic.fill(Figure::hasX, 0, 2, 1, 0);
    }

    @Override
    public Boolean win0(Logic logic) {
        return logic.fill(Figure::hasO, 0, 0, 1, 0)
                || logic.fill(Figure::hasO, 0, 0, 0, 1)
                || logic.fill(Figure::hasO, 0, 0, 1, 1)
                || logic.fill(Figure::hasO, 1, 0, 0, 1)
                || logic.fill(Figure::hasO, 2, 0, 0, 1)
                || logic.fill(Figure::hasO, 0, 1, 1, 0)
                || logic.fill(Figure::hasO, 2, 0, -1, 1)
                || logic.fill(Figure::hasO, 0, 2, 1, 0);
    }
}
