package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;
import lesson20.task2.exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {
    private Transaction[] transactions = new Transaction[10];
    private Utils utils = new Utils();

    public Transaction save(Transaction transaction) throws Exception/*LimitExceeded*/ {
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

    private void validate(Transaction transaction) throws Exception {

        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceed " + transaction.getId() + ". Can't be saved");

        int sum = 0;
        int count = 0;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
            sum += tr.getAmount();
            count++;
        }

        if (sum > utils.getLimitTransactionsPerDayAmount())
            throw new LimitExceeded("Transaction limit per day amount exceed " + transaction.getId() + ". Can't be saved");

        if (count + 1 > utils.getLimitTransactionsPerDayCount())
            throw new LimitExceeded("Transaction limit per day count exceed " + transaction.getId() + ". Can't be saved");

        boolean city = false;
        for (String str : utils.getCities()) {
            if (str.equals(transaction.getCity())) {
                city = true;
                break;
            }
        }
        if (!city)
            throw new BadRequestException("Transaction's city  " + transaction.getId() + ". Can't be saved");

        int index = 0;
        for (Transaction tr : transactions) {
            if (tr == null)
                index++;
        }
        if (index == 0)
            throw new InternalServerException("Transaction " + transaction.getId() + " can't be saved because of out of space");
    }

    Transaction[] transactionList() throws Exception {
        if (transactions.length == 0)
            throw new InternalServerException("error");

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

    Transaction[] transactionList(String city) throws Exception {

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

    Transaction[] transactionList(int amount) throws Exception {

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

    private Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) {
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

}
