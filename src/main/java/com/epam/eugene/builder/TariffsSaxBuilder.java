package com.epam.eugene.builder;

import com.epam.eugene.TariffHandler;
import com.epam.eugene.builder.AbstractTariffsBuilder;
import com.epam.eugene.entity.Tariff;
import org.xml.sax.XMLReader;

import java.util.Set;

public class TariffsSaxBuilder extends AbstractTariffsBuilder {
    private TariffHandler handler;
    private XMLReader reader;

    public TariffsSaxBuilder() {
    }

    public TariffsSaxBuilder(Set<Tariff> tariffs) {
        super(tariffs);
    }

    @Override
    public void buildSetTariffs(String filePath) {

    }
}
