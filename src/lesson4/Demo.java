package lesson4;

import static lesson4.Concat.concat;
import static lesson4.FindDivCount.findDivCount;
import static lesson4.Sum.compareSums;
import static lesson4.Sum.sum;

public class Demo {
    public static void main(String[] args) {

        //Concat-----------------------------

        System.out.println("Concat");
        System.out.println(concat("We ", "are the ", "champions"));

        //FindDivCount()-----------------------
        //проверка кратных n +
        //проверка на 0 +
        //проверка a<0 +
        //проверка a>b +

        System.out.println("FindDivCount");
        System.out.println(findDivCount((short) 1, (short) 50, 8));
        System.out.println(findDivCount((short) 1, (short) 50, 0));
        System.out.println(findDivCount((short) -1, (short) 50, 8));
        System.out.println(findDivCount((short) 50, (short) 1, 8));

        //Sum()----------------------------------
        //проверка суммы +
        //если from = to +
        //проверка с отрицательными значениями +
        //если from > to

        System.out.println("Sum");
        System.out.println(sum(1, 3));
        System.out.println(sum(5, 5));
        System.out.println(sum(-1, 3));
        System.out.println(sum(3, 1));

        //compareSums()--------------------------
        //проверка на true +
        //проверка на false +
        //если суммы равны +

        System.out.println("compareSums");
        System.out.println(compareSums(1,5,6,7));
        System.out.println(compareSums(4,5,6,7));
        System.out.println(compareSums(1,5,1,5));
    }
}
