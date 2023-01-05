package city_sax_parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SAXtoConsole {
    public static void parseXmlSax(String file) throws RuntimeException {

        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            DefaultHandler handler = new DefaultHandler() {
                boolean country = false;
                boolean region = false;
                boolean city = false;
                boolean street = false;
                boolean house = false;
                String sizeCity = "";

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

                    if (qName.equalsIgnoreCase("country")) {
                        country = true;
                    }
                    if (qName.equalsIgnoreCase("region")) {
                        region = true;
                    }
                    if (qName.equalsIgnoreCase("city")) {
                        sizeCity = attributes.getValue("size");
                        city = true;
                    }
                    if (qName.equalsIgnoreCase("street")) {
                        street = true;
                    }
                    if (qName.equalsIgnoreCase("house")) {
                        house = true;
                    }
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    if (country) {
                        System.out.println("country: ");
                        country = false;
                    }
                    if (region) {
                        System.out.println("region: ");
                        region = false;
                    }
                    if (city) {
                        System.out.println("city: " + new String(ch, start, length) + "\ncity attribute size: " + sizeCity);
                        city = false;
                    }
                    if (street) {
                        System.out.println("street: " + new String(ch, start, length));
                        street = false;
                    }
                    if (house) {
                        System.out.println("house: " + new String(ch, start, length));
                        house = false;
                    }
                }
            };
            saxParser.parse(file, handler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
