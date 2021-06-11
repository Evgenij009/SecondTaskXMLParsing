package com.epam.eugene.parser.sax;

import com.epam.eugene.builder.AbstractTariffsBuilder;
import com.epam.eugene.exception.TariffErrorHandler;
import com.epam.eugene.entity.Tariff;
import com.epam.eugene.exception.TariffException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.Set;

public class TariffsSaxBuilder extends AbstractTariffsBuilder {
    private XMLReader reader;
    private TariffHandler handler;

    public TariffsSaxBuilder() {
        SAXParserFactory factory = new SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            reader  = saxParser.getXMLReader();
        } catch (TariffException e) {
            System.err.println(e);
        }
        reader.setErrorHandler(new TariffErrorHandler());
        reader.setContentHandler(handler);
    }

    public TariffsSaxBuilder(Set<Tariff> tariffs) {
        super(tariffs);
    }

    @Override
    public void buildSetTariffs(String filePath) {
        try {
            reader.parse(filePath);
        } catch (TariffException e) {
            System.err.println(e);
        }
        tariffs = handler.getTariffs();
    }
}
