package com.epam.eugene.builder;

import com.epam.eugene.builder.AbstractTariffsBuilder;
import com.epam.eugene.entity.Tariff;

import javax.xml.parsers.DocumentBuilder;
import java.util.Set;

public class TariffsDomBuilder extends AbstractTariffsBuilder {
    private DocumentBuilder documentBuilder;

    public TariffsDomBuilder() {
    }

    public TariffsDomBuilder(Set<Tariff> tariffs) {
        super(tariffs);
    }

    @Override
    public void buildSetTariffs(String filePath) {

    }
}
