package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        String[] input = {"Lutz", "Axcel", "Lutz", "Salhov", "Loop", "Flip"};
        String[] except = {"Lutz", "Axcel", "Flip", "Salhov", "Loop"};
        ArrayDuplicate array = new ArrayDuplicate();
        String[] resultArray = array.remove(input);
        assertThat(resultArray, is(except));
    }
}
