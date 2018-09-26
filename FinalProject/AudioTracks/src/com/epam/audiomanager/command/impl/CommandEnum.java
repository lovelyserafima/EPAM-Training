package com.epam.audiomanager.command.impl;

import com.epam.audiomanager.command.Command;
import com.epam.audiomanager.command.impl.language.EnglishLanguageCommand;
import com.epam.audiomanager.command.impl.language.RussianLanguageCommand;

public enum CommandEnum {
    SIGN_IN(new SignInCommand()), SIGN_UP(new SignUpCommand()), ENGLISH(new EnglishLanguageCommand()),
    RUSSIAN(new RussianLanguageCommand()), REGISTER(new RegisterCommand()), CONFIRM(new ConfirmCommand());

    private Command command;

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    CommandEnum(Command command){
        setCommand(command);
    }
}
