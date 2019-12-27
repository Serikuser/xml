package by.siarhei.xml.command.impl;

import by.siarhei.xml.command.ActionCommand;
import by.siarhei.xml.entity.Tariff;
import by.siarhei.xml.factory.ParserType;
import by.siarhei.xml.manager.ConfigurationManager;
import by.siarhei.xml.service.ParseFileService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ParseCommand implements ActionCommand {
    private static final String PAGE = "path.page.result";
    private static final String PARAMETER_MENU = "menu";
    private static final String PARAMETER_PATH = "path";
    private static final String ATTRIBUTE_TARIFFS = "tariffs";
    private static final String ATTRIBUTE_PARSE_TYPE = "parseType";

    @Override
    public String execute(HttpServletRequest request) {
        ParseFileService parseService = new ParseFileService();
        ParserType parserType = ParserType.valueOf(
                request.getParameter(PARAMETER_MENU).toUpperCase());
        String fileName = request.getParameter(PARAMETER_PATH);
        List<Tariff> tariffs = parseService.build(parserType, fileName);
        request.setAttribute(ATTRIBUTE_TARIFFS, tariffs);
        request.setAttribute(ATTRIBUTE_PARSE_TYPE, parserType);
        return ConfigurationManager.getProperty(PAGE);
    }
}
