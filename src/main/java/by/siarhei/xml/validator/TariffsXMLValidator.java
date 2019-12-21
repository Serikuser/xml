package by.siarhei.xml.validator;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class TariffsXMLValidator {
    private static final Logger logger = LogManager.getLogger();

    public boolean validate(String filePath, String schemaPath) throws SAXException {
        boolean isValid = false;
        SchemaFactory factory =
                SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        File schemaLocation = new File(schemaPath);
        Schema schema = factory.newSchema(schemaLocation);
        Validator validator = schema.newValidator();
        validator.setErrorHandler(new TariffErrorHandler());
        Source source = new StreamSource(filePath);
        try {
            validator.validate(source);
            logger.info("file is valid.");
            isValid = true;
        } catch (IOException e) {
            logger.error(String.format("Validator cant read file from path: %s throws exception: %s", filePath, e));
        }
        return isValid;
    }
}
