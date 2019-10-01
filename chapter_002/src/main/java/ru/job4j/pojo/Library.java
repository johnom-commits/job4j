package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book clean = new Book("Clean code", 4);
        Book java = new Book("Head java", 2);
        Book onegin = new Book("Evgeniy Onegin", 5);
        Book nerve = new Book("Nerve", 1);

        Book books[] = new Book[4];
        books[0] = clean;
        books[1] = java;
        books[2] = onegin;
        books[3] = nerve;

        for (int index = 0; index < 4; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getCount());
        }

        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;

        for (int index = 0; index < 4; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getCount());
        }

        for (int index = 0; index < 4; index++) {
            Book bk = books[index];
            if (bk.getName() == "Clean code") {
                System.out.println(bk.getName() + " - " + bk.getCount());
            }
        }
    }
}
