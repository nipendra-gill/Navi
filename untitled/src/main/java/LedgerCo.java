import java.util.HashMap;
import java.util.Scanner;

public class LedgerCo {

    public static HashMap<String, DataBase> map = new HashMap<String, DataBase>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
int i = 0;

        while (true){

           String str = s.nextLine();

//            System.out.println(str);
            if(str != null && str.length() != 0)
                processInput(str);
            else
                break;
        }
    }

    private static void processInput(String str) {
        String[] inputs = str.split(" ");
        if(inputs.length == 0)
            return;
        if(inputs[0].equals("LOAN")){
            processDataLoan(str, map);
        }else if(inputs[0].equals("BALANCE")){
            processDataBalance(str, map);
        }else if(inputs[0].equals("PAYMENT")){
            processDataPayment(str, map);
        }
    }

    public static void processDataLoan(String input, HashMap<String, DataBase> map) {

        String[] fields = input.split(" ");
        String bankName = fields[1];
        String borrowerName = fields[2];
        Double amount = Double.valueOf(fields[3]);
        Integer noOfYears = Integer.valueOf(fields[4]);
        Double interset = Double.valueOf(fields[5]);

        Double intersetToAdd = (amount * noOfYears * interset)/100;
        String insertStringNameToMap = borrowerName.concat("_").concat(bankName.toString());
        Double amountToPaidPerMonth = Math.ceil((amount + intersetToAdd)/(noOfYears * 12));
        if(!map.containsKey(insertStringNameToMap)){
            DataBase database = new DataBase();
            database.setAmountPaid(0.0);
            database.setTotalAmount(amount + intersetToAdd);
            database.setBankName(bankName);
            database.setTotalEmi(0);
            database.setNoOfEmisLeft(noOfYears * 12);
            database.setAmountToPayPerMonth(amountToPaidPerMonth);
            database.setTotalLumpSumPaid(new HashMap<>());
            map.put(insertStringNameToMap, database);
        }
    }

    public static void processDataBalance(String input, HashMap<String,DataBase> map) {
        String[] fields = input.split(" ");
        String bankName = fields[1];
        String borrowerName = fields[2];
        Integer emiNo = Integer.valueOf(fields[3]);
        String insertStringNameToMap = borrowerName.concat("_").concat(bankName.toString());
        if(!map.containsKey(insertStringNameToMap)){
            System.out.println("No user exist with given Name and Bank");
        }
        DataBase database = map.get(insertStringNameToMap);
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

    public static void processDataPayment(String input, HashMap<String,DataBase> map) {

        String[] fields = input.split(" ");
        String bankName = fields[1];
        String borrowerName = fields[2];
        Double lumpSum = Double.valueOf(fields[3]);
        Integer emiNo = Integer.valueOf(fields[4]);
        String insertStringNameToMap = borrowerName.concat("_").concat(bankName.toString());
        if(!map.containsKey(insertStringNameToMap))
            System.out.println("No user exist associated with given BankName");
        DataBase database = map.get(insertStringNameToMap);

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
