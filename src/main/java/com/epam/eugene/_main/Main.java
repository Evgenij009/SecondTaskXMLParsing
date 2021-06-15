package com.epam.eugene._main;

import com.epam.eugene.parser.builder.AbstractTariffsBuilder;
import com.epam.eugene.factory.TariffBuilderFactory;

public class Main {
    public static void main(String... args) {
        String type = "dom";
        AbstractTariffsBuilder builder = TariffBuilderFactory.createStudentBuilder(type);
        builder.buildSetTariffs("data_xml/tariffs.xml");
        System.out.println(builder.getTariffs());
        System.out.println(builder.getTariffs().size());
        //Validation
//        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
//        String fileName = "data_xml/tariffs.xml";
//        String schemaName = "data_xml/tariffs.xsd";
//        SchemaFactory factory = SchemaFactory.newInstance(language);
//        File schemaLocation = new File(schemaName);
//        try {
//            // schema creation
//            Schema schema = factory.newSchema(schemaLocation);
//            // creating a schema-based validator
//            Validator validator = schema.newValidator();
//            Source source = new StreamSource(fileName);
//            // document check
//            validator.setErrorHandler(new TariffErrorHandler());
//            validator.validate(source);
//        } catch (SAXException | IOException e) {
//            System.err.println(fileName + " is not correct or valid\n" + e);
//        }

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
