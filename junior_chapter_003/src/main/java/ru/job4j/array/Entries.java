package ru.job4j.array;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Entries {
    private List<Entry> entry;

    public Entries() {
    }

    public Entries(List<Entry> entry) {
        this.entry = entry;
    }

    public List<Entry> getEntry() {
        return entry;
    }

    @XmlElement
    public void setEntry(List<Entry> entry) {
        this.entry = entry;
    }
}
