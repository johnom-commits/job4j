package ru.job4j.list;

public class SimpleQueue<T> {

    private SimpleStack stack1;
    private SimpleStack stack2;
    private int sizeStack2 = 0;
    private int sizeStack1 = 0;

    public SimpleQueue() {
        stack1 = new SimpleStack();
        stack2 = new SimpleStack();
    }

    public void push(T value) {
        stack1.push(value);
        sizeStack1++;
    }

    public T poll() {
        if (sizeStack2 == 0) {
            remove();
        }
        sizeStack2--;
        return (T) stack2.poll();
    }

    private void remove() {
        while (sizeStack1 > 0) {
            stack2.push(stack1.poll());
            sizeStack1--;
            sizeStack2++;
        }
    }
}
