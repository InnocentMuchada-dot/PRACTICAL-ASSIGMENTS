public abstract class Account {
    protected String accountNumber;
    protected double balance;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("  Deposit rejected: amount must be positive.");
            return;
        }
        balance += amount;
        System.out.printf("  Deposited %.2f. New balance: %.2f%n", amount, balance);
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    
    public abstract void withdraw(double amount);

    public abstract void endOfMonth();
}