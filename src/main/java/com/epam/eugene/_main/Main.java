package com.epam.eugene._main;

import com.epam.eugene.builder.AbstractTariffsBuilder;
import com.epam.eugene.factory.TariffBuilderFactory;

public class Main {
    public static void main(String... args) {
        String type = "stax";
        AbstractTariffsBuilder builder = TariffBuilderFactory.createStudentBuilder(type);
        builder.buildSetTariffs("data_xml/tariffs.xml");
        System.out.println(builder.getTariffs());
    }
}
