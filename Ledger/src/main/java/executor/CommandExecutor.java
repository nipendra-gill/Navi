package executor;

import commands.CommandType;
import database.Database;
import java.util.HashMap;

abstract public class CommandExecutor {

    protected String bankName;

     protected String borrowerName;

    protected HashMap<String, Database> map = new HashMap<>();

//    private Database database;

//    public CommandExecutor(Database database) {
//        this.database = database;
//    }

    public void execute(final CommandType commandType, String input) {
        if (!isApplicable(commandType)) {
            System.out.println("Invalid Command");
        }
         executeValidCommand(commandType, input);
    }

    public abstract Boolean isApplicable(final CommandType commandType);

    protected abstract void executeValidCommand(final CommandType commandType, String input);
}
