package com.epam.eugene.parser.builder;

import com.epam.eugene.entity.Tariff;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractTariffsBuilder {
    protected Set<Tariff> tariffs;

    public AbstractTariffsBuilder() {
        tariffs = new HashSet<Tariff>();
    }

    public AbstractTariffsBuilder(Set<Tariff> tariffs) {
        this.tariffs = tariffs;
    }

    public Set<Tariff> getTariffs() {
        return this.tariffs;
    }

    public abstract void buildSetTariffs(String filePath);
}
