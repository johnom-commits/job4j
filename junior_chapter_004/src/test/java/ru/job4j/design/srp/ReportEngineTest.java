package ru.job4j.design.srp;

import org.junit.Test;
import ru.job4j.desing.srp.*;
import java.util.Calendar;
import static org.junit.Assert.assertEquals;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        Calendar now = Calendar.getInstance();
        MemStore store = new MemStore();
        Employer worker = new Employer("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertEquals(expect.toString(), engine.generate(em -> true));
    }

    @Test
    public void whenGeneratedForHR() {
        Calendar now = Calendar.getInstance();
        MemStore store = new MemStore();
        Employer worker = new Employer("Petrov", now, now, 80);
        Employer worker2 = new Employer("Vasechkin", now, now, 100);
        store.add(worker);
        store.add(worker2);
        ReportEngineHR engine = new ReportEngineHR(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(worker.getName()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertEquals(expect.toString(), engine.generate(em -> true));
    }

    @Test
    public void whenGeneratedForAccounting() {
        Calendar now = Calendar.getInstance();
        MemStore store = new MemStore();
        Employer worker = new Employer("Petrov", now, now, 200);
        store.add(worker);
        ReportEngineAccount engine = new ReportEngineAccount(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary() * 0.87D).append(";")
                .append(System.lineSeparator());
        assertEquals(expect.toString(), engine.generate(em -> true));
    }

    @Test
    public void whenGeneratedForIT() {
        Calendar now = Calendar.getInstance();
        MemStore store = new MemStore();
        Employer worker = new Employer("Petrov", now, now, 200);
        store.add(worker);
        ReportEngineIT engine = new ReportEngineIT(store);
        StringBuilder expect = new StringBuilder()
                .append("<p>Name; Hired; Fired; Salary</p>")
                .append(System.lineSeparator())
                .append("<p>")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append("</p>")
                .append(System.lineSeparator());
        assertEquals(expect.toString(), engine.generate(em -> true));
    }

    @Test
    public void whenGeneratedReportXML() {
        Calendar now = Calendar.getInstance();
        MemStore store = new MemStore();
        Employer worker = new Employer("Petrov", now, now, 200);
        store.add(worker);
        ReportEngineXML engine = new ReportEngineXML(store);
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
                .append(System.lineSeparator())
                .append("<report>")
                .append(System.lineSeparator())
                .append("<title>Name; Hired; Fired; Salary</title>")
                .append(System.lineSeparator())
                .append("<line>")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append("</line>")
                .append(System.lineSeparator())
                .append("</report>")
                .append(System.lineSeparator());
        assertEquals(expect.toString(), engine.generate(em -> true));
    }

    @Test
    public void whenGeneratedReportJSON() {
        Calendar now = Calendar.getInstance();
        MemStore store = new MemStore();
        Employer worker = new Employer("Petrov", now, now, 200);
        store.add(worker);
        ReportEngineJSON engine = new ReportEngineJSON(store);
        StringBuilder expect = new StringBuilder()
                .append("{")
                .append(System.lineSeparator())
                .append("\"title\": \"Name; Hired; Fired; Salary\",")
                .append(System.lineSeparator())
                .append("\"line\": ")
                .append("\"")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append("\"")
                .append(System.lineSeparator())
                .append("}")
                .append(System.lineSeparator());
        assertEquals(expect.toString(), engine.generate(em -> true));
    }
}
