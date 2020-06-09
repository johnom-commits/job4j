package ru.job4j.desing.srp;

import java.util.function.Predicate;

public class ReportEngineXML {
    private Store store;

    public ReportEngineXML(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
            .append(System.lineSeparator())
            .append("<report>")
            .append(System.lineSeparator())
            .append("<title>Name; Hired; Fired; Salary</title>")
            .append(System.lineSeparator());
        for (Employer employer : store.findBy(filter)) {
            text.append("<line>")
                .append(employer.getName()).append(";")
                .append(employer.getHired()).append(";")
                .append(employer.getFired()).append(";")
                .append(employer.getSalary()).append(";")
                .append("</line>");
        }
        text.append(System.lineSeparator())
            .append("</report>")
            .append(System.lineSeparator());
        return text.toString();
    }
}
