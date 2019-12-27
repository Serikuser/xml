package by.siarhei.xml.manager;

import by.siarhei.xml.manager.MessageManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MessageManagerTest {
    public static final String EXPECTED = "File not valid with reason";
    public static final String EXPECTED_WRONG = "wrong";
    String key;

    @BeforeClass
    void setUp() {
        key = "message.file.notvalid";
    }

    @AfterClass
    void setDown() {
        key = null;
    }

    @Test
    void getResultJspTestPositive() {
        //given

        //when
        String actual = MessageManager.getProperty(key);

        //then
        Assert.assertEquals(actual, EXPECTED);
    }

    @Test
    void getResultJspTestNegative() {
        //given

        //when
        String actual = MessageManager.getProperty(key);

        //then
        Assert.assertNotEquals(actual, EXPECTED_WRONG);
    }
}
