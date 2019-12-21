package by.siarhei.xml.factory;

import by.siarhei.xml.builder.AbstractTariffBuilder;
import by.siarhei.xml.builder.TariffBuilderDOM;
import by.siarhei.xml.builder.TariffBuilderSAX;
import by.siarhei.xml.builder.TariffBuilderStAX;

public class TariffBuildFactory {

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

