package by.siarhei.xml.builder;

import by.siarhei.xml.entity.Tariff;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class TariffBuilderSAX {
    List<Tariff> tariffs;
    private TariffHandler handler;
    private SAXParserFactory factory = SAXParserFactory.newInstance();

    public TariffBuilderSAX() {
        handler = new TariffHandler();
    }

    public List<Tariff> getTariffs() {
        return this.tariffs;
    }

    public void buildSetTariffs(String fileName) {
        try {
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(fileName, handler);
        } catch (SAXException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        tariffs = handler.getTariffs();
    }

    public static void main(String[] args) {
        TariffBuilderSAX saxBuilder = new TariffBuilderSAX();
        saxBuilder.buildSetTariffs("data/tariffs.xml");
        System.out.println(saxBuilder.getTariffs());
    }
}
