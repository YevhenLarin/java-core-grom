package lesson17.homework;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String str = "   I wont g g g g g g g to   sleep g  %&    veryVery much  g to  g wont   to sleep g muc4345@ 11 22 33 &*^% f*ck sleep sleep sleep sleep";
        String str1 = "";
        String str2 = "q w e r t y u i o p";
        String str3 = "q q q q q q q q q q";
        String str4 = "                                ";
        String str5 = "q";
        System.out.println(str);
        System.out.println();
        System.out.println("words");
        System.out.println(Arrays.toString(words(str)));
        System.out.println(Arrays.toString(words(str1)));
        System.out.println(Arrays.toString(words(str2)));
        System.out.println(Arrays.toString(words(str3)));
        System.out.println(Arrays.toString(words(str4)));
        System.out.println(Arrays.toString(words(str5)));
        System.out.println();
        System.out.println("countWords");
        System.out.println(countWords(str));
        System.out.println(countWords(str1));
        System.out.println(countWords(str2));
        System.out.println(countWords(str3));
        System.out.println(countWords(str4));
        System.out.println(countWords(str5));
        System.out.println();
        System.out.println("maxWord");
        System.out.println(maxWord(str));
        System.out.println(maxWord(str1));
        System.out.println(maxWord(str2));
        System.out.println(maxWord(str3));
        System.out.println(maxWord(str4));
        System.out.println(maxWord(str5));
        System.out.println();
        System.out.println("minWord");
        System.out.println(minWord(str));
        System.out.println(minWord(str1));
        System.out.println(minWord(str2));
        System.out.println(minWord(str3));
        System.out.println(minWord(str4));
        System.out.println(minWord(str5));
        System.out.println();
        System.out.println("mostCountedWords");
        System.out.println(mostCountedWord(str));
        System.out.println(mostCountedWord(str1));
        System.out.println(mostCountedWord(str2));
        System.out.println(mostCountedWord(str3));
        System.out.println(mostCountedWord(str4));
        System.out.println(mostCountedWord(str5));
    }

    //метод для создания массива стрингов из слов входящего стринга
    private static String[] words(String input) {
        if (input.isEmpty())
            return null;

        String[] strings = input.trim().split(" ");

        int count = 0;

        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length(); j++) {
                if (!Character.isLetter(strings[i].charAt(j)))
                    break;
                if (j == strings[i].length() - 1)
                    count++;
            }
        }

        String[] words = new String[count];
        int index = 0;

        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length(); j++) {
                if (!Character.isLetter(strings[i].charAt(j)))
                    break;
                if (j == strings[i].length() - 1) {
                    words[index] = strings[i];
                    index++;
                }
            }
        }
        if (index == 0)
            return null;
        return words;
    }

    //метод для подсчета слов во входящем стринге
    public static int countWords(String input) {
        if (input.isEmpty() || words(input) == null)
            return 0;
        return words(input).length;
    }

    //метод для поиска самого длинного слова во входящем стринге
    public static String maxWord(String input) {

        if (input.isEmpty() || words(input) == null)
            return null;
        String[] strings = words(input);

        String max = strings[0];

        for (String str : strings) {
            if (str.length() > max.length())
                max = str;
        }
        return max;
    }

    //метод для поиска самого короткого слова во входящем стринге
    public static String minWord(String input) {

        if (input.isEmpty() || words(input) == null)
            return null;
        String[] strings = words(input);

        String min = strings[0];

        for (String str : strings) {
            if (str.length() < min.length())
                min = str;
        }
        return min;
    }

    //метод для поиска наиболее повторяемого слова во входящем стринге
    public static String mostCountedWord(String input) {

        if (input == null || input.isEmpty() || words(input) == null)
            return null;

        //создаем массив стрингов из слов входящего стринга
        String[] strings = words(input);

        //если в массиве 1 слово, то возвращаем его
        if (strings.length == 1)
            return strings[0];

        //ищем наиболее повторяемое слово в массиве и его индекс
        int counts[] = new int[strings.length];

        int max = 0;
        int index = 0;
        for (int i = 0; i < strings.length; i++) {
            int count = 0;
            for (int j = i + 1; j < strings.length; j++) {
                if (strings[i].equals(strings[j])) {
                    count++;
                }
            }
            if (count > max) {
                max = count;
                index = i;
            }
        }
        if (max == 0)
            return null;
        return strings[index];
    }
}