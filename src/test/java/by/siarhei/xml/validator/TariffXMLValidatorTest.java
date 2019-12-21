package by.siarhei.xml.validator;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

public class TariffXMLValidatorTest {
    private TariffsXMLValidator validator;
    private String invalidFilePath;
    private String validFilePath;
    private String schemePath;

    @BeforeClass
    void setUp() {
        validator = new TariffsXMLValidator();
        validFilePath = "target\\test-classes\\valid.xml";
        invalidFilePath = "target\\test-classes\\invalid.xml";
        schemePath = "target\\test-classes\\test.xsd";
    }

    @AfterClass
    void setDown() {
        validator = null;
        validFilePath = null;
        invalidFilePath = null;
        schemePath = null;
    }

    @Test
    void validationPositiveTest() throws SAXException {
        boolean result = validator.validate(validFilePath, schemePath);
        Assert.assertTrue(result);
    }

    @Test(expectedExceptions = SAXException.class)
    void validationNegativeTest() throws SAXException {
        boolean result = validator.validate(invalidFilePath, schemePath);
    }
}
