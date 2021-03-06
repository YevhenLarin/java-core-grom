package lesson8.arithmeticAdder;

public class Arithmetic {

    public static boolean check(int[] array) {
        int min = array[0];
        int max = array[0];
        boolean res;

        for (int i : array) {
            if (i > max)
                max = i;
            if (i < min)
                min = i;
        }

        return res = (max + min) > 100;
    }
}
