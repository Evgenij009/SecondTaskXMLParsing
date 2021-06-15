package com.epam.eugene.parser.builder;

import com.epam.eugene.entity.*;
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
import java.util.HashSet;
import java.util.Set;

public class TariffsDomBuilder extends AbstractTariffsBuilder{
    private DocumentBuilder docBuilder;

    public TariffsDomBuilder() {
        tariffs = new HashSet<Tariff>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void buildSetTariffs(String filePath) {
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
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private Tariff buildTariff(Element tariffElement) {
        Tariff tariff = new Tariff();
        //add null check
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
