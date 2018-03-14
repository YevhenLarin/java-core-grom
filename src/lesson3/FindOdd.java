package lesson3;

public class FindOdd {
    public static void main(String[] args) {
        int a = 0;
        int b = 0;

        while (a <= 1000) {
            if(a % 2 > 0) {
                System.out.println("Found");
                b += a;
            }
            a++;
        }
        if (b * 5 > 5000)
            System.out.println("Bigger");
        else
            System.out.println("Smaller or equal");

    }

}
