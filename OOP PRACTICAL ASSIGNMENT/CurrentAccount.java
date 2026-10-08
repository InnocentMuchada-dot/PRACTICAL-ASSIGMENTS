public class CurrentAccount extends Account {
    private static final double MONTHLY_FEE = 10.00;
    private final double overdraftLimit;

    public CurrentAccount(String accountNumber, double initialBalance, double overdraftLimit) {
        super(accountNumber, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("  REJECTED: withdrawal amount must be positive.");
            return;
        }
        if (balance - amount < -overdraftLimit) {
            System.out.printf("  REJECTED: exceeds overdraft limit of %.2f. Balance remains %.2f%n",
                    overdraftLimit, balance);
            return;
        }
        balance -= amount;
        String note = balance < 0 ? " (overdraft in use)" : "";
        System.out.printf("  Withdrew %.2f%s. New balance: %.2f%n", amount, note, balance);
    }

    @Override
    public void endOfMonth() {
        balance -= MONTHLY_FEE;
        System.out.printf("  Maintenance fee of %.2f charged. New balance: %.2f%n",
                MONTHLY_FEE, balance);
    }
}