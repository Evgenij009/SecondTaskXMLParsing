package com.epam.eugene.factory;

import com.epam.eugene.exception.TariffException;
import com.epam.eugene.parser.builder.AbstractTariffsBuilder;
import com.epam.eugene.parser.builder.TariffsDomBuilder;
import com.epam.eugene.parser.builder.TariffsSaxBuilder;
import com.epam.eugene.parser.builder.TariffsStaxBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TariffBuilderFactory {
    private static Logger logger = LogManager.getLogger();
    private static final String MESSAGE_ERROR_TYPE_PARSER = "Type parser is invalid";

    private enum TypeParser {
        SAX, STAX, DOM
    }

    private TariffBuilderFactory() {
    }

    public static AbstractTariffsBuilder createTariffBuilder(String typeParser) throws TariffException {
        if (typeParser == null || typeParser.isEmpty()) {
            logger.error(MESSAGE_ERROR_TYPE_PARSER);
            throw new TariffException(MESSAGE_ERROR_TYPE_PARSER);
        }
        TypeParser type = null;
        try {
            type = TypeParser.valueOf(typeParser.toUpperCase());
        } catch (IllegalArgumentException e) {
            logger.error("Create tariff builder: " + e);
            throw new TariffException(MESSAGE_ERROR_TYPE_PARSER);
        }
        switch (type) {
            case DOM -> {
                return new TariffsDomBuilder();
            }
            case STAX -> {
                return new TariffsStaxBuilder();
            }
            case SAX -> {
                return new TariffsSaxBuilder();
            }
            default -> throw new EnumConstantNotPresentException(
                    type.getDeclaringClass(), type.name());
        }
    }
}