import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<BankAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public BankAccount createAccount(String accountName, double initialDeposit) {
        int accountNumber = generateAccountNumber();
        BankAccount newAccount = new BankAccount(accountNumber, accountName, initialDeposit);
        this.accounts.add(newAccount);
        return newAccount;
    }

    public BankAccount findAccount(int accountNumber) throws AccountNotFoundException {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        throw new AccountNotFoundException("Account with number " + accountNumber + " not found");
    }

    public void transferMoney(int fromAccountNumber, int toAccountNumber, double amount)
            throws AccountNotFoundException, InsufficientFundsException, NegativeAmountException {
        BankAccount fromAccount = findAccount(fromAccountNumber);
        BankAccount toAccount = findAccount(toAccountNumber);

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }

    private int generateAccountNumber() {
        // Logic to generate a unique account number
        // You can implement your own logic here
        return accounts.size() + 1;
    }
}
public BankAccount createAccount(String accountName, double initialDeposit) throws NegativeAmountException {
    if (initialDeposit < 0) {
        throw new NegativeAmountException("Initial deposit cannot be negative");
    }
    int accountNumber = generateAccountNumber();
    BankAccount newAccount = new BankAccount(accountNumber, accountName, initialDeposit);
    this.accounts.add(newAccount);
    return newAccount;
}

public BankAccount findAccount(int accountNumber) throws AccountNotFoundException {
    for (BankAccount account : accounts) {
        if (account.getAccountNumber() == accountNumber) {
            return account;
        }
    }
    throw new AccountNotFoundException("Account with number " + accountNumber + " not found");
}



