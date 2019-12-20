package by.siarhei.xml.builder;

import by.siarhei.xml.entity.Tariff;
import by.siarhei.xml.entity.TariffEnum;
import by.siarhei.xml.entity.TariffParameters;
import by.siarhei.xml.entity.TariffPrices;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.LinkedList;
import java.util.List;

public class TariffHandler extends DefaultHandler {
    private List<Tariff> tariffs;
    private Tariff current = null;
    private TariffEnum currentElement = null;
    private TariffPrices prices;
    private TariffParameters parameters;
    private String content;

    public TariffHandler() {
        tariffs = new LinkedList<>();
    }

    public List<Tariff> getTariffs() {
        return this.tariffs;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentElement = TariffEnum.valueOf(qName.toUpperCase());
        switch (currentElement) {
            case TARIFF:
                current = new Tariff();
                current.setOperator(attributes.getValue(0));
                current.setPayroll(Double.parseDouble(attributes.getValue(1)));
                if (attributes.getLength() == 3) {
                    current.setLaunchDate(attributes.getValue(2));
                }
                break;
            case PRICES:
                prices = new TariffPrices();
                break;
            case PARAMETERS:
                parameters = new TariffParameters();
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        currentElement = TariffEnum.valueOf(qName.toUpperCase());
        switch (currentElement) {
            case NAME:
                current.setTariffName(content);
                break;
            case INNERCALL:
                prices.setInnerCallPrice(Double.parseDouble(content));
                break;
            case EXTERNALCALL:
                prices.setExternalCallPrice(Double.parseDouble(content));
                break;
            case HOMECALL:
                prices.setHomeCallPrice(Double.parseDouble(content));
                break;
            case SMS:
                prices.setSmsPrice(Double.parseDouble(content));
                break;
            case ANNYNUMBER:
                parameters.setAnnyNumberPrice(Double.parseDouble(content));
                break;
            case TARIFFING:
                parameters.setTariffing(content);
                break;
            case CONNECTIONPRICE:
                parameters.setConnectionPrice(Double.parseDouble(content));
                break;
            case TARIFF:
                tariffs.add(current);
                break;
            case PRICES:
                current.setPrices(prices);
                break;
            case PARAMETERS:
                current.setParameters(parameters);
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        this.content = new String(ch, start, length).trim();
    }
}

