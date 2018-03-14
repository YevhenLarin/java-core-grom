package lesson5;

public class UniqueCount {
    public static void main(String[] args) {
        int[] array = {11, 12, 11, 5, 4, 44, 100, 44, 11, 10, 11};
        System.out.println(uniqueCount(array));

    }

    static int uniqueCount(int[] array) {
        int count = 0;
        int unique = 0;
        for (int i = 0; i < array.length; i++) {
            for (int f = i+1; f < array.length; f++) {
                if (array[f] == array[i]) {
                    count++;
                    break;
                }
            }
        }
        return unique = array.length - count;

    }
}
