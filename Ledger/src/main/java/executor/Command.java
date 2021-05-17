package executor;

import commands.CommandType;

public class Command {

    public CommandType commandType;

    public Command(CommandType commandType){
        this.commandType = commandType;
    }

    public CommandType getCommand(){
        return this.commandType;
    }

    public void setCommand(CommandType command){
        this.commandType = command;
    }
}
