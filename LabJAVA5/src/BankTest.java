public class BankTest {
    public static void main(String[] args) {
        Bank bank = new Bank();

        try {
            BankAccount account1 = bank.createAccount("John Doe", 500);
            BankAccount account2 = bank.createAccount("Alice Smith", 1000);

            System.out.println(account1.getAccountSummary());
            System.out.println(account2.getAccountSummary());

            bank.transferMoney(account1.getAccountNumber(), account2.getAccountNumber(), 300);

            System.out.println("After transfer:");
            System.out.println(account1.getAccountSummary());
            System.out.println(account2.getAccountSummary());

            // Trying to withdraw more money than available
            bank.transferMoney(account2.getAccountNumber(), account1.getAccountNumber(), 1200);
        } catch (AccountNotFoundException | InsufficientFundsException | NegativeAmountException e) {
            e.printStackTrace();
        }
    }
}
