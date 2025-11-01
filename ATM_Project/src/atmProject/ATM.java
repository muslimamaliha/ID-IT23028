package atmProject;
import java.util.Scanner;

public class ATM {
    private double balance = 1000.0;

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if(amount <= balance) balance -= amount;
        else System.out.println("Insufficient balance!");
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("\n1.Deposit 2.Withdraw 3.Balance 4.Exit");
            int choice = sc.nextInt();
            switch(choice) {
                case 1 -> {
                    System.out.println("Enter amount:");
                    atm.deposit(sc.nextDouble());
                }
                case 2 -> {
                    System.out.println("Enter amount:");
                    atm.withdraw(sc.nextDouble());
                }
                case 3 -> atm.checkBalance();
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid choice!");
            }
        }
    }

}
