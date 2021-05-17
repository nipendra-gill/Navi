package executor;

import commands.CommandType;
import database.Database;
import java.util.HashMap;

public class PaymentCommandExecutor extends CommandExecutor {

    private Double lumpSum;

    private int emiNo;

    private String bankName;

    private String borrowerName;

    @Override
    public Boolean isApplicable(CommandType commandType) {
        return commandType.equals(CommandType.PAYMENT);
    }

    @Override
    protected void executeValidCommand(CommandType commandType, String input) {
        String[] fields = input.split(" ");
        String bankName = fields[1];
        String borrowerName = fields[2];
        Double lumpSum = Double.valueOf(fields[3]);
        Integer emiNo = Integer.valueOf(fields[4]);
        String insertStringNameToMap = borrowerName.concat("_").concat(bankName.toString());
        if(!map.containsKey(insertStringNameToMap))
            System.out.println("No user exist associated with given BankName");
        Database database = map.get(insertStringNameToMap);

        if(database.getTotalLumpSumPaid() == null)
            database.setTotalLumpSumPaid(
                    new HashMap<>()
            );
        HashMap<Integer, Double> lumpMap = database.getTotalLumpSumPaid();
        lumpMap.put(emiNo, lumpSum);
        database.setTotalLumpSumPaid(lumpMap);
        map.put(insertStringNameToMap, database);

    }
}
