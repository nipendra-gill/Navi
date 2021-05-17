import commands.CommandType;
import executor.CommandExecutor;
import java.util.Scanner;

public class LedgerCo {

    @Autowired
    private CommandExecutor commandExecutor;

    public static void main(String[] args) {
        System.out.println("Starting program");
        while (true){
            Scanner s = new Scanner(System.in);
            String input = s.nextLine();
//            String input = "LOAN IDIDI Dale 10000 5 4";
            if(input != null && input.length() != 0){
                String[] str = input.split(" ");
                CommandType commandType = CommandType.valueOf(str[0]);
                commandExecutor.execute(commandType, input);
            }
        }
    }


}
