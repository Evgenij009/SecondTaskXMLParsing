package com.epam.eugene;

import org.xml.sax.helpers.DefaultHandler;

public class TariffHandler extends DefaultHandler {
    @Override public void startDocument() {
        System.out.println("Parsing started");
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        System.out.print(new String(ch, start, length));
    }
    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.print(" " + qName);
    }
    @Override
    public void endDocument() {
        System.out.println("\nParsing ended");
    }
}

