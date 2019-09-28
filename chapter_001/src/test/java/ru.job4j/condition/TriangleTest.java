package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;


public class TriangleTest {
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        Point ap = new Point(0, 0);
        Point bp = new Point(0, 2);
        Point cp = new Point(2, 0);
        // Создаем объект треугольник.
        Triangle triangle = new Triangle(ap, bp, cp);
        // Вычисляем площадь.
        double result = triangle.area(ap, bp, cp);
        // Задаем ожидаемый результат.
        double expected = 2D;
        //Проверяем результат и ожидаемое значение.
        assertThat(result, closeTo(expected, 0.1));
    }

    @Test
    public void whenAreaSetThreePointsThenTriangleArea2() {
        Point ap = new Point(1, 1);
        Point bp = new Point(1, 4);
        Point cp = new Point(4, 1);
        // Создаем объект треугольник.
        Triangle triangle = new Triangle(ap, bp, cp);
        // Вычисляем площадь.
        double result = triangle.area(ap, bp, cp);
        // Задаем ожидаемый результат.
        double expected = 4.5D;
        //Проверяем результат и ожидаемое значение.
        assertThat(result, closeTo(expected, 0.1));
    }
}