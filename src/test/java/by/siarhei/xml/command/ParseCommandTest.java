package by.siarhei.xml.command;

import by.siarhei.xml.command.impl.ParseCommand;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ParseCommandTest {
    private static final String EXPECTED_PAGE = "/jsp/result.jsp";
    private static final String WRONG_PAGE = "wrong";
    private static final String DOM_PARSER = "DOM";
    private ParseCommand parseCommand;
    private String expected;
    private String wrongExpected;
    @Mock
    private HttpServletRequest request;

    @BeforeClass
    void setUp() {
        parseCommand = new ParseCommand();
        expected = EXPECTED_PAGE;
        wrongExpected = WRONG_PAGE;
    }

    @BeforeMethod
    void setUpMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @AfterClass
    void setDown() {
        parseCommand = null;
        expected = null;
        wrongExpected = null;
        request = null;
    }

    @Test
    void parseCommandPositiveTest() throws IOException, ServletException {
        //given
        Mockito.when(request.getParameter(Matchers.anyString())).thenReturn(DOM_PARSER).thenReturn("test.test");

        //when
        String actual = parseCommand.execute(request);

        //then
        Mockito.verify(request, Mockito.times(2)).getParameter(Matchers.anyString());
        Assert.assertEquals(actual, expected);
    }

    @Test
    void parseCommandNegativeTest() throws IOException, ServletException {
        //given
        Mockito.when(request.getParameter(Matchers.anyString())).thenReturn(DOM_PARSER).thenReturn("test.test");

        //when
        String actual = parseCommand.execute(request);

        //then
        Mockito.verify(request, Mockito.times(2)).getParameter(Matchers.anyString());
        Assert.assertNotEquals(actual, wrongExpected);
    }
}
