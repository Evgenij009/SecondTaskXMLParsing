package by.epam.eugene.parser.impl.sax;

import by.epam.eugene.parser.AbstractTariffsBuilder;
import by.epam.eugene.validation.CustomFileValidator;
import by.epam.eugene.entity.Tariff;
import by.epam.eugene.exception.TariffErrorHandler;
import by.epam.eugene.exception.TariffException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

public class TariffsSaxParser extends AbstractTariffsBuilder {
    private XMLReader reader;
    private TariffHandler handler = new TariffHandler();

    public TariffsSaxParser() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            reader  = saxParser.getXMLReader();
        } catch (SAXException | ParserConfigurationException e) {
            logger.fatal("Initial config: " + e);
        }
        reader.setErrorHandler(new TariffErrorHandler());
        reader.setContentHandler(handler);
    }

    public TariffsSaxParser(ArrayList tariffs) {
        super(tariffs);
    }

    public void buildSetTariffs(String filePath) throws TariffException {
        if (!CustomFileValidator.isFileValid(filePath)) {
            logger.error("file invalid: " + filePath);
            throw new TariffException("file invalid: " + filePath);
        }
        try {
            reader.parse(filePath);
        } catch (NullPointerException e) {
            logger.fatal("Null pointer: " + e);
            throw new TariffException("Build tariffs: " + e);
        } catch (IOException | SAXException e) {
            logger.fatal("Build tariffs: " + e);
            throw new TariffException("Build tariffs: " + e);
        }
        tariffs = handler.getTariffs();
    }
}
