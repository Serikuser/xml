package by.siarhei.xml.service;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MessageManagerTest {
    public static final String EXPECTED = "Action is not supported.";
    public static final String EXPECTED_WRONG = "wrong";
    String key;

    @BeforeClass
    void setUp() {
        key = "message.wrongaction";
    }

    @AfterClass
    void setDown() {
        key = null;
    }

    @Test
    void getResultJspTestPositive() {
        String actual = MessageManager.getProperty(key);
        Assert.assertEquals(actual, EXPECTED);
    }

    @Test
    void getResultJspTestNegative() {
        String actual = MessageManager.getProperty(key);
        Assert.assertNotEquals(actual, EXPECTED_WRONG);
    }
}
