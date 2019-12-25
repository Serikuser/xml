package by.siarhei.xml.builder;

import by.siarhei.xml.entity.Tariff;
import by.siarhei.xml.entity.TariffParameters;
import by.siarhei.xml.entity.TariffPrices;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class TariffBuilderDOMTest {
    private Tariff tariffBezlemitishe;
    private Tariff tariffSuper;
    private TariffPrices bezlemitishePrices;
    private TariffPrices superPrices;
    private TariffParameters bezlemitisheParameters;
    private TariffParameters superParameters;
    private TariffBuilderDOM domBuilder;
    private String filePath;

    @BeforeClass
    void setUp() {
        filePath = "\\valid.xml";
        tariffBezlemitishe = new Tariff();
        tariffBezlemitishe.setTariffName("Bezlemitishe");
        tariffBezlemitishe.setOperator("MTS");
        tariffBezlemitishe.setPayroll(10.00);
        tariffBezlemitishe.setLaunchDate("2009-01-01");
        bezlemitishePrices = new TariffPrices();
        bezlemitishePrices.setInnerCallPrice(0.55);
        bezlemitishePrices.setExternalCallPrice(1.02);
        bezlemitishePrices.setHomeCallPrice(2.00);
        bezlemitishePrices.setSmsPrice(0.05);
        tariffBezlemitishe.setPrices(bezlemitishePrices);
        bezlemitisheParameters = new TariffParameters();
        bezlemitisheParameters.setTariffing("seconds");
        bezlemitisheParameters.setConnectionPrice(2.00);
        bezlemitisheParameters.setAnnyNumberPrice(10.00);
        tariffBezlemitishe.setParameters(bezlemitisheParameters);
        tariffSuper = new Tariff();
        tariffSuper.setTariffName("Super8");
        tariffSuper.setOperator("LIFE");
        tariffSuper.setPayroll(4.00);
        tariffSuper.setLaunchDate("2019-01-01");
        superPrices = new TariffPrices();
        superPrices.setInnerCallPrice(0.24);
        superPrices.setExternalCallPrice(1.33);
        superPrices.setHomeCallPrice(3.00);
        superPrices.setSmsPrice(0.01);
        tariffSuper.setPrices(superPrices);
        superParameters = new TariffParameters();
        superParameters.setTariffing("minutes");
        superParameters.setConnectionPrice(2.00);
        superParameters.setAnnyNumberPrice(8.00);
        tariffSuper.setParameters(superParameters);
    }

    @AfterClass
    void setDown() {
        Tariff tariffBezlemitishe = null;
        Tariff tariffSuper = null;
        TariffPrices bezlemitishePrices = null;
        TariffPrices superPrices = null;
        TariffParameters bezlemitisheParameters = null;
        TariffParameters superParameters = null;
        TariffBuilderDOM domBuilder = null;
    }

    @Test
    void buildTariffsNoPricesPositiveTest() {
        //given
        domBuilder = new TariffBuilderDOM();
        domBuilder.buildTariffs(filePath);
        List<Tariff> expected = new LinkedList<>();
        expected.add(tariffBezlemitishe);
        expected.add(tariffSuper);
        tariffBezlemitishe.setPrices(null);
        tariffSuper.setPrices(null);

        //when
        List<Tariff> actual = domBuilder.getTariffs();

        //then
        Assert.assertEquals(actual, expected);
    }

    @Test
    void buildTariffsNoPricesNegativeTest() {
        //given
        domBuilder = new TariffBuilderDOM();
        domBuilder.buildTariffs(filePath);
        List<Tariff> expected = new LinkedList<>();
        expected.add(tariffBezlemitishe);
        expected.add(tariffSuper);

        //when
        List<Tariff> actual = domBuilder.getTariffs();

        //then
        Assert.assertNotEquals(actual, expected);
    }
}
