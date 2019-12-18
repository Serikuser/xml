package by.siarhei.xml.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class TariffErrorHandler extends DefaultHandler {

    @Override
    public void warning(SAXParseException exception) throws SAXException {
        handleMessage("Warning", exception);
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        handleMessage("Error", exception);
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        handleMessage("Fatal", exception);
    }

    private String handleMessage(String level, SAXParseException exception) throws SAXException {
        int lineNumber = exception.getLineNumber();
        int columnNumber = exception.getColumnNumber();
        String message = exception.getMessage();
        throw new SAXException(String.format(
                "[%s] line number: %s column number: %s with message: %s", level,lineNumber,columnNumber,message));
    }
}
