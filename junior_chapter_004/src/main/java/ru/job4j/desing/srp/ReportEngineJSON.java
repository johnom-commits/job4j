package ru.job4j.desing.srp;

import java.util.function.Predicate;

public class ReportEngineJSON {
    private Store store;

    public ReportEngineJSON(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("{")
                .append(System.lineSeparator())
                .append("\"title\": \"Name; Hired; Fired; Salary\",")
                .append(System.lineSeparator());
        for (Employer employer : store.findBy(filter)) {
            text.append("\"line\": ")
                    .append("\"")
                    .append(employer.getName()).append(";")
                    .append(employer.getHired()).append(";")
                    .append(employer.getFired()).append(";")
                    .append(employer.getSalary()).append("\"");
        }
        text.append(System.lineSeparator())
                .append("}")
                .append(System.lineSeparator());
        return text.toString();
    }
}
