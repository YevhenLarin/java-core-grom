package lesson4;

public class Sum {
    public static void main(String[] args) {
        System.out.println(compareSums(2, 5, 6, 7));

    }

    public static boolean compareSums(int a, int b, int c, int d) {
        return sum(a, b) > sum(c, d) ? true : false;
    }

    public static int sum(int from, int to) {
        int sum = 0;
        for (int i = from; i <= to; i++) {
            sum += i;
        }
        return sum;
    }
}
