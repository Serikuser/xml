package by.siarhei.xml.factory;

import by.siarhei.xml.command.ActionCommand;
import by.siarhei.xml.command.CommandType;
import by.siarhei.xml.command.impl.EmptyCommand;
import by.siarhei.xml.service.MessageManager;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {

    private static final String WRONG_ACTION = "wrongAction";
    private static final String MESSAGE_WRONG_ACTION = "message.wrongaction";

    private ActionFactory() {
    }

    public static ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand current = new EmptyCommand();
        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
            return current;
        }
        try {
            CommandType currentType = CommandType.valueOf(action.toUpperCase());
            current = currentType.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            request.setAttribute(WRONG_ACTION, action + MessageManager.getProperty(MESSAGE_WRONG_ACTION));
        }
        return current;
    }
}
