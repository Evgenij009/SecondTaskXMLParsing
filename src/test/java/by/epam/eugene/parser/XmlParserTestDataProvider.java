package by.epam.eugene.parser;

import by.epam.eugene.entity.*;
import org.testng.annotations.DataProvider;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class XmlParserTestDataProvider {
    private static final String INCORRECT_XML_FILE_PATH = "src/test/resources/test_data/tariffsInvalid.xml";
    private static final String CORRECT_XML_FILE_PATH = "src/test/resources/test_data/tariffsValid.xml";
    private static final  String XSD_FILE_PATH = "src/main/resources/data_xml/tariffs.xsd";
    private static final String NOT_EXISTING_FILE_PATH = "garbage.xml";
    private static final Tariff FIRST_TARIFF = new Tariff("SuperMax10", "AB0001", LocalDate.parse("2018-06-09"), 15.9F, 0.03F, OperatorName.MTS,
            new CallPrices(0.14F, 0.21F, 0.09F), new Parameters(0.5F, 253234321, Tariffication.MINUTE));
    private static final Tariff SECOND_TARIFF = new Tariff("SuperMax50", "AB0002", LocalDate.parse("2020-06-09"), 25.5F, 0.03F, OperatorName.MTS,
            new CallPrices(0.07F, 0.1F, 0.09F), new Parameters(0.5F, 253234321, Tariffication.MINUTE));
    private static final Tariff THIRD_TARIFF = new Tariff("SuperMax25", "AB0003", LocalDate.parse("2020-06-09"), 18.2F, 0.03F, OperatorName.MTS,
            new CallPrices(0.07F, 0.1F, 0.09F), new Parameters(0.5F, 253234321, Tariffication.MINUTE));
    private static final Tariff FOURTH_TARIFF = new Tariff("SuperMax50", "AB0004", LocalDate.parse("2020-06-09"), 25.5F, 0.03F, OperatorName.MTS,
            new CallPrices(0.07F, 0.1F, 0.09F), new Parameters(0.5F, 253234321, Tariffication.MINUTE));

    private static final List<Tariff> TARIFFS = new ArrayList<>
                    (Arrays.asList(FIRST_TARIFF, SECOND_TARIFF, THIRD_TARIFF, FOURTH_TARIFF));

    @DataProvider(name = "fourTariffs")
    public static Object[][] dataProviderParseXmlFile() {
        return new Object[][] {
                {CORRECT_XML_FILE_PATH, TARIFFS}
        };
    }

    @DataProvider(name = "invalidPathFile")
    public static Object[][] dataProviderParseInvalidXmlFile() {
        return new Object[][] {
                {INCORRECT_XML_FILE_PATH}, {NOT_EXISTING_FILE_PATH}
        };
    }
}
