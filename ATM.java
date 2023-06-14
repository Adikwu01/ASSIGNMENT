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
public class ATMMain {
    public static void main(String[] args) {
        ATM atm = new ATM(100000, 30000);
        Menu menu = new Menu(atm);
        menu.run();
    }
}
import java.util.Scanner;

public class Menu {
    private ATM atm;
    private InputReader inputReader;

    public Menu(ATM atm) {
        this.atm = atm;
        this.inputReader = new InputReader();
    }

    public void run() {
        System.out.println("\nATM Initialized with initial balance: " + atm.getBalance());
        System.out.println("Withdrawal Limit: " + atm.getWithdrawalLimit());

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Transaction Count");
            System.out.println("4. Exit");
            int choice = inputReader.readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    int withdrawalAmount = inputReader.readInt("Enter withdrawal amount: ");
                    System.out.println(atm.withdraw(withdrawalAmount));
                    break;
                case 2:
                    int depositAmount = inputReader.readInt("Enter deposit amount: ");
                    System.out.println(atm.deposit(depositAmount));
                    break;
                case 3:
                    System.out.println("Total transactions: " + atm.getTransactionCount());
                    break;
                case 4:
                    System.out.println("Exiting ATM. Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
import java.util.Scanner;

public class InputReader {
    private Scanner scanner;

    public InputReader() {
        this.scanner = new Scanner(System.in);
    }

    public int readInt(String message) {
        System.out.print(message);
        return scanner.nextInt();
    }
}

