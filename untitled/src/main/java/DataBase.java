import java.util.HashMap;

public class DataBase {

    public Double totalAmount;

    public Double amountPaid;

    public Integer totalEmi;

    private HashMap<Integer, Double> totalLumpSumPaid;

    public HashMap<Integer, Double> getTotalLumpSumPaid() {
        return totalLumpSumPaid;
    }

    public void setTotalLumpSumPaid(HashMap<Integer, Double> totalLumpSumPaid) {
        this.totalLumpSumPaid = totalLumpSumPaid;
    }

    public Integer getAmountRemaing() {
        return amountRemaing;
    }

    public void setAmountRemaing(Integer amountRemaing) {
        this.amountRemaing = amountRemaing;
    }

    public Integer amountRemaing;

    private Integer noOfEmisLeft;

    private String bankName;

    private Double amountToPayPerMonth;

    public Double getAmountToPayPerMonth() {
        return amountToPayPerMonth;
    }

    public void setAmountToPayPerMonth(Double amountToPayPerMonth) {
        this.amountToPayPerMonth = amountToPayPerMonth;
    }


    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }


    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Integer getTotalEmi() {
        return totalEmi;
    }

    public void setTotalEmi(Integer totalEmi) {
        this.totalEmi = totalEmi;
    }

    public Integer getNoOfEmisLeft() {
        return noOfEmisLeft;
    }

    public void setNoOfEmisLeft(Integer noOfEmisLeft) {
        this.noOfEmisLeft = noOfEmisLeft;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

}

