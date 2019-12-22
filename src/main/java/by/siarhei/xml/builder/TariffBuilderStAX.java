package by.siarhei.xml.builder;

import by.siarhei.xml.entity.Tariff;
import by.siarhei.xml.entity.TariffEnum;
import by.siarhei.xml.entity.TariffParameters;
import by.siarhei.xml.entity.TariffPrices;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

public class TariffBuilderStAX extends AbstractTariffBuilder {

    private XMLInputFactory inputFactory;

    public TariffBuilderStAX() {
        tariffs = new LinkedList<>();
        inputFactory = XMLInputFactory.newInstance();
    }

    public void buildTariffs(String fileName) {
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name = "";
        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (TariffEnum.valueOf(name.toUpperCase()) == TariffEnum.TARIFF) {
                        Tariff tariff = buildTariff(reader);
                        tariffs.add(tariff);
                    }
                }
            }
        } catch (XMLStreamException e) {
            logger.error(String.format("StAX parser cant parse file throws exception: %s.", e));
        } catch (FileNotFoundException e) {
            logger.error(String.format("StAX parser cant read file throws exception: %s.", e));
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                logger.error(String.format("StAX parser cant close input stream throws exception: %s.", e));
            }
        }
    }

    public Tariff buildTariff(XMLStreamReader reader) throws XMLStreamException {
        Tariff tariff = new Tariff();
        tariff.setOperator(reader.getAttributeValue(null, TariffEnum.OPERATOR.getValue()));
        tariff.setLaunchDate(reader.getAttributeValue(null, TariffEnum.LAUNCHDATE.getValue()));
        double payroll = Double.parseDouble(
                reader.getAttributeValue(null, TariffEnum.PAYROLL.getValue()));
        tariff.setPayroll(payroll);
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (TariffEnum.valueOf(name.toUpperCase())) {
                        case NAME:
                            tariff.setTariffName(getXMLText(reader));
                            break;
                        case PRICES:
                            tariff.setPrices(buildPrices(reader));
                            break;
                        case PARAMETERS:
                           // tariff.setParameters(buildParameters(reader)); *commented to ignore parameters on building
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (TariffEnum.valueOf(name.toUpperCase()) == TariffEnum.TARIFF) {
                        return tariff;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Tariff");
    }

    public TariffPrices buildPrices(XMLStreamReader reader) throws XMLStreamException {
        TariffPrices prices = new TariffPrices();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (TariffEnum.valueOf(name.toUpperCase())) {
                        case INNERCALL:
                            double innerCall = Double.parseDouble(
                                    getXMLText(reader));
                            prices.setInnerCallPrice(innerCall);
                            break;
                        case EXTERNALCALL:
                            double externalCall = Double.parseDouble(
                                    getXMLText(reader));
                            prices.setExternalCallPrice(externalCall);
                            break;
                        case HOMECALL:
                            double homeCall = Double.parseDouble(
                                    getXMLText(reader));
                            prices.setHomeCallPrice(homeCall);
                            break;
                        case SMS:
                            double smsPrice = Double.parseDouble(getXMLText(reader));
                            prices.setSmsPrice(smsPrice);
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (TariffEnum.valueOf(name.toUpperCase()) == TariffEnum.PRICES) {
                        return prices;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Prices");
    }

    public TariffParameters buildParameters(XMLStreamReader reader) throws XMLStreamException {
        TariffParameters parameters = new TariffParameters();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (TariffEnum.valueOf(name.toUpperCase())) {
                        case ANNYNUMBER:
                            double annyNUmberPrice = Double.parseDouble(
                                    getXMLText(reader));
                            parameters.setAnnyNumberPrice(annyNUmberPrice);
                            break;
                        case CONNECTIONPRICE:
                            double connectionPrice = Double.parseDouble(
                                    getXMLText(reader));
                            parameters.setConnectionPrice(connectionPrice);
                            break;
                        case TARIFFING:
                            String tariffing = getXMLText(reader);
                            if (tariffing != null && !tariffing.isEmpty()) {
                                parameters.setTariffing(tariffing);
                            }
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (TariffEnum.valueOf(name.toUpperCase()) == TariffEnum.PARAMETERS) {
                        return parameters;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Parameters");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
