package ATMInterface;

import java.util.Scanner;

public class ATM {

    private final BankAccount account;
    private final Scanner sc;

    public ATM(BankAccount account) {
        this.account = account;
        this.sc = new Scanner(System.in);
    }

    public void checkBalance() {
        System.out.println("Current Balance: ₹" + account.getBalance());
    }

    public void deposit(double amount) {
        if (account.deposit(amount)) {
            System.out.println("Deposit Successful!");
        } else {
            System.out.println("Invalid Amount!");
        }
    }

    public void withdraw(double amount) {
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal Successful!");
        } else {
            System.out.println("Insufficient Balance or Invalid Amount!");
        }
    }

    public void start() {

        try (sc) {
            int choice;
            
            do {
                System.out.println("\n===== ATM MENU =====");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                
                System.out.print("Enter choice: ");
                choice = sc.nextInt();
                
                switch (choice) {
                    
                    case 1 -> checkBalance();
                        
                    case 2 -> {
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = sc.nextDouble();
                        deposit(depositAmount);
                    }
                        
                    case 3 -> {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = sc.nextDouble();
                        withdraw(withdrawAmount);
                    }
                        
                    case 4 -> System.out.println("Thank you for using ATM!");
                        
                    default -> System.out.println("Invalid Choice!");
                }
                
            } while (choice != 4);
        }
    }
}