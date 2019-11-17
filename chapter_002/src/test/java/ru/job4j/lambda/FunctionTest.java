package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FunctionTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = Function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenLinearResults() {
        List<Double> result = Function.diapason(5, 8, x -> x * x + x + 2);
        List<Double> expected = Arrays.asList(32D, 44D, 58D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogarithmicFunctionThenLinearResults() {
        List<Double> result = Function.diapason(1, 4, x ->  Math.log10(x));
        List<Double> expected = Arrays.asList(0.0, 0.3010299956639812D, 0.47712125471966244D);
        assertThat(result, is(expected));
    }
}
