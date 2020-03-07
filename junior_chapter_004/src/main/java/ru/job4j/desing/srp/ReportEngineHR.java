package ru.job4j.desing.srp;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Report for HR departament
 */
public class ReportEngineHR {
    private Store store;

    public ReportEngineHR(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary");
        text.append(System.lineSeparator());

        List<Employer> list = store.findBy(filter);
        sort(list);
        for (Employer employer : list) {
                text.append(employer.getName()).append(";")
                    .append(employer.getSalary()).append(";");
        }
        text.append(System.lineSeparator());
        return text.toString();
    }

    private List<Employer> sort(List<Employer> list) {
        Collections.sort(list, new Comparator<Employer>() {
//            comparison for double
            @Override
            public int compare(Employer o1, Employer o2) {
                 if (o2.getSalary() > o1.getSalary()) {
                     return 1;
                 }
                if (o2.getSalary() < o1.getSalary()) {
                    return -1;
                }
                return 0;
            }
        });
        return list;
    }
}
