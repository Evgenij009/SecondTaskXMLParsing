package com.epam.eugene.parser.builder;

import com.epam.eugene.entity.Tariff;
import com.epam.eugene.exception.TariffErrorHandler;
import com.epam.eugene.parser.sax.TariffHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Set;

public class TariffsSaxBuilder extends AbstractTariffsBuilder {
    private XMLReader reader;
    private TariffHandler handler = new TariffHandler();

    public TariffsSaxBuilder() {
        //reader configuration
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            reader  = saxParser.getXMLReader();
        } catch (SAXException | ParserConfigurationException e) {
            System.err.println(e);
        }
        reader.setErrorHandler(new TariffErrorHandler());
        reader.setContentHandler(handler);
    }

    public TariffsSaxBuilder(Set<Tariff> tariffs) {
        super(tariffs);
    }

    public void buildSetTariffs(String filePath) {
        try {
            reader.parse(filePath);
        } catch (IOException | SAXException e) {
            System.err.println(e);
        }
        tariffs = handler.getTariffs();
    }
}
