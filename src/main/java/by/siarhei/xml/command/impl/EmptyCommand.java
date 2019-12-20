package by.siarhei.xml.command.impl;

import by.siarhei.xml.command.ActionCommand;
import by.siarhei.xml.service.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements ActionCommand {

    public static final String MAIN_PAGE = "path.page.index";

    @Override
    public String execute(HttpServletRequest request) {
            return ConfigurationManager.getProperty(MAIN_PAGE);
    }
}
