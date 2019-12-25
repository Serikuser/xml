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
        //given

        //when
        String actual = ConfigurationManager.getProperty(key);

        //then
        Assert.assertEquals(actual, EXPECTED);
    }

    @Test
    void getResultJspTestNegative() {
        //given

        //when
        String actual = ConfigurationManager.getProperty(key);

        //then
        Assert.assertNotEquals(actual, EXPECTED_WRONG);
    }
}
