package com.epam.eugene._main;

import com.epam.eugene.builder.TariffsSaxBuilder;
import com.epam.eugene.exception.TariffErrorHandler;
import com.epam.eugene.parser.sax.ConsoleTariffHandler;
import com.epam.eugene.parser.sax.TariffXmlTag;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String... args) {
//        String type = "stax";
//        AbstractTariffsBuilder builder = TariffBuilderFactory.createStudentBuilder(type);
//        builder.buildSetTariffs("data_xml/tariffs.xml");
//        System.out.println(builder.getTariffs());
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

        TariffsSaxBuilder saxBuilder = new TariffsSaxBuilder();
        saxBuilder.buildSetTariffs("data_xml/tariffs.xml");
        System.out.println(saxBuilder.getTariffs());

    }
}
