package com.sax;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;


public class Main {
    public static void main(String[] args) {
        String path = new File("D:/workspace/IBA/ПрилИС/Lab3/SAX/src/com/books.xml").getAbsolutePath();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            BookXMLHandler handler = new BookXMLHandler();
            parser.parse(new File(path), handler);
        } catch (IOException x) {
            System.err.println(x);
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }
}
