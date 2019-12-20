package by.siarhei.xml.command;

import by.siarhei.xml.command.impl.BackCommand;
import by.siarhei.xml.command.impl.ParseCommand;
import by.siarhei.xml.command.impl.UploadCommand;

public enum CommandType {
    PARSE {
        {
            this.command = new ParseCommand();
        }
    },
    UPLOAD {
        {
            this.command = new UploadCommand();
        }
    },
    BACK {
        {
            this.command = new BackCommand();
        }
    };

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
