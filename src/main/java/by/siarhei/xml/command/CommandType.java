package by.siarhei.xml.command;

import by.siarhei.xml.command.impl.HomeCommand;
import by.siarhei.xml.command.impl.ParseCommand;
import by.siarhei.xml.command.impl.UploadCommand;

public enum CommandType {

    PARSE(new ParseCommand()),
    UPLOAD(new UploadCommand()),
    HOME(new HomeCommand());

    CommandType(ActionCommand command) {
        this.command = command;
    }

    private ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
