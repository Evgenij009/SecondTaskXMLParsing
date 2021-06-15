package com.epam.eugene.parser;

import com.epam.eugene.exception.TariffException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum TariffXmlTag {
    TARIFFS("tariffs"),
    TARIFF("tariff"),
    VENDOR_CODE("vendorCode"),
    LOCAL_DATE("localDate"),
    NAME("name"),
    PAYROLL("payroll"),
    SMS_PRICE("smsPrice"),
    OPERATOR_NAME("operatorName"),
    PRICE_WITHIN_THE_NETWORK("priceWithinTheNetwork"),
    PRICE_OUTSIDE_NETWORK("priceOutsideNetwork"),
    PRICE_LAND_LINE_PHONES("pricelandlinePhones"),
    FEE_CONNECTION("feeConnection"),
    FAVOURITY_NUMBER("favoriteNumber"),
    TARIFFICATION("tariffication"),
    PARAMETERS("parameters"),
    CALL_PRICES("callPrices");

    private String value;

    TariffXmlTag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TariffXmlTag getTag(String line) throws TariffException {
        if (line == null || line.isEmpty()) {
            throw new TariffException("Line tag is null or empty.");
        }
        for (TariffXmlTag tag : TariffXmlTag.values()) {
            if (tag.value.equalsIgnoreCase(line)) {
                return tag;
            }
        }
        return null;
    }
}
