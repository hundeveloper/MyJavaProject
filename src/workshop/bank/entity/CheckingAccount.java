// CheckingAccount.java
package workshop.bank.entity;

public class CheckingAccount extends Account {
    private double withdrawalLimit;

    public CheckingAccount(String accountNumber, String ownerName, double balance, double withdrawalLimit) {
        super(accountNumber, ownerName, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public void withdraw(double amount) throws Exception {
        if (amount > withdrawalLimit) throw new workshop.bank.exception.WithdrawalLimitExceededException("출금 한도를 초과했습니다. 한도: " + withdrawalLimit + "원");
        if (balance < amount) throw new workshop.bank.exception.InsufficientBalanceException("잔액 부족");
        balance -= amount;
        System.out.println(amount + "원이 출금되었습니다. 현재 잔액: " + balance + "원");
    }

    @Override
    public String toString() {
        return super.toString() + ", 출금 한도: " + withdrawalLimit + "원";
    }
}
