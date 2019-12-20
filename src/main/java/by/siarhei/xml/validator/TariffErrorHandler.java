package by.siarhei.xml.validator;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class TariffErrorHandler extends DefaultHandler {

    private static final String WARNING_LEVEL = "Warning";
    private static final String ERROR_LEVEL = "Error";
    private static final String FATAL_LEVEL = "Fatal";

    @Override
    public void warning(SAXParseException exception) throws SAXException {
        handleMessage(WARNING_LEVEL, exception);
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        handleMessage(ERROR_LEVEL, exception);
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        handleMessage(FATAL_LEVEL, exception);
    }

    private void handleMessage(String level, SAXParseException exception) throws SAXException {
        int lineNumber = exception.getLineNumber();
        int columnNumber = exception.getColumnNumber();
        String message = exception.getMessage();
        throw new SAXException(String.format(
                "[%s] line number: %s column number: %s with message: %s", level,lineNumber,columnNumber,message));
    }
}
