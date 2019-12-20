package by.siarhei.xml.factory;

import by.siarhei.xml.builder.AbstractTariffBuilder;
import by.siarhei.xml.builder.TariffBuilderDOM;
import by.siarhei.xml.builder.TariffBuilderSAX;
import by.siarhei.xml.builder.TariffBuilderStAX;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TariffBuildFactory {
    private static final Logger logger = LogManager.getLogger();

    public AbstractTariffBuilder createTariffBuilder(ParserType type) {
        switch (type) {
            case DOM:
                return new TariffBuilderDOM();
            case STAX:
                return new TariffBuilderStAX();
            case SAX:
                return new TariffBuilderSAX();
            default:
                throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
        }

    }
}

