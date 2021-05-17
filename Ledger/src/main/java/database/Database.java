package database;

import java.util.HashMap;

public class Database {

    public Double totalAmount;

    public Double amountPaid;

    public Integer currentEmiNo;

    private Integer noOfEmisLeft;

    private String bankName;

    private Double amountToPayPerMonth;

    private HashMap<Integer, Double> totalLumpSumPaid;

    public HashMap<Integer, Double> getTotalLumpSumPaid() {
        return totalLumpSumPaid;
    }

    public void setTotalLumpSumPaid(HashMap<Integer, Double> totalLumpSumPaid) {
        this.totalLumpSumPaid = totalLumpSumPaid;
    }

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

    public Integer getCurrentEmiNo() {
        return currentEmiNo;
    }

    public void setCurrentEmiNo(Integer currentEmiNo) {
        this.currentEmiNo = currentEmiNo;
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
