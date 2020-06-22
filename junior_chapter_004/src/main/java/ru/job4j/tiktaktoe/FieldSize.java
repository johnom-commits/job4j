package ru.job4j.tiktaktoe;

public class FieldSize implements ISize {
    private final int size;

    public FieldSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public Boolean winX(Logic logic) {
        // Проверяем первую строчку, первый столбец и две диагонали
        Boolean result = false;
        result = logic.fill(Figure::hasX, 0, 0, 1, 0)
                || logic.fill(Figure::hasX, 0, 0, 0, 1)
                || logic.fill(Figure::hasX, 0, 0, 1, 1)
                || logic.fill(Figure::hasX, size - 1, 0, -1, 1);
        // Проверяем остальные столбцы и строки
        if (!result) {
            for (int i = 1; i < size; i++) {
                result = logic.fill(Figure::hasX, 0, i, 1, 0)
                        || logic.fill(Figure::hasX, i, 0, 0, 1);
                if (result) {
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public Boolean win0(Logic logic) {
        Boolean result = false;
        result = logic.fill(Figure::hasO, 0, 0, 1, 0)
                || logic.fill(Figure::hasO, 0, 0, 0, 1)
                || logic.fill(Figure::hasO, 0, 0, 1, 1)
                || logic.fill(Figure::hasO, size - 1, 0, -1, 1);

        if (!result) {
            for (int i = 1; i < size; i++) {
                result = logic.fill(Figure::hasO, 0, i, 1, 0)
                        || logic.fill(Figure::hasO, i, 0, 0, 1);
                if (result) {
                    break;
                }
            }
        }
        return result;
    }
}
