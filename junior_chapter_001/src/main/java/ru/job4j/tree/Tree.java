package ru.job4j.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    public Node<E> root;
    private int modCount = 0;

    public Tree(E value) {
        root = new Node<>(value);
    }

    public boolean isBinary() {
        Node<E> result;
        int size = 0;

        Queue<Node<E>> data = new LinkedList<>();
        data.offer(root);
        while (!data.isEmpty()) {
            result = data.poll();
            for (Node<E> child : result.leaves()) {
                data.offer(child);
            }
            size = Math.max(result.leaves().size(), size);
        }
        return size <= 2;
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> papaOpt = findBy(parent);
        Optional<Node<E>> son = findBy(child);
        if (son.isPresent() || papaOpt.isEmpty()) {
            return false;
        }
        Node<E> papa = papaOpt.get();
        papa.add(new Node<>(child));
        modCount++;
        return true;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<E> {
        Queue<Node<E>> data = new LinkedList<>();
        int expectedModCount = modCount;

        public Iter() {
            data.offer(root);
        }

        @Override
        public boolean hasNext() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return !data.isEmpty();
        }

        @Override
        public E next() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            Node<E> result = null;
            if (!data.isEmpty()) {
                result = data.poll();
                for (Node<E> child : result.leaves()) {
                    data.offer(child);
                }
            }
            return (result == null) ? null : result.getValue();
        }
    }
}
