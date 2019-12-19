package ru.job4j.tree;

import java.util.ArrayList;
import java.util.List;

public class Node<E extends Comparable<E>> {
    private final List<Node<E>> children = new ArrayList<>();
    private final E value;

    public Node(final E aValue) {
        value = aValue;
    }

    public E getValue() {
        return value;
    }

    public void add(Node<E> child) {
        children.add(child);
    }

    public List<Node<E>> leaves() {
        return children;
    }

    public boolean eqValue(E that) {
        return value.compareTo(that) == 0;
    }
}
