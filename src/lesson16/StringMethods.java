package lesson16;

import java.util.Arrays;

public class StringMethods {
    public static void main(String[] args) {

        String test = "someStringExample";

        System.out.println(test.isEmpty());

        System.out.println("".isEmpty());

        System.out.println(test.length());

        //возвращает символ по индексу
        System.out.println(test.charAt(2));

        //заменяет часть стринга на другую
        String res = test.replace("me", "T");
        System.out.println(res);

        //может использовать regex
        System.out.println(test.replaceAll("me", "T"));

        //String regex = "{a-Z}";

        //содержит ли стринг определенные чары
        System.out.println(test);
        System.out.println(test.contains("mes"));

        //делит стринг на на массив стрингов по заданному символу, при этом удаляя этот символ из стринга
        System.out.println(test);
        String phrase = "Hello there guys";
        System.out.println(Arrays.toString(phrase.split(" ")));

        //удаляет пробелы в начале и в конце стринга, если они есть
        System.out.println(" test a".trim());

        //возвращает стринг который является подстрингом изначального стринга
        System.out.println(phrase.substring(5));
        //возвращает подстрингом изначального стринга c 5 символа включительно по 10 не включительно
        System.out.println(phrase.substring(5, 10).trim());

        //приводит все буквы в стринге к маленьким
        System.out.println(test.toUpperCase());

        //приводит все буквы в стринге к большим
        System.out.println(test.toLowerCase());

        test.getBytes();
        test.equals("eeee");
        test.intern();

    }
}
