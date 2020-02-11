package ru.job4j.array;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

public class ConvertXSQT {

    public void convert(File source, File dest, File scheme) throws IOException, TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(new StreamSource(new FileInputStream(scheme)));
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new StreamSource(new FileInputStream(source)), new StreamResult(dest));
    }
}
