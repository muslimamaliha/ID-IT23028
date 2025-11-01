package encapsulation;

public class Main {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount();
        acc.deposit(1000);
        System.out.println("Total Amount: "+acc.getBalance());
    }
}
