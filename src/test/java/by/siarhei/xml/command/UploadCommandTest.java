package by.siarhei.xml.command;

import by.siarhei.xml.command.impl.UploadCommand;
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
import javax.servlet.http.Part;
import java.io.IOException;

public class UploadCommandTest {
    private static final String EXPECTED_PAGE = "/jsp/upload_res.jsp";
    private static final String WRONG_PAGE = "wrong";
    private static final String TEST_FILE_NAME = "test.test";
    private String expected;
    private String wrongExpected;
    private UploadCommand uploadCommand;
    @Mock
    private HttpServletRequest request;
    @Mock
    private Part part;

    @BeforeClass
    void setUp() {
        uploadCommand = new UploadCommand();
        expected = EXPECTED_PAGE;
        wrongExpected = WRONG_PAGE;
    }

    @BeforeMethod
    void setUpMocks(){
        MockitoAnnotations.initMocks(this);
    }

    @AfterClass
    void setDown() {
        uploadCommand = null;
        expected = null;
        wrongExpected = null;
        request = null;
        part = null;
    }

    @Test
    void uploadCommandPositiveTest() throws IOException, ServletException {
        //given
        Mockito.when(request.getPart(Matchers.anyString())).thenReturn(part);
        Mockito.when(part.getSubmittedFileName()).thenReturn(TEST_FILE_NAME);

        //when
        String actual = uploadCommand.execute(request);

        //then
        Mockito.verify(request).getPart(Matchers.anyString());
        Mockito.verify(part).getSubmittedFileName();
        Assert.assertEquals(actual, expected);
    }

    @Test
    void uploadCommandNegativeTest() throws IOException, ServletException {
        //given
        Mockito.when(request.getPart(Matchers.anyString())).thenReturn(part);
        Mockito.when(part.getSubmittedFileName()).thenReturn(TEST_FILE_NAME);

        //when
        String actual = uploadCommand.execute(request);

        //then
        Mockito.verify(request).getPart(Matchers.anyString());
        Mockito.verify(part).getSubmittedFileName();
        Assert.assertNotEquals(actual, wrongExpected);
    }
}
