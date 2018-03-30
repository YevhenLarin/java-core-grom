package lesson8.arithmeticAdder;

import static lesson8.arithmeticAdder.Adder.add;
import static lesson8.arithmeticAdder.Arithmetic.check;

public class Demo {
    public static void main(String[] args) {
        Adder call = new Adder();
        add(10, 90);
        check(new int[]{2, 4, 8, 95});

        //check()------------------------------------------
        //проверка на true +
        //проверка на false +
        //если в масииве 1 элемент +
        //если в массиве все значения одинаковые
        //если массив пустой -

        System.out.println("check");
        int[] array1 = {-10, 0, 110, 555, 1000, -45, 0, 60, 10};
        int[] array2 = {-10, 0, 11, 5, 1, -45, 0, 6, 10};
        int[] array3 = {1};
        int[] array4 = {100, 100, 100, 100};
        int[] array5 = {};
        System.out.println(check(array1));
        System.out.println(check(array2));
        System.out.println(check(array3));
        System.out.println(check(array4));
        //System.out.println(check(array5));


        //add()-------------------------------------------
        //проверка +

        System.out.println("add");
        System.out.println(add(5, 150));
        System.out.println(add(-5, -150));
    }
}
