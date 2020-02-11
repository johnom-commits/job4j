package ru.job4j.array;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class CountFieldFromXML {

    public int count(File file) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        SAXPars saxp = new SAXPars();
        parser.parse(file, saxp);
        return saxp.getResult();
    }

    private class SAXPars extends DefaultHandler {
        private int result = 0;

        private int getResult() {
            return result;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            String field = attributes.getValue("field");
            if (field != null && !field.isEmpty()) {
                result += Integer.parseInt(field);
            }
        }
    }
}
