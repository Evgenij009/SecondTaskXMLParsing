package com.epam.eugene._main;

import com.epam.eugene.exception.TariffException;
import com.epam.eugene.parser.builder.AbstractTariffsBuilder;
import com.epam.eugene.factory.TariffBuilderFactory;

public class Main {
    public static void main(String... args) throws TariffException {
        String type = "dom";
        AbstractTariffsBuilder builder = TariffBuilderFactory.createTariffBuilder(type);
        builder.buildSetTariffs("data_xml/tariffs.xml");
        System.out.println(builder.getTariffs());
        System.out.println(builder.getTariffs().hashCode());

//        try {
//            // SAX parser creating & configuring
//            SAXParserFactory factory = SAXParserFactory.newInstance();
//            SAXParser parser = factory.newSAXParser();
//            XMLReader reader = parser.getXMLReader();
//            reader.setContentHandler(new ConsoleTariffHandler());
//            reader.setErrorHandler(new TariffErrorHandler());
//            reader.parse("data_xml/tariffs.xml");
//        } catch (SAXException | IOException | ParserConfigurationException e) {
//            e.printStackTrace();
//        }

//        TariffsSaxBuilder saxBuilder = new TariffsSaxBuilder();
//        saxBuilder.buildSetTariffs("data_xml/tariffs.xml");
//        System.out.println(saxBuilder.getTariffs());

    }
}
