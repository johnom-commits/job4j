package ru.job4j.desing.srp;

import java.util.function.Predicate;

/**
 * Report for accounting departament
 */
public class ReportEngineAccount {
    private final double WITHOUT_TAX = 0.87D;
    private Store store;

    public ReportEngineAccount(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary");
        text.append(System.lineSeparator());
        for (Employer employer : store.findBy(filter)) {
            text.append(employer.getName()).append(";")
                    .append(employer.getHired()).append(";")
                    .append(employer.getFired()).append(";")
                    .append(getWithoutTax(employer.getSalary())).append(";");
        }
        text.append(System.lineSeparator());
        return text.toString();
    }

    private double getWithoutTax(double salary) {
        return salary * WITHOUT_TAX;
    }
}
