package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindLoopTest {

    @Test
    public void whenArrayHas5Then0() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayHas7() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {7, 10, 3, 2, 1};
        int value = 3;
        int result = find.indexOf(input, value);
        int expect = 2;
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayHasNot() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3};
        int value = 1;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }

    @Test
    public void whenFind3() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 2, 10, 2, 4};
        int value = 2;
        int start = 2;
        int finish = 4;
        int result = find.indexOf(input, value, start, finish);
        int expect = 3;
        assertThat(result, is(expect));
    }
    @Test
    public void whenFind() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 2, 10, 2, 4};
        int value = 4;
        int start = 2;
        int finish = 4;
        int result = find.indexOf(input, value, start, finish);
        int expect = 4;
        assertThat(result, is(expect));
    }
    @Test
    public void whenSort5() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {3, 4, 1, 2, 5};
        int result[] = find.sort(input);
        int[] expect = new int[] {1, 2, 3, 4, 5};
        assertThat(result, is(expect));
    }

    @Test
    public void whenSort7() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {7, 4, 3, 2, 5, 1, 6};
        int result[] = find.sort(input);
        int[] expect = new int[] {1, 2, 3, 4, 5, 6, 7};
        assertThat(result, is(expect));
    }

    @Test
    public void whenSort6() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {3, 6, 1, 2, 5, 4};
        int result[] = find.sort(input);
        int[] expect = new int[] {1, 2, 3, 4, 5, 6};
        assertThat(result, is(expect));
    }
}