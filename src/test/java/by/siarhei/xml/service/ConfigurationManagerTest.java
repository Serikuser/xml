package by.siarhei.xml.service;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ConfigurationManagerTest {
    public static final String EXPECTED = "/jsp/result.jsp";
    public static final String EXPECTED_WRONG = "wrong";
    String key;

    @BeforeClass
    void setUp() {
        key = "path.page.result";
    }

    @AfterClass
    void setDown() {
        key = null;
    }

    @Test
    void getResultJspTestPositive() {
        String actual = ConfigurationManager.getProperty(key);
        Assert.assertEquals(actual, EXPECTED);
    }

    @Test
    void getResultJspTestNegative() {
        String actual = ConfigurationManager.getProperty(key);
        Assert.assertNotEquals(actual, EXPECTED_WRONG);
    }
}
