package com.epam.audiomanager.command.impl;

import com.epam.audiomanager.command.Command;
import com.epam.audiomanager.util.ConstantValues;

public enum CommandEnum {
    SIGN_IN(new SignInCommand()), SIGN_UP(new SignUpCommand()),
    ENGLISH(new ChangeLanguageCommand(ConstantValues.ENGLISH_LOCALE)),
    RUSSIAN(new ChangeLanguageCommand(ConstantValues.RUSSIAN_LOCALE)), REGISTER(new RegisterCommand());

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
