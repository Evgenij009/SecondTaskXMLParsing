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
    private static final String MESSAGE_ERROR = "Type parser is invalid";

    private enum TypeParser {
        SAX, STAX, DOM
    }

    private TariffBuilderFactory() {
    }

    public static AbstractTariffsBuilder createTariffBuilder(String typeParser)  {
        TypeParser type = null;
        try {
            if (typeParser == null || typeParser.isEmpty()) {
                logger.error(MESSAGE_ERROR);
                throw new TariffException(MESSAGE_ERROR);
            }
            type = TypeParser.valueOf(typeParser.toUpperCase());
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
        } catch (TariffException e) {
            logger.error("Create tariff builder: " + e);
        }
        return null;
    }
}