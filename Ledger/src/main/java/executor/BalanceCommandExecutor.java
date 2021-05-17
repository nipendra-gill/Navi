package executor;

import commands.CommandType;
import database.Database;
import java.util.HashMap;

public class BalanceCommandExecutor extends CommandExecutor {

    private String bankName;

    private String borrowerName;

    private int emiNo;

    @Override
    public Boolean isApplicable(CommandType commandType) {
        return commandType.equals(CommandType.BALANCE);
    }

    @Override
    protected void executeValidCommand(CommandType commandType, String input) {
        String[] fields = input.split(" ");
        String bankName = fields[1];
        String borrowerName = fields[2];
        Integer emiNo = Integer.valueOf(fields[3]);
        String insertStringNameToMap = borrowerName.concat("_").concat(bankName.toString());
        if(!map.containsKey(insertStringNameToMap)){
            System.out.println("No user exist with given Name and Bank");
        }
        Database database = map.get(insertStringNameToMap);
        HashMap totalLumpAmountTillEmi = database.getTotalLumpSumPaid();
        Double totalSum = 0.0;
        for(Object value: totalLumpAmountTillEmi.keySet()){
            Integer val = (Integer)value;
            if(val<= emiNo)
                totalSum += (Double)totalLumpAmountTillEmi.get(val);
        }

        int amountPaid = (int)(Math.ceil((database.getAmountToPayPerMonth()* emiNo + totalSum)));
        Double emiReaming = (database.getTotalAmount() - amountPaid)/database.getAmountToPayPerMonth();

        String output = bankName+ " " + borrowerName+" " + amountPaid + " " + (int)Math.ceil(emiReaming);
        System.out.println(output);
    }

}
