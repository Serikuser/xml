package by.siarhei.xml.command.impl;

import by.siarhei.xml.builder.AbstractTariffBuilder;
import by.siarhei.xml.command.ActionCommand;
import by.siarhei.xml.entity.Tariff;
import by.siarhei.xml.factory.ParserType;
import by.siarhei.xml.factory.TariffBuildFactory;
import by.siarhei.xml.service.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ParseCommand implements ActionCommand {
    private static final Logger logger = LogManager.getLogger();

    private static final String PAGE = "path.page.result";

    @Override
    public String execute(HttpServletRequest request) {
        ParserType parserType = ParserType.valueOf(
                request.getParameter("menu").toUpperCase());
        String fileName = request.getParameter("path");
        TariffBuildFactory factory = new TariffBuildFactory();
        AbstractTariffBuilder builder = factory.createTariffBuilder(parserType);
        builder.buildTariffs(fileName);
        List<Tariff> tariffs = builder.getTariffs();
        request.setAttribute("tariffs", tariffs);
        request.setAttribute("parseType", parserType);
        return ConfigurationManager.getProperty(PAGE);
    }
}
