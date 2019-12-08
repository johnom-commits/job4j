package ru.job4j.list;

public class SimpleStack<T> {

    private ContainerLinkedList list;

    public SimpleStack() {
        list = new ContainerLinkedList();
    }

    public T poll() {
        return (T) list.remove();
    }

    public void push(T value) {
        list.add(value);
    }
}
