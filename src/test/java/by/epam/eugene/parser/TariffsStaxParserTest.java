package by.epam.eugene.parser;

import by.epam.eugene.entity.Tariff;
import by.epam.eugene.exception.TariffException;
import by.epam.eugene.parser.impl.stax.TariffsStaxParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertThrows;

@Test (groups = "Parser")
public class TariffsStaxParserTest {

    @Test(dataProvider = "fourTariffs", dataProviderClass = XmlParserTestDataProvider.class)
    public void testTariffs(String xmlPathFile, List<Tariff> expected) throws TariffException {
        TariffsStaxParser tariffsStaxParser = new TariffsStaxParser();
        tariffsStaxParser.buildSetTariffs(xmlPathFile);
        List<Tariff> actual = tariffsStaxParser.getTariffs();
        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test(dataProvider = "invalidPathFile", dataProviderClass = XmlParserTestDataProvider.class)
    public void test(String xmlPathFile) {
        TariffsStaxParser tariffsStaxParser = new TariffsStaxParser();
        assertThrows(TariffException.class, () -> tariffsStaxParser.buildSetTariffs(xmlPathFile));
    }
}
