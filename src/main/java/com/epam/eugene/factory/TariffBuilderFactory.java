package com.epam.eugene.factory;

import com.epam.eugene.parser.builder.AbstractTariffsBuilder;
import com.epam.eugene.parser.builder.TariffsDomBuilder;
import com.epam.eugene.parser.builder.TariffsSaxBuilder;
import com.epam.eugene.parser.stax.TariffsStaxBuilder;

public class TariffBuilderFactory {
    private enum TypeParser {
        SAX, STAX, DOM
    }

    private TariffBuilderFactory() {
    }

    public static AbstractTariffsBuilder createStudentBuilder(String typeParser) {
        // insert parser name validation
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
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