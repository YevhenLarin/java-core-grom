package lesson2;

public class SumAndDivision {
    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        int c;
        int d;
        boolean res;

        while (a <= 1000){
            b += a;
            a++;
        }
        c = b / 1234;
        d = b % 1234;
        //System.out.println(b);
        //System.out.println(c);
        //System.out.println(d);
        res = d > c;
        System.out.println(res);
    }
}
