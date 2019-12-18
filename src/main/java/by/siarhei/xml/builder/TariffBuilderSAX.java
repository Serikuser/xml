package by.siarhei.xml.builder;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.LinkedList;

public class TariffBuilderSAX extends AbstractBuilder {

    private TariffHandler handler;
    private SAXParserFactory factory = SAXParserFactory.newInstance();

    public TariffBuilderSAX() {
        tariffs = new LinkedList<>();
        handler = new TariffHandler();
    }

    @Override
    public void buildTariffs(String fileName) {
        try {
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(fileName, handler);
        } catch (SAXException e) {
            logger.error(e);
        } catch (IOException e) {
            logger.error(e);
        } catch (ParserConfigurationException e) {
            logger.error(e);
        }
        tariffs = handler.getTariffs();
    }
}
