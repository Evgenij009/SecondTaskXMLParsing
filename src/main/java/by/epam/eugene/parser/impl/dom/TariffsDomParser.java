package by.epam.eugene.parser.impl.dom;

import by.epam.eugene.entity.*;
import by.epam.eugene.exception.TariffException;
import by.epam.eugene.parser.AbstractTariffsBuilder;
import by.epam.eugene.validation.CustomFileValidator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

public class TariffsDomParser extends AbstractTariffsBuilder {
    private DocumentBuilder docBuilder;

    public TariffsDomParser() {
        tariffs = new ArrayList();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.fatal("Initial config: " + e);
        }
    }

    public void buildSetTariffs(String filePath) throws TariffException {
        if (!CustomFileValidator.isFileValid(filePath)) {
            logger.fatal("File invalid: " + filePath);
            throw new TariffException("File invalid: " + filePath);
        }
        Document doc;
        try {
            doc = docBuilder.parse(filePath);
            Element root = doc.getDocumentElement();
            NodeList tariffsList = root.getElementsByTagName("tariff");
            for (int i = 0; i < tariffsList.getLength(); ++i) {
                Element tariffElement = (Element) tariffsList.item(i);
                Tariff tariff = buildTariff(tariffElement);
                tariffs.add(tariff);
            }

        } catch (IllegalArgumentException e) {
          logger.error("Illegal argument " + e);
            throw new TariffException("Illegal argument " + e);
        } catch (IOException | SAXException e) {
            logger.error("Build tariffs: " + e);
            throw new TariffException("Build tariffs: " + e);
        }
    }

    private Tariff buildTariff(Element tariffElement) throws TariffException {
        if (tariffElement == null) {
            logger.error("Tariff element is NULL!");
            throw new TariffException("Tariff element is NULL!");
        }
        Tariff tariff = new Tariff();

        tariff.setVendorCode(tariffElement.getAttribute("vendorCode"));
        LocalDate localDate = LocalDate.parse(tariffElement.getAttribute("localDate"));
        tariff.setLocalDate(localDate);

        tariff.setName(getElementTextContent(tariffElement, "name"));
        Float payroll = Float.parseFloat(getElementTextContent(tariffElement, "payroll"));
        tariff.setPayroll(payroll);
        Float smsPrice = Float.parseFloat(getElementTextContent(tariffElement, "smsPrice"));
        tariff.setSmsPrice(smsPrice);
        OperatorName operatorName = OperatorName.valueOf(getElementTextContent(tariffElement, "operatorName"));
        tariff.setOperatorName(operatorName);

        CallPrices callPrices = tariff.getCallPrices();
        Element callPricesElement = (Element) tariffElement.getElementsByTagName("callPrices").item(0);
        callPrices.setPriceWithinTheNetwork(Float.parseFloat(getElementTextContent(callPricesElement, "priceWithinTheNetwork")));
        callPrices.setPriceOutsideNetwork(Float.parseFloat(getElementTextContent(callPricesElement, "priceOutsideNetwork")));
        callPrices.setPricelandlinePhones(Float.parseFloat(getElementTextContent(callPricesElement, "pricelandlinePhones")));

        Parameters parameters = tariff.getParameters();
        Element parametersElement = (Element) tariffElement.getElementsByTagName("parameters").item(0);
        parameters.setFeeConnection(Float.parseFloat(getElementTextContent(parametersElement, "feeConnection")));
        parameters.setFavoriteNumber(Integer.parseInt(getElementTextContent(parametersElement, "favoriteNumber")));
        Tariffication tariffication = Tariffication.valueOf(getElementTextContent(parametersElement, "tariffication"));
        parameters.setTariffication(tariffication);

        return tariff;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
