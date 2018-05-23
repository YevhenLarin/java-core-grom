package lesson30.task1;

import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class UkrainianBankSystem implements BankSystem {

    private Set<Transaction> transactions = new TreeSet<>();

    @Override
    public void withdraw(User user, int amount) {
        //проверить можно ли снять
        //проверить лимит
        //проверить достаточно ли денег
        //снять деньги

        if (!checkWithdraw(user, amount))
            return;
        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));

        createAndSaveTransaction(new Date(), TransactionType.WITHDRAWAL, amount, "sdsdc");
    }

    @Override
    public void fund(User user, int amount) {
        if (!checkFunding(user, amount))
            return;
        user.setBalance(user.getBalance() + amount);

        createAndSaveTransaction(new Date(), TransactionType.FUNDING, amount, "sdsdc");
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        //снимаем деньги с fromUser
        //пополняем toUser

        if (fromUser.getBank().getCurrency() == toUser.getBank().getCurrency()) {
            if (!checkWithdraw(fromUser, amount)) {
                return;
            }
            if (!checkFunding(toUser, amount)) {
                return;
            }
            fromUser.setBalance(fromUser.getBalance() - amount - amount * fromUser.getBank().getCommission(amount));
            toUser.setBalance(toUser.getBalance() + amount);
        }

        createAndSaveTransaction(new Date(), TransactionType.TRANSFER, amount, "sdsdc");
    }

    @Override
    public void paySalary(User user) {
        fund(user, user.getSalary());

        createAndSaveTransaction(new Date(), TransactionType.SALARY_INCOME, user.getSalary(), "sdsdc");
    }

    private boolean checkWithdraw(User user, int amount) {
        return checkWithdrawLimits(user, amount, user.getBank().getLimitOfWithdrawal()) &&
                checkWithdrawLimits(user, amount, user.getBalance());
    }

    private boolean checkWithdrawLimits(User user, int amount, double limit) {
        if (amount + user.getBank().getCommission(amount) > limit) {
            printWithdrawalErrorMsg(amount, user);
            return false;
        }
        return true;
    }

    private void printWithdrawalErrorMsg(int amount, User user) {
        System.err.println("Can't withdraw money " + amount + "from user " + user.toString());
    }

    private boolean checkFunding(User user, int amount) {
        if (amount > user.getBank().getLimitOfFunding()) {
            System.err.println("Can't funding money " + amount + "from user " + user.toString());
            return false;
        }
        return true;
    }

    private Transaction createAndSaveTransaction(Date dateCreated, TransactionType type, int amount, String descr) {
        Random random = new Random();
        Transaction tr = new Transaction(random.nextInt(), dateCreated, null, type, amount, descr);
        transactions.add(tr);
        return tr;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }
}
