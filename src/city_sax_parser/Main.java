package city_sax_parser;

import java.io.IOException;

/**
 * Створіть клас, використовуючи SAXParser, де опишіть ієрархію XML файлу.
 * Необхідно, щоб проєкт створював XML-файл і будував дерево (місто, назва вулиці, будинок).
 * У місті використовуйте атрибут (наприклад, <city size=”big>Kiev</city>).
 */

public class Main {
    public static void main(String[] args) {
        final String fileName = "src/city_sax_parser/address.xml";
        try {
            XMLSaveStAX.createXML(fileName); // конвертація у xml за допомогою StAX Parser
            SAXtoConsole.parseXmlSax(fileName); // конвертація з xml за допомогою SAX Parser
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
