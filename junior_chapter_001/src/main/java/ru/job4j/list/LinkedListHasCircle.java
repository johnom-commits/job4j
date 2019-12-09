package ru.job4j.list;

public class LinkedListHasCircle<E> {

    public static boolean hasCycle(Node first) {
        if (first == null) {
            return false;
        }

        Node<Integer> turtle = first;
        Node<Integer> hare = first;

        while (hare.next != null) {
            turtle = turtle.next;
            hare = hare.next.next;

            if (turtle == null || hare == null) {
                return false;
            }
            if (turtle == hare) {
                return true;
            }
        }
        return false;
    }

    public static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }
}
