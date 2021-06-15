package com.epam.eugene.parser.sax;

public enum TariffXmlTag {
    TARIFFS("tariffs"),
    VENDOR_CODE("vendorCode"),
    LOCAL_DATE("localDate"),
    NAME("name"),
    PAYROLL("payroll"),
    SMS_PRICE("smsPrice"),
    OPERATOR_NAME("operatorName"),
    PRICE_WITHIN_THE_NETWORK("priceWithinTheNetwork"),
    PRICE_OUTSIDE_NETWORK("priceOutsideNetwork"),
    PRICE_LAND_LINE_PHONES("priceOutsideNetwork"),
    FEE_CONNECTION("feeConnection"),
    FAVOURITY_NUMBER("favoriteNumber"),
    TARIFFICATION("tariffication"),
    PRAMETERS("parameters"),
    CALL_PRICES("callPrices");

    private String value;

    TariffXmlTag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TariffXmlTag getTag(String line) {
        for (TariffXmlTag tag : TariffXmlTag.values()) {
            if (tag.value.equalsIgnoreCase(line)) {
                return tag;
            }
        }
        return null;
    }
}
