import java.util.ArrayList;
import java.util.List;

public class BankDemo {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("SAV-001", 1000.00, 100.00));
        accounts.add(new CurrentAccount("CUR-001", 200.00, 500.00));
        accounts.add(new SavingsAccount("SAV-002", 300.00, 100.00));
        accounts.add(new CurrentAccount("CUR-002", 100.00, 500.00));

        double[] withdrawals = {400.00, 450.00, 250.00, 700.00};

        System.out.println("=== Withdrawals ===");
        for (int i = 0; i < accounts.size(); i++) {
            Account acc = accounts.get(i); // Account reference only, no casting
            System.out.printf("%s (%s): withdraw %.2f%n",
                    acc.getAccountNumber(), acc.getClass().getSimpleName(), withdrawals[i]);
            acc.withdraw(withdrawals[i]);   // runtime picks the right override
        }

        System.out.println();
        System.out.println("=== End of month ===");
        for (Account acc : accounts) {
            System.out.printf("%s (%s): endOfMonth%n",
                    acc.getAccountNumber(), acc.getClass().getSimpleName());
            acc.endOfMonth();               // runtime picks the right override
        }

        System.out.println();
        System.out.println("=== Final balances ===");
        for (Account acc : accounts) {
            System.out.printf("%s: %.2f%n", acc.getAccountNumber(), acc.getBalance());
        }
    }
}