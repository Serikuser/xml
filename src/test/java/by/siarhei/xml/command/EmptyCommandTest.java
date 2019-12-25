package by.siarhei.xml.command;

import by.siarhei.xml.command.impl.EmptyCommand;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class EmptyCommandTest {
    private static final String EXPECTED_PAGE = "/jsp/upload.jsp";
    private static final String WRONG_PAGE = "wrong";
    private EmptyCommand emptyCommand;
    private HttpServletRequest request;
    private String expected;
    private String wrongExpected;

    @BeforeClass
    void setUp() {
        emptyCommand = new EmptyCommand();
        request = Mockito.mock(HttpServletRequest.class);
        expected = EXPECTED_PAGE;
        wrongExpected = WRONG_PAGE;
    }

    @AfterClass
    void setDown() {
        emptyCommand = null;
        expected = null;
        wrongExpected = null;
        request = null;
    }

    @Test
    void backCommandPositiveTest() throws IOException, ServletException {
        //given

        //when
        String actual = emptyCommand.execute(request);

        //then
        Assert.assertEquals(actual, expected);
    }

    @Test
    void backCommandNegativeTest() throws IOException, ServletException {
        //given

        //when
        String actual = emptyCommand.execute(request);

        //then
        Assert.assertNotEquals(actual, wrongExpected);
    }
}
