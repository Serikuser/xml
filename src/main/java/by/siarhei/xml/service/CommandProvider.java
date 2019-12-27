package by.siarhei.xml.service;

import by.siarhei.xml.command.ActionCommand;
import by.siarhei.xml.command.CommandType;

import javax.servlet.http.HttpServletRequest;

public class CommandProvider {

    private CommandProvider() {
    }
    public static ActionCommand defineCommand(HttpServletRequest request) {
        String action = request.getParameter("command");
        CommandType currentType = CommandType.valueOf(action.toUpperCase());
        return currentType.getCurrentCommand();
    }
}
