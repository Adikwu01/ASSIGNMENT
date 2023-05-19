public class ATM {
    private int balance;
    private int withdrawalLimit;
    private int transactionCount;

    public ATM(int initialBalance, int withdrawalLimit) {
        this.balance = initialBalance;
        this.withdrawalLimit = withdrawalLimit;
        this.transactionCount = 0;
    }

    public String withdraw(int amount) {
        if (amount > balance || amount > withdrawalLimit) {
            return "Insufficient funds or withdrawal limit exceeded.";
        } else if (amount < 30000) {
            return "Minimum withdrawal amount is 30,000.";
        } else {
            balance -= amount;
            transactionCount++;
            return "Withdrawal successful. Remaining balance: " + balance;
        }
    }

    public String deposit(int amount) {
        balance += amount;
        transactionCount++;
        return "Deposit successful. Current balance: " + balance;
    }

    public int getTransactionCount() {
        return transactionCount;
    }

    public int getBalance() {
        return balance;
    }
}
