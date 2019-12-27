package by.siarhei.xml.service;

import by.siarhei.xml.builder.AbstractTariffBuilder;
import by.siarhei.xml.entity.Tariff;
import by.siarhei.xml.factory.ParserType;
import by.siarhei.xml.factory.TariffBuildFactory;

import java.util.List;

public class ParseFileService {
    public List<Tariff> build(ParserType parserType, String fileName) {
        TariffBuildFactory factory = new TariffBuildFactory();
        AbstractTariffBuilder builder = factory.createTariffBuilder(parserType);
        builder.buildTariffs(fileName);
        return builder.getTariffs();
    }
}
