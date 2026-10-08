public class SavingsAccount extends Account {
    private static final double MONTHLY_INTEREST_RATE = 0.01; // 1%
    private final double minimumBalance;

    public SavingsAccount(String accountNumber, double initialBalance, double minimumBalance) {
        super(accountNumber, initialBalance);
        this.minimumBalance = minimumBalance;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("  REJECTED: withdrawal amount must be positive.");
            return;
        }
        if (balance - amount < minimumBalance) {
            System.out.printf("  REJECTED: balance would fall below minimum of %.2f. Balance remains %.2f%n",
                    minimumBalance, balance);
            return;
        }
        balance -= amount;
        System.out.printf("  Withdrew %.2f. New balance: %.2f%n", amount, balance);
    }

    @Override
    public void endOfMonth() {
        double interest = balance * MONTHLY_INTEREST_RATE;
        balance += interest;
        System.out.printf("  Interest of %.2f applied at %.1f%%. New balance: %.2f%n",
                interest, MONTHLY_INTEREST_RATE * 100, balance);
    }
}