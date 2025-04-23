// BankDemo.java
package workshop.bank.control;

import workshop.bank.entity.*;
import workshop.bank.exception.*;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank("중앙은행");

        System.out.println("=== 계좌 생성 ===");
        bank.createSavingsAccount("홍길동", 10000.0, 3.0);
        bank.createCheckingAccount("김철수", 20000.0, 5000.0);
        bank.createSavingsAccount("이영희", 30000.0, 2.0);

        System.out.println();
        bank.printAllAccounts();

        System.out.println("\n=== 입금/출금 테스트 ===");
        try {
            bank.deposit("AC1000", 5000);
            bank.withdraw("AC1001", 3000);
        } catch (Exception e) { System.out.println("예외 발생: " + e.getMessage()); }

        System.out.println("\n=== 이자 적용 테스트 ===");
        try {
            Account acc = bank.findAccount("AC1000");
            if (acc instanceof SavingsAccount) {
                ((SavingsAccount) acc).applyInterest();
            }
        } catch (Exception e) { System.out.println("예외 발생: " + e.getMessage()); }

        System.out.println("\n=== 계좌 이체 테스트 ===");
        try {
            bank.transfer("AC1002", "AC1001", 5000);
        } catch (Exception e) { System.out.println("예외 발생: " + e.getMessage()); }

        System.out.println();
        bank.printAllAccounts();

        System.out.println("\n=== 예외 테스트 ===");
        try { bank.withdraw("AC1001", 6000); } catch (Exception e) { System.out.println("예외 발생: " + e.getMessage()); }
        try { bank.withdraw("AC1001", 6000); } catch (Exception e) { System.out.println("예외 발생: " + e.getMessage()); }
        try { bank.findAccount("AC9999"); } catch (Exception e) { System.out.println("예외 발생: " + e.getMessage()); }
    }
}
