import commands.CommandType;
import executor.CommandExecutor;
import java.util.List;

public class CommandRunner {

    List<CommandExecutor> commandExecutors;

    public CommandRunner(List<CommandExecutor> commandExecutors) {
        this.commandExecutors = commandExecutors;
    }

    public String runCommand(CommandType command, String input) {
        for (CommandExecutor commandExecutor: commandExecutors) {
            if (commandExecutor.isApplicable(command)) {
                commandExecutor.execute(command, input);
            }
        }

        return "Invalid Command";
    }
}
