package lesson5;

import java.util.Arrays;

import static lesson5.SortArray.sortAscending;
import static lesson5.SortArray.sortDescending;
import static lesson5.UniqueCount.uniqueCount;
import static lesson5.Withdraw.withdraw;

public class Demo {
    public static void main(String[] args) {

        int[] array = {1, 5, 5, 76, 43, -5, 32, -23, 0};

        //sortAscending()-------------------------
        //проверка сортировки +
        //пустой массив +
        //одинаковые значения +

        System.out.println("sortAscending");
        System.out.println(Arrays.toString(sortAscending(array)));

        //sortDescending()------------------------
        //проверка сортировки +
        //пустой массив +
        //одинаковые значения +

        System.out.println("sortDescending");
        System.out.println(Arrays.toString(sortDescending(array)));


        //withdraw()------------------------------
        //проверка снятия +
        //снятие с несуществующего клиента +
        //снятие 0 +
        //снятие отрицательного значения -
        //сумма снятия превышает баланс +

        System.out.println("withdraw");
        String[] names = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"};
        int[] balances = {100, 500, 8432, -99, 12000, -54, 0};

        System.out.println(withdraw(names, balances, "Nikolay", 3000));
        System.out.println(withdraw(names, balances, "Пупкин", 3000));
        System.out.println(withdraw(names, balances, "Nikolay", 0));
        System.out.println(withdraw(names, balances, "Nikolay", -1000));//баг
        System.out.println(withdraw(names, balances, "Nikolay", 15000));


        //uniqueCount()---------------------------
        //нахождение уникальных +
        //однин элемент в массиве +
        //пустой масив +

        System.out.println("uniqueCount");
        int[] uniqueArray1 = {1, 5, 5, 76, 43, -5, 43, 1, 0};
        int[] uniqueArray2 = {1};
        int[] uniqueArray3 = {};

        System.out.println(uniqueCount(uniqueArray1));
        System.out.println(uniqueCount(uniqueArray2));
        System.out.println(uniqueCount(uniqueArray3));


    }
}
