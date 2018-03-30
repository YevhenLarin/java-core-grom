package lesson4;

public class FindDivCount {

    public static int findDivCount(short a, short b, int n) {

        int count = 0;
        if (n <= 0 || a < 0 || a > b)
            return 0;
        else {
            for (int i = a; i <= b; i++) {
                if (i % n == 0)
                    count++;
            }
            return count;
        }
    }
}
