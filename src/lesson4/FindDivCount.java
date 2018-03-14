package lesson4;

public class FindDivCount {

    public static int findDivCount (short a, short b, int n) {

        int count = 0;
        for (int i = a; i <= b; i++) {
            if (i % n == 0)
                count++;
        }
        return count;
    }
}
