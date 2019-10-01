package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Бендер Остап Ибрагимович");
        student.setGroup("new Васюки");
        student.setDateReceipt(new Date());
        System.out.println("Студент: " + student.getFullName() + ", группа: " + student.getGroup() + ", принят: " + student.getDateReceipt());
    }
}
