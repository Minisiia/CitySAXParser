package city_sax_parser;

import javax.xml.stream.*;
import java.io.*;

public class XMLSaveStAX {
    public static void createXML (String file) throws IOException {
        try {
            XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = outputFactory.createXMLStreamWriter(new FileOutputStream("src/city_sax_parser/address.xml"));
            writer.writeStartDocument("1.0");
            writer.writeStartElement("country");
            writer.writeStartElement("region");
            writer.writeStartElement("city");
            writer.writeAttribute("size","big");
            writer.writeCharacters("Kharkiv");
            writer.writeEndElement();
            writer.writeStartElement("street");
            writer.writeCharacters("Valentinovska");
            writer.writeEndElement();
            writer.writeStartElement("house");
            writer.writeCharacters("10");
            writer.writeEndElement();
            writer.writeEndElement();
            writer.writeStartElement("region");
            writer.writeStartElement("city");
            writer.writeAttribute("size","big");
            writer.writeCharacters("Mukachevo");
            writer.writeEndElement();
            writer.writeStartElement("street");
            writer.writeCharacters("Petrova");
            writer.writeEndElement();
            writer.writeStartElement("house");
            writer.writeCharacters("28");
            writer.writeEndElement();
            writer.writeEndElement();
            writer.writeEndElement();
            writer.writeEndDocument();
            writer.flush();
            writer.close();
        } catch (XMLStreamException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
