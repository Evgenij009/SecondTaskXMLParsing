package com.epam.eugene.parser.builder;

import com.epam.eugene.entity.Tariff;
import com.epam.eugene.exception.TariffException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractTariffsBuilder {
    public static Logger logger = LogManager.getLogger();
    public Set<Tariff> tariffs;

    public AbstractTariffsBuilder() {
        tariffs = new HashSet<Tariff>();
    }

    public AbstractTariffsBuilder(Set<Tariff> tariffs) {
        this.tariffs = tariffs;
    }

    public Set<Tariff> getTariffs() {
        logger.info("Tariffs read are successful, size: " + tariffs.size());
        return this.tariffs;
    }

    public abstract void buildSetTariffs(String filePath) throws TariffException;
}
