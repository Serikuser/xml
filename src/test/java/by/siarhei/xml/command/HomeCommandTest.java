package by.siarhei.xml.command;

import by.siarhei.xml.command.impl.HomeCommand;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HomeCommandTest {
    private static final String EXPECTED_PAGE = "/jsp/upload.jsp";
    private static final String WRONG_PAGE = "wrong";
    private HomeCommand back;
    private HttpServletRequest request;
    private String expected;
    private String wrongExpected;

    @BeforeClass
    void setUp() {
        back = new HomeCommand();
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
        //given

        //when
        String actual = back.execute(request);

        //then
        Assert.assertEquals(actual, expected);
    }

    @Test
    void backCommandNegativeTest() throws IOException, ServletException {
        //given

        //when
        String actual = back.execute(request);

        //then
        Assert.assertNotEquals(actual, wrongExpected);
    }
}
