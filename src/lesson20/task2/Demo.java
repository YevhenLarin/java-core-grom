package lesson20.task2;

import java.util.Date;

public class Demo {
    public static void main(String[] args) throws Exception {
        Transaction tr1 = new Transaction(1, "Kiev", 10, "111", TransactionType.INCOME, new Date());
        Transaction tr2 = new Transaction(2, "Dnepr", 500, "222", TransactionType.INCOME, new Date());
        Transaction tr3 = new Transaction(3, "Odessa", 1000, "333", TransactionType.INCOME, new Date());


        Controller controller = new Controller();

        controller.save(tr1);
    }
}