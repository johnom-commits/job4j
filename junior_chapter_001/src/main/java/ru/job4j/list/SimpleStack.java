package ru.job4j.list;

public class SimpleStack<T> {

    private ContainerLinkedList list;

    public SimpleStack() {
        list = new ContainerLinkedList();
    }

    public T poll() {
        T value = (T) list.get(0);
        list.remove();
        return value;
    }

    public void push(T value) {
        list.add(value);
    }
}
