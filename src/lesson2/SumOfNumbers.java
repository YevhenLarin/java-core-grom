package lesson2;

public class SumOfNumbers {
    public static void main(String[] args) {
        int a = 0;
        long b = 0;

        while (a <= 10000000){
            b += a;
            a++;
        }
        System.out.println(b);
    }
}
