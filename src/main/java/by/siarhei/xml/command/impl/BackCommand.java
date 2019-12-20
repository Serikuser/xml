package by.siarhei.xml.command.impl;

import by.siarhei.xml.command.ActionCommand;
import by.siarhei.xml.service.ConfigurationManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class BackCommand implements ActionCommand {
    private static final String PAGE = "path.page.index";

    @Override
    public String execute(HttpServletRequest request) throws IOException, ServletException {
        return ConfigurationManager.getProperty(PAGE);
    }
}
