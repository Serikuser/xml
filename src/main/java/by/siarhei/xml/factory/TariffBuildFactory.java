package by.siarhei.xml.factory;

import by.siarhei.xml.builder.AbstractTariffBuilder;
import by.siarhei.xml.builder.TariffTariffBuilderDOM;
import by.siarhei.xml.builder.TariffTariffBuilderSAX;
import by.siarhei.xml.builder.TariffTariffBuilderStAX;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TariffBuildFactory {
    private static final Logger logger = LogManager.getLogger();

    public AbstractTariffBuilder createTariffBuilder(ParserType type) {
        switch (type) {
            case DOM:
                return new TariffTariffBuilderDOM();
            case STAX:
                return new TariffTariffBuilderStAX();
            case SAX:
                return new TariffTariffBuilderSAX();
            default:
                throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
        }

    }
}

