package lesson18.homework;

import java.util.Arrays;

public class Solution2 {

    public static void main(String[] args) {
        String string = "4,444 ilbdc ib 1 2 bhjk@78 3   kj hb 4 2.22 t7 ^*&  3,33    5 6   @$@$*00.?,334";

        System.out.println(Arrays.toString(findNumbers(string)));
    }

    public static int[] findNumbers(String text) {
        if (text == null || text.isEmpty())
            return null;

        String[] strings = text.trim().split(" ");

        //определяем длину массива целых чисел
        int count = 0;

        for (String str : strings) {
            if (isDigit(str))
                count++;
        }

        //создаем массив целых чисел и заполняем его
        int[] ints = new int[count];

        int index = 0;

        for (String str : strings) {
            if (isDigit(str)) {
                ints[index] = Integer.parseInt(str);
                index++;
            } else if (!str.isEmpty())
                System.out.println(str + " not a number");
        }
        return ints;
    }

    //метод для определения является ли входящий стринг числом
    private static boolean isDigit(String input) {
        if (input.isEmpty())
            return false;

        char[] charArray = input.toCharArray();

        for (char ch : charArray) {
            if (!Character.isDigit(ch))
                return false;
        }
        return true;
    }
}
