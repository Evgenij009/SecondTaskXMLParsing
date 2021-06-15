package com.epam.eugene.parser.sax;

import com.epam.eugene.entity.OperatorName;
import com.epam.eugene.entity.Tariff;
import com.epam.eugene.entity.Tariffication;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDate;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class TariffHandler extends DefaultHandler {
    private Set<Tariff> tariffs;
    private Tariff current;
    private TariffXmlTag currentXmlTag;
    private EnumSet<TariffXmlTag> withText;
    private static final String ELEMENT_TARIFF = "tariff";

    public TariffHandler() {
        tariffs = new HashSet<Tariff>();
        withText = EnumSet.range(TariffXmlTag.NAME, TariffXmlTag.TARIFFICATION);
    }

    public Set<Tariff> getTariffs() {
        return tariffs;
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if (ELEMENT_TARIFF.equals(qName)) {
            current = new Tariff();
            current.setVendorCode(attrs.getValue(0));
            LocalDate localDate = LocalDate.parse(attrs.getValue(1));
            current.setLocalDate(localDate);
        } else {
            TariffXmlTag temp = TariffXmlTag.getTag(qName);
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
