package ru.job4j.array;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.util.List;

public class StoreXML {
    private File target;

    public StoreXML(File target) {
        this.target = target;
    }

    public void save(List<Entry> list) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Entries.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        Entries entries = new Entries();
        entries.setEntry(list);
        jaxbMarshaller.marshal(entries, target);
    }
}
