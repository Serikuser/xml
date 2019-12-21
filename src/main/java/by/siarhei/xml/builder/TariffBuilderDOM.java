package by.siarhei.xml.builder;

import by.siarhei.xml.entity.Tariff;
import by.siarhei.xml.entity.TariffEnum;
import by.siarhei.xml.entity.TariffParameters;
import by.siarhei.xml.entity.TariffPrices;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.LinkedList;

public class TariffBuilderDOM extends AbstractTariffBuilder {

    private DocumentBuilder documentBuilder;

    public TariffBuilderDOM() {
        tariffs = new LinkedList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.error(String.format("DOM parser cant configure throws exception: %s.", e));
        }
    }

    @Override
    public void buildTariffs(String fileName) {
        Document document = null;
        try {
            document = documentBuilder.parse(fileName);
            Element root = document.getDocumentElement();
            NodeList tariffList = root.getElementsByTagName(TariffEnum.TARIFF.getValue());
            for (int i = 0; i < tariffList.getLength(); i++) {
                Element tarriffElement = (Element) tariffList.item(i);
                Tariff tariff = buildTariff(tarriffElement);
                tariffs.add(tariff);
            }
        } catch (IOException e) {
            logger.error(String.format("DOM parser cant read file throws exception: %s.", e));
        } catch (SAXException e) {
            logger.error(String.format("DOM parser cant parse file throws exception: %s.", e));
        }
    }

    private TariffPrices buildPrices(Element tarriffElement) {
        TariffPrices prices = new TariffPrices();
        Element pricesElement = (Element) tarriffElement.getElementsByTagName(
                TariffEnum.PRICES.getValue()).item(0);
        double externalCall = Double.parseDouble(
                getElementTextContent(pricesElement, TariffEnum.EXTERNALCALL.getValue()));
        prices.setExternalCallPrice(externalCall);
        double innerCall = Double.parseDouble(
                getElementTextContent(pricesElement, TariffEnum.INNERCALL.getValue()));
        prices.setInnerCallPrice(innerCall);
        double homeCall = Double.parseDouble(
                getElementTextContent(pricesElement, TariffEnum.HOMECALL.getValue()));
        prices.setHomeCallPrice(homeCall);
        double smsPrice = Double.parseDouble(
                getElementTextContent(pricesElement, TariffEnum.SMS.getValue()));
        prices.setSmsPrice(smsPrice);
        return prices;
    }

    private TariffParameters buildParameters(Element tarriffElement) {
        TariffParameters parameters = new TariffParameters();
        Element parameteresElement = (Element) tarriffElement.getElementsByTagName(
                TariffEnum.PARAMETERS.getValue()).item(0);
        double annyNumberPrice = Double.parseDouble(
                getElementTextContent(parameteresElement, TariffEnum.ANNYNUMBER.getValue()));
        parameters.setAnnyNumberPrice(annyNumberPrice);
        double connectionPrice = Double.parseDouble(
                getElementTextContent(parameteresElement, TariffEnum.CONNECTIONPRICE.getValue()));
        parameters.setConnectionPrice(connectionPrice);
        String tariffing = getElementTextContent(parameteresElement, TariffEnum.TARIFFING.getValue());
        if (tariffing != null && !tariffing.isEmpty()) {
            parameters.setTariffing(tariffing);
        }
        return parameters;
    }

    private Tariff buildTariff(Element tarriffElement) {
        Tariff tariff = new Tariff();
        tariff.setOperator(tarriffElement.getAttribute(TariffEnum.OPERATOR.getValue()));
        double payroll = Double.parseDouble(
                tarriffElement.getAttribute(TariffEnum.PAYROLL.getValue()));
        tariff.setLaunchDate(tarriffElement.getAttribute(TariffEnum.LAUNCHDATE.getValue()));
        tariff.setPayroll(payroll);
        tariff.setTariffName(getElementTextContent(tarriffElement, TariffEnum.NAME.getValue()));
        //tariff.setPrices(buildPrices(tarriffElement)); *commented to ignore prices on building
        tariff.setParameters(buildParameters(tarriffElement));
        return tariff;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }
}
