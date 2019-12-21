/*
package by.siarhei.xml.command;

import by.siarhei.xml.command.impl.ParseCommand;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ParseCommandTest {
    private static final String EXPECTED_PAGE = "/jsp/result.jsp";
    public static final String WRONG_PAGE = "wrong";
    private ParseCommand parseCommand;
    private HttpServletRequest request;
    private String expected;
    private String wrongExpected;

    @BeforeClass
    void setUp() {
        request = Mockito.mock(HttpServletRequest.class);
        parseCommand = new ParseCommand();
        expected = EXPECTED_PAGE;
        wrongExpected = WRONG_PAGE;
    }

    @AfterClass
    void setDown() {
        parseCommand = null;
        expected = null;
        wrongExpected = null;
        request = null;
    }

    @Test
    void backCommandPositiveTest() throws IOException, ServletException {
        String actual = parseCommand.execute(request);
        Assert.assertEquals(actual, expected);
    }

    @Test
    void backCommandNegativeTest() throws IOException, ServletException {
        String actual = parseCommand.execute(request);
        Assert.assertNotEquals(actual, wrongExpected);
    }
}
*/
