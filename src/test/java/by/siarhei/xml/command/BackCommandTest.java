package by.siarhei.xml.command;

import by.siarhei.xml.command.impl.BackCommand;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class BackCommandTest {
    private static final String EXPECTED_PAGE = "/jsp/upload.jsp";
    public static final String WRONG_PAGE = "wrong";
    private BackCommand back;
    private HttpServletRequest request;
    private String expected;
    private String wrongExpected;

    @BeforeClass
    void setUp() {
        back = new BackCommand();
        request = Mockito.mock(HttpServletRequest.class);
        expected = EXPECTED_PAGE;
        wrongExpected = WRONG_PAGE;
    }

    @AfterClass
    void setDown() {
        back = null;
        expected = null;
        wrongExpected = null;
        request = null;
    }

    @Test
    void backCommandPositiveTest() throws IOException, ServletException {
        String actual = back.execute(request);
        Assert.assertEquals(actual, expected);
    }

    @Test
    void backCommandNegativeTest() throws IOException, ServletException {
        String actual = back.execute(request);
        Assert.assertNotEquals(actual, wrongExpected);
    }
}
