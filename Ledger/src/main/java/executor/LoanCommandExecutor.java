package executor;

import commands.CommandType;
import database.Database;
import java.util.HashMap;

public class LoanCommandExecutor extends CommandExecutor {

    private Double amount;

    private Integer noOfYears;

    private Double interset;

    private String borrowerName;

    @Override
    public Boolean isApplicable(CommandType commandType) {
        return commandType.equals(CommandType.LOAN);
    }

    @Override
    protected void executeValidCommand(CommandType commandType, String input) {
        String[] fields = input.split(" ");
        String bankName = fields[1];
        String borrowerName = fields[2];
        Double amount = Double.valueOf(fields[3]);
        Integer noOfYears = Integer.valueOf(fields[4]);
        Double interset = Double.valueOf(fields[5]);

        Double intersetToAdd = (amount * noOfYears * interset) / 100;
        String insertStringNameToMap = borrowerName.concat("_").concat(bankName.toString());
        Double amountToPaidPerMonth = Math.ceil((amount + intersetToAdd) / (noOfYears * 12));
        if (!map.containsKey(insertStringNameToMap)) {
            Database database = new Database();
            database.setAmountPaid(0.0);
            database.setTotalAmount(amount + intersetToAdd);
            database.setBankName(bankName);
            database.setNoOfEmisLeft(noOfYears * 12);
            database.setAmountToPayPerMonth(amountToPaidPerMonth);
            database.setTotalLumpSumPaid(new HashMap<>());
            map.put(insertStringNameToMap, database);
        }
    }
}
