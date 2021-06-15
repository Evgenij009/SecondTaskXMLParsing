package by.epam.eugene.parser;

import by.epam.eugene.entity.Tariff;
import by.epam.eugene.exception.TariffException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractTariffsBuilder {
    public static Logger logger = LogManager.getLogger();
    public ArrayList tariffs;

    public AbstractTariffsBuilder() {
        tariffs = new ArrayList();
    }

    public AbstractTariffsBuilder(ArrayList tariffs) {
        this.tariffs = tariffs;
    }

    public ArrayList getTariffs() {
        logger.info("Tariffs read are successful, size: " + tariffs.size());
        return this.tariffs;
    }

    public abstract void buildSetTariffs(String filePath) throws TariffException;
}
