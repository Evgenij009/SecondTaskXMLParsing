package by.epam.eugene.parser.impl.stax;

import by.epam.eugene.entity.*;
import by.epam.eugene.exception.TariffException;
import by.epam.eugene.parser.TariffXmlTag;
import by.epam.eugene.parser.AbstractTariffsBuilder;
import by.epam.eugene.validation.CustomFileValidator;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TariffsStaxParser extends AbstractTariffsBuilder {
    private XMLInputFactory inputFactory;

    public TariffsStaxParser() {
        inputFactory = XMLInputFactory.newFactory();
        tariffs = new ArrayList();
    }

    public TariffsStaxParser(ArrayList tariffs) {
        super(tariffs);
    }

    @Override
    public void buildSetTariffs(String filePath) throws TariffException {
        if (!CustomFileValidator.isFileValid(filePath)) {
            logger.error("file invalid: " + filePath);
            throw new TariffException("file invalid: " + filePath);
        }
        XMLStreamReader reader;
        String name;
        try (FileInputStream inputStream = new FileInputStream(new File(filePath))) {
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (name.equals(TariffXmlTag.TARIFF.getValue())) {
                        Tariff tariff = buildTariff(reader);
                        tariffs.add(tariff);
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            logger.error("Build Tariffs: " + e);
            throw new TariffException("Build Tariffs: " + e);
        } catch (IOException e) {
            logger.error("Build Tariffs: " + e);
            throw new TariffException("Build Tariffs: " + e);
        }
    }

    private Tariff buildTariff(XMLStreamReader reader) throws TariffException, XMLStreamException {
        Tariff tariff = new Tariff();
        tariff.setVendorCode(reader.getAttributeValue(null, TariffXmlTag.VENDOR_CODE.getValue()));
        LocalDate localDate = LocalDate.parse(reader.getAttributeValue(null, TariffXmlTag.LOCAL_DATE.getValue()));
        tariff.setLocalDate(localDate);

        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (TariffXmlTag.getTag(name)) {
                        case NAME -> tariff.setName(getXMLText(reader));
                        case PAYROLL -> tariff.setPayroll(Float.parseFloat(getXMLText(reader)));
                        case SMS_PRICE -> tariff.setSmsPrice(Float.parseFloat(getXMLText(reader)));
                        case OPERATOR_NAME -> tariff.setOperatorName(OperatorName.valueOf(getXMLText(reader)));
                        case CALL_PRICES -> tariff.setCallPrices(getXMLCallPrices(reader));
                        case PARAMETERS -> tariff.setParameters(getXMLParameters(reader));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (TariffXmlTag.getTag(name) == TariffXmlTag.TARIFF) {
                        return tariff;
                    }
            }
        }
        logger.warn("Unknow element in tag <Tariff>");
        throw new TariffException("Unknow element in tag <Tariff>");
    }

    private CallPrices getXMLCallPrices(XMLStreamReader reader) throws XMLStreamException, TariffException {
        CallPrices callPrices = new CallPrices();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (TariffXmlTag.getTag(name)) {
                        case PRICE_WITHIN_THE_NETWORK -> callPrices.setPriceWithinTheNetwork(Float.parseFloat(getXMLText(reader)));
                        case PRICE_OUTSIDE_NETWORK -> callPrices.setPriceOutsideNetwork(Float.parseFloat(getXMLText(reader)));
                        case PRICE_LAND_LINE_PHONES -> callPrices.setPricelandlinePhones(Float.parseFloat(getXMLText(reader)));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (TariffXmlTag.getTag(name) == TariffXmlTag.CALL_PRICES) {
                        return callPrices;
                    }
            }
        }
        logger.warn("Unknown element in tag <callPrices>");
        throw new TariffException("Unknown element in tag <callPrices>");
    }

    private Parameters getXMLParameters(XMLStreamReader reader) throws XMLStreamException, TariffException {
        Parameters parameters = new Parameters();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (TariffXmlTag.getTag(name)) {
                        case FEE_CONNECTION -> parameters.setFeeConnection(Float.parseFloat(getXMLText(reader)));
                        case FAVOURITY_NUMBER -> parameters.setFavoriteNumber(Integer.parseInt(getXMLText(reader)));
                        case TARIFFICATION -> parameters.setTariffication(Tariffication.valueOf(getXMLText(reader)));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (TariffXmlTag.getTag(name) == TariffXmlTag.PARAMETERS) {
                        return parameters;
                    }
            }
        }
        logger.warn("Unknown element in tag <parameters>");
        throw new XMLStreamException("Unknown element in tag <parameters>");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
