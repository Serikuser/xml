package by.siarhei.xml.command;

import by.siarhei.xml.command.impl.BackCommand;
import by.siarhei.xml.command.impl.ParseCommand;
import by.siarhei.xml.command.impl.UploadCommand;

public enum CommandType {

    PARSE(new ParseCommand()),
    UPLOAD(new UploadCommand()),
    BACK(new BackCommand());

    CommandType(ActionCommand command) {
        this.command = command;
    }

    private ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
