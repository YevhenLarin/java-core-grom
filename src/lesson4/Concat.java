package lesson4;

public class Concat {
    public static void main(String[] args) {

        System.out.println(concat("1","2","3"));

    }

    public static String concat(String a, String b,  String c) {
        String res = a + b + c;
        return res;

    }
}
