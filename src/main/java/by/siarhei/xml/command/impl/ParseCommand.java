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

    @Override
    public String execute(HttpServletRequest request) {
        ParserType parserType = ParserType.valueOf(
                request.getParameter("menu").toUpperCase());
        String fileName = request.getParameter("path");
        ParseFileService parseService = new ParseFileService();
        List<Tariff> tariffs = parseService.build(parserType, fileName);
        request.setAttribute("tariffs", tariffs);
        request.setAttribute("parseType", parserType);
        return ConfigurationManager.getProperty(PAGE);
    }
}
