package ru.job4j.condition;

public class Triangle {
    /**
     * Метод вычисления полупериметра по длинам сторон.
     * Формула.
     * (a + b + c) / 2
     * @param a расстояние между точками a b
     * @param b расстояние между точками a c
     * @param c расстояние между точками b c
     * @return полуперимента.
     */
    public double period(double a, double b, double c) {
        return (a + b + c) / 2;
    }
    /**
     * Треугольник можно построить, если суммы двух любых сторон больше длины третьей
     * @param a Длина от точки a b.
     * @param b Длина от точки a c.
     * @param c Длина от точки b c.
     * @return
     */
    private boolean exist(double a, double c, double b) {
        return (a + b > c) && (a + c > b) && (c + b > a);
    }
     /**
     * Метод должен вычислить площадь треугольника.
     * Формула.
     * √ p *(p - a) * (p - b) * (p - c)
     * где √ - корень квадратный, для извлечения корня использовать метод Math.sqrt().
     * @return Вернуть площадь, если треугольник существует или -1.
     */
    public double area(int x1, int y1, int x2, int y2, int x3, int y3) {
        double rsl = -1;
        double a = new Point().distance(x1, y1, x2, y2);
        double b = new Point().distance(x2, y2, x3, y3);
        double c = new Point().distance(x1, y1, x3, y3);
        double p = period(a, b, c);
        if (this.exist(a, b, c))
            rsl = Math.sqrt(p*(p - a)*(p - b)*(p - c));
        else
            rsl = -1;
        return rsl;
    }
}
