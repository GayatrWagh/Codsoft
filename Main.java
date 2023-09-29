import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited Rs." + amount);
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance && amount > 0) {
            balance -= amount;
            System.out.println("Withdrawn Rs." + amount);
        } else if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }
}

class ATM {
    private BankAccount acc;

    public ATM(BankAccount acc) {
        this.acc = acc;
    }

    public void displayMenu() {
        System.out.println("\n Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void processOption(int option, Scanner sc) {
        switch (option) {
            case 1:
                System.out.println("Current Balance: Rs." + acc.getBalance());
                break;
            case 2:
                System.out.print("Enter deposit amount (Rs.): ");
                double depositAmount = sc.nextDouble();
                acc.deposit(depositAmount);
                break;
            case 3:
                System.out.print("Enter withdrawal amount (Rs.): ");
                double withdrawalAmount = sc.nextDouble();
                acc.withdraw(withdrawalAmount);
                break;
            case 4:
                System.out.println("Thank you for using our ATM.See you Again!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); // Initial balance of Rs. 1000
        ATM atm = new ATM(userAccount);
        Scanner sc = new Scanner(System.in);

        while (true) {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            int option = sc.nextInt();
            atm.processOption(option, sc);
        }
    }
}