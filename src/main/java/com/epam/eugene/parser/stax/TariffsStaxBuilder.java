package com.epam.eugene.parser.stax;

import com.epam.eugene.parser.builder.AbstractTariffsBuilder;
import com.epam.eugene.entity.Tariff;

import javax.xml.stream.XMLInputFactory;
import java.util.Set;

public class TariffsStaxBuilder extends AbstractTariffsBuilder {
    private XMLInputFactory inputFactory;

    public TariffsStaxBuilder() {
    }

    public TariffsStaxBuilder(Set<Tariff> tariffs) {
        super(tariffs);
    }

    @Override
    public void buildSetTariffs(String filePath) {

    }

}
