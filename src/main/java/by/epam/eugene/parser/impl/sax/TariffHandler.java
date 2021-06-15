package by.epam.eugene.parser.impl.sax;

import by.epam.eugene.entity.OperatorName;
import by.epam.eugene.entity.Tariff;
import by.epam.eugene.entity.Tariffication;
import by.epam.eugene.exception.TariffException;
import by.epam.eugene.parser.TariffXmlTag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class TariffHandler extends DefaultHandler {
    private static Logger logger = LogManager.getLogger();
    private ArrayList tariffs;
    private Tariff current;
    private TariffXmlTag currentXmlTag;
    private EnumSet<TariffXmlTag> withText;
    private static final String ELEMENT_TARIFF = "tariff";

    public TariffHandler() {
        tariffs = new ArrayList();
        withText = EnumSet.range(TariffXmlTag.NAME, TariffXmlTag.TARIFFICATION);
    }

    public ArrayList getTariffs() {
        return tariffs;
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if (ELEMENT_TARIFF.equals(qName)) {
            current = new Tariff();
            current.setVendorCode(attrs.getValue(0));
            LocalDate localDate = LocalDate.parse(attrs.getValue(1));
            current.setLocalDate(localDate);
        } else {
            TariffXmlTag temp = null;
            try {
                temp = TariffXmlTag.getTag(qName);
            } catch (TariffException e) {
                logger.error("Line tag is null or empty.");
            }
            if (withText.contains(temp)) {
                currentXmlTag = temp;
            }
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if (ELEMENT_TARIFF.equals(qName)) {
            tariffs.add(current);
        }
    }

    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length).strip();
        if (currentXmlTag!= null) {
            switch (currentXmlTag) {
                case NAME -> current.setName(data);
                case PAYROLL -> current.setPayroll(Float.parseFloat(data));
                case SMS_PRICE -> current.setSmsPrice(Float.parseFloat(data));
                case OPERATOR_NAME -> current.setOperatorName(OperatorName.valueOf(data));
                case PRICE_WITHIN_THE_NETWORK -> current.getCallPrices().setPriceWithinTheNetwork(Float.parseFloat(data));
                case PRICE_OUTSIDE_NETWORK -> current.getCallPrices().setPriceOutsideNetwork(Float.parseFloat(data));
                case PRICE_LAND_LINE_PHONES -> current.getCallPrices().setPricelandlinePhones(Float.parseFloat(data));
                case FEE_CONNECTION -> current.getParameters().setFeeConnection(Float.parseFloat(data));
                case FAVOURITY_NUMBER -> current.getParameters().setFavoriteNumber(Integer.parseInt(data));
                case TARIFFICATION -> current.getParameters().setTariffication(Tariffication.valueOf(data));
                default -> throw new EnumConstantNotPresentException(
                        currentXmlTag.getDeclaringClass(), currentXmlTag.name());
            }
        }
        currentXmlTag = null;
    }

}
