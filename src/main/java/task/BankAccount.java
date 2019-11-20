package task;

import java.time.LocalDate;

public class BankAccount {

    private String bankName;
    private double balance;
    private boolean isActive;
    private LocalDate startDate;

    public BankAccount(String bankName, double balance, boolean isActive, LocalDate startDate) {
        this.bankName = bankName;
        this.balance = balance;
        this.isActive = isActive;
        this.startDate = startDate;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
