package lesson30.task1;

public class Main {
    public static void main(String[] args) {
        Bank usBank = new USBank(1222, "Sweden", Currency.EUR, 100, 1400, 4, 444343434);
        Bank euBank = new EUBank(1333, "Germany", Currency.USD, 150, 2400, 5, 616451313);
        Bank chinaBank = new ChinaBank(1444, "Austria", Currency.USD, 200, 2000, 3, 194653215);

        User user = new User(1001, "Denis", 12200, 40, "GMD", 1500, usBank);
        User user1 = new User(2002, "Petr", 27000, 60, "Ford", 30000, euBank);
        User user2 = new User(3003, "Ann", 49000, 30, "HotToys", 1800, chinaBank);

        BankSystem bankSystem = new UkrainianBankSystem();

        //снятие с счета------------------------------------------------------------------------------------------------

        //снятие +
        bankSystem.withdraw(user, 150);
        System.out.println(user.getBalance());

        //снятие суммы, превышающей баланс +
        bankSystem.withdraw(user, 15000);
        System.out.println(user.getBalance());

        //снятие отрицательной суммы -
        bankSystem.withdraw(user, -150);
        System.out.println(user.getBalance());

        //снятие 0 +
        bankSystem.withdraw(user, 150);
        System.out.println(user.getBalance());

        System.out.println();

        //перевод на счет-----------------------------------------------------------------------------------------------

        //перевод +
        System.out.println("user1Balance " + user1.getBalance() + " user2Balance " + user2.getBalance());
        bankSystem.transferMoney(user1, user2, 100);
        System.out.println("user1Balance " + user1.getBalance() + " user2Balance " + user2.getBalance());

        //перевод суммы, превышающей баланс +
        System.out.println("user1Balance " + user1.getBalance() + " user2Balance " + user2.getBalance());
        bankSystem.transferMoney(user1, user2, 30000);
        System.out.println("user1Balance " + user1.getBalance() + " user2Balance " + user2.getBalance());

        //перевод разных валют +
        System.out.println("userBalance " + user.getBalance() + " user1Balance " + user1.getBalance());
        bankSystem.transferMoney(user, user1, 100);
        System.out.println("userBalance " + user.getBalance() + " user1Balance " + user1.getBalance());

        System.out.println();

        //пополнение счета----------------------------------------------------------------------------------------------

        //пополнение +
        bankSystem.fund(user, 1000);
        System.out.println(user.getBalance());

        //лимит пополнения +
        bankSystem.fund(user, 100000);
        System.out.println(user.getBalance());

        //пополнение отрицательной суммой -
        bankSystem.fund(user, -100);
        System.out.println(user.getBalance());

        System.out.println();

        //выплата з/п------------------------------------------------------------------------------------------------

        //выплата +
        bankSystem.paySalary(user);
        System.out.println(user.getBalance());

        //лимит пополнения +
        bankSystem.paySalary(user1);
        System.out.println(user1.getBalance());

        //пополнение отрицательной суммой -
        bankSystem.paySalary(user2);
        System.out.println(user2.getBalance());

    }
}
