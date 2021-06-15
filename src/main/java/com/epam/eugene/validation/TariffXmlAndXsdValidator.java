package com.epam.eugene.validation;

import com.epam.eugene.exception.TariffErrorHandler;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class TariffXmlAndXsdValidator {
    private static final Logger logger = LogManager.getLogger();

    public static boolean isXmlAndXsdValid(String pathToXmlFile, String pathToXsdSchema) {
        if (!(CustomFileValidator.isFileValid(pathToXmlFile) && CustomFileValidator.isFileValid(pathToXsdSchema))) {
            logger.warn("Path to files (xml or xsd) is invalid.");
            return false;
        }
        boolean answer = false;
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(pathToXsdSchema);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(pathToXmlFile);
            validator.setErrorHandler(new TariffErrorHandler());
            validator.validate(source);
            answer = true;
        } catch (SAXException e) {
            logger.warn("Paths: %s or %s is not correct or valid\n" +pathToXmlFile + pathToXsdSchema + e);
        } catch (IOException e) {
            logger.warn("Validation xml xsd files - error");
        }
        return answer;
    }
}
