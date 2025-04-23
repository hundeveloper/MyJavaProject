// Bank.java
package workshop.bank.entity;

import workshop.bank.exception.*;
import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Account> accounts;
    private int nextAccountNumber = 1000;

    public Bank(String name) {
        this.name = name;
        accounts = new ArrayList<>();
    }

    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) return acc;
        }
        throw new AccountNotFoundException("계좌번호 " + accountNumber + "에 해당하는 계좌를 찾을 수 없습니다.");
    }

    public void createSavingsAccount(String owner, double balance, double interestRate) {
        String accNum = "AC" + nextAccountNumber++;
        SavingsAccount acc = new SavingsAccount(accNum, owner, balance, interestRate);
        accounts.add(acc);
        System.out.println("Saving(저축) 계좌가 생성되었습니다: " + acc);
    }

    public void createCheckingAccount(String owner, double balance, double limit) {
        String accNum = "AC" + nextAccountNumber++;
        CheckingAccount acc = new CheckingAccount(accNum, owner, balance, limit);
        accounts.add(acc);
        System.out.println("체킹 계좌가 생성되었습니다: " + acc);
    }

    public void deposit(String accNum, double amount) throws AccountNotFoundException {
        findAccount(accNum).deposit(amount);
    }

    public void withdraw(String accNum, double amount) throws Exception {
        findAccount(accNum).withdraw(amount);
    }

    public void transfer(String fromAcc, String toAcc, double amount) throws Exception {
        Account src = findAccount(fromAcc);
        Account dest = findAccount(toAcc);
        src.withdraw(amount);
        dest.deposit(amount);
        System.out.println(amount + "원이 " + fromAcc + "에서 " + toAcc + "로 송금되었습니다.");
    }

    public void printAllAccounts() {
        System.out.println("=== 모든 계좌 목록 ===");
        for (Account acc : accounts) {
            System.out.println(acc);
        }
        System.out.println("===================");
    }
}
