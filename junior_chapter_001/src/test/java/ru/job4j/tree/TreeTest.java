package ru.job4j.tree;

import org.junit.Test;
import java.util.Iterator;
import static org.junit.Assert.*;

public class TreeTest {

    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        boolean expected = tree.findBy(6).isPresent();
        assertTrue(expected);
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        boolean expected = tree.findBy(7).isPresent();
        assertFalse(expected);
    }

    @Test
    public void whenTestIteratorNext() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);

        Iterator it = tree.iterator();
        it.next();
        it.next();
        it.next();
        it.next();
        int expected = (Integer) it.next();
        assertEquals(expected, 5);
    }

    @Test
    public void whenTestIteratorHasNextTrue() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);

        Iterator it = tree.iterator();
        it.next();
        assertTrue(it.hasNext());
    }

    @Test
    public void whenTestIteratorNextNull() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);

        Iterator it = tree.iterator();
        it.next();
        it.next();
        it.next();
        assertNull(it.next());
    }

    @Test
    public void whenTestIteratorHasNextFalse() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);

        Iterator it = tree.iterator();
        it.next();
        it.next();
        it.next();
        assertFalse(it.hasNext());
    }

    @Test
    public void whenIsNotBinary() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertFalse(tree.isBinary());
    }

    @Test
    public void whenIsBinary() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(4, 6);
        assertTrue(tree.isBinary());
    }
}