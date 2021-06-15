package by.epam.eugene.parser;

import by.epam.eugene.entity.Tariff;
import by.epam.eugene.exception.TariffException;
import by.epam.eugene.parser.impl.dom.TariffsDomParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertThrows;

@Test (groups = "Parser")
public class TariffsDomParserTest {

    @Test(dataProvider = "dataProvider", dataProviderClass = XmlParserTestDataProvider.class)
    public void testTariffs(String xmlPathFile, List<Tariff> expected) throws TariffException {
        TariffsDomParser tariffsDomParser = new TariffsDomParser();
        tariffsDomParser.buildSetTariffs(xmlPathFile);
        List<Tariff> actual = tariffsDomParser.getTariffs();
        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test(dataProvider = "dataProvider_pathFiles", dataProviderClass = XmlParserTestDataProvider.class)
    public void test(String xmlPathFile) {
        TariffsDomParser tariffsDomParser = new TariffsDomParser();
        assertThrows(TariffException.class, () -> tariffsDomParser.buildSetTariffs(xmlPathFile));
    }
}