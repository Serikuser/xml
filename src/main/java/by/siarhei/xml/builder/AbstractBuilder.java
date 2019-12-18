package by.siarhei.xml.builder;

import by.siarhei.xml.entity.Tariff;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public abstract class AbstractBuilder {
    protected static final Logger logger = LogManager.getLogger();

    protected List<Tariff> tariffs;

    public List<Tariff> getTariffs() {
        return this.tariffs;
    }

    public abstract void buildTariffs(String fileName);
}
