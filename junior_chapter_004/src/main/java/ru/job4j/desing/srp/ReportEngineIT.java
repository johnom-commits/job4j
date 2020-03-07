package ru.job4j.desing.srp;

import java.util.function.Predicate;

/**
 * Report for IT departament
 */
public class ReportEngineIT {
    private Store store;

    public ReportEngineIT(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<p>Name; Hired; Fired; Salary</p>");
        text.append(System.lineSeparator());
        for (Employer employer : store.findBy(filter)) {
            text.append("<p>")
                    .append(employer.getName()).append(";")
                    .append(employer.getHired()).append(";")
                    .append(employer.getFired()).append(";")
                    .append(employer.getSalary()).append(";")
                    .append("</p>");
        }
        text.append(System.lineSeparator());
        return text.toString();
    }
}
