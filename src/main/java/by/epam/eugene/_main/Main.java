package by.epam.eugene._main;

import by.epam.eugene.exception.TariffException;
import by.epam.eugene.parser.factory.TariffParserFactory;
import by.epam.eugene.parser.AbstractTariffsBuilder;
import by.epam.eugene.validation.XmlValidator;

public class Main {
    public static void main(String... args) throws TariffException {
        String type = "stax";
        System.out.println(XmlValidator.isValid("src/main/resources/data_xml/tariffs.xml", "src/main/resources/data_xml/tariffs.xsd"));
        AbstractTariffsBuilder builder = TariffParserFactory.createTariffBuilder(type);
        builder.buildSetTariffs("src/main/resources/data_xml/tariffs.xml");
        System.out.println(builder.getTariffs());

    }
}
