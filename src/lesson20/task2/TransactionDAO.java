package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;
import lesson20.task2.exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {
    private static Transaction[] transactions = new Transaction[10];
    private static Utils utils = new Utils();

    public static Transaction save(Transaction transaction) throws Exception/*LimitExceeded*/ {
//        сумма транзакции больше указанного лимита +
//        сумма транзакции за день больше дневного лимита +
//        количество транзакций за день больше указанного лимита +
//        если город оплаты (совершения транзакции) не разрешен (BadRequestException) +
//        не хватило места (InternalExceeded) +

        if (transaction == null)
            throw new InternalServerException("Transaction is null. Can't be saved");

        validate(transaction);

        for (int i = 0; i < transactions.length; i++)
            if (transactions[i] == null) {
                transactions[i] = transaction;
                return transactions[i];
            }

        throw new InternalServerException("Unexpected error transaction: " + transaction.getId());
    }

    private static void validate(Transaction transaction) throws Exception {

        if (!checkAmount(transaction))
            throw new LimitExceeded("Transaction limit exceed " + transaction.getId() + ". Can't be saved");

        if (sum(transaction) > utils.getLimitTransactionsPerDayAmount())
            throw new LimitExceeded("Transaction limit per day amount exceed " + transaction.getId() + ". Can't be saved");

        if (count(transaction) + 1 > utils.getLimitTransactionsPerDayCount())
            throw new LimitExceeded("Transaction limit per day count exceed " + transaction.getId() + ". Can't be saved");

        if (!checkCity(transaction))
            throw new BadRequestException("Transaction's city  " + transaction.getId() + ". Can't be saved");

        if (!freePlace(transaction))
            throw new InternalServerException("Transaction " + transaction.getId() + " can't be saved because of out of space");
    }

    public static Transaction[] transactionList() throws Exception {

        int count = 0;
        for (Transaction tr : transactions) {
            if (tr != null)
                count++;
        }

        Transaction[] trList = new Transaction[count];
        int index = 0;
        for (Transaction tr : transactions)
            if (tr != null) {
                trList[index] = tr;
                index++;
            }
        return trList;

    }

    public static Transaction[] transactionList(String city) throws Exception {

        if (city == null)
            throw new InternalServerException("City is null");

        int count = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getCity().equals(city))
                count++;
        }

        Transaction[] trCityList = new Transaction[count];
        int index = 0;
        for (Transaction tr : transactions)
            if (tr != null && tr.getCity().equals(city)) {
                trCityList[index] = tr;
                index++;
            }
        return trCityList;
    }

    public static Transaction[] transactionList(int amount) throws Exception {

        if (amount == 0)
            throw new InternalServerException("Amount is 0");

        int count = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getAmount() == amount)
                count++;
        }

        Transaction[] trAmountList = new Transaction[count];
        int index = 0;
        for (Transaction tr : transactions)
            if (tr != null && tr.getAmount() == amount) {
                trAmountList[index] = tr;
                index++;
            }
        return trAmountList;
    }

    private static Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCurTransaction);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day)
                    count++;
            }
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day) {
                    result[index] = transaction;
                    index++;
                }
            }
        }
        return result;
    }

    private static boolean checkAmount(Transaction transaction) {
        if (transaction.getAmount() <= utils.getLimitSimpleTransactionAmount())
            return true;
        return false;
    }

    private static int sum(Transaction transaction) {
        int sum = 0;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
            sum += tr.getAmount();
        }
        return sum;
    }

    private static int count(Transaction transaction) {
        int count = 0;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
            count++;
        }
        return count;
    }

    private static boolean checkCity(Transaction transaction) {
        for (String str : utils.getCities()) {
            if (str.equals(transaction.getCity()))
                return true;
        }
        return false;
    }

    private static boolean freePlace(Transaction transaction) {
        for (Transaction tr : transactions) {
            if (tr == null)
                return true;
        }
        return false;
    }
}
