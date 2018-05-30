package lesson31.homework;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        String string = "     BJS&*BBBBB( abs ert   abs a abs j def 124*%$& ABC";

        System.out.println(string);

        System.out.println(Solution.countSymbols(string));

        System.out.println(Solution.words(string));
    }
}
