package lesson31.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static Map<Character, Integer> countSymbols(String input) {

        if (input.isEmpty())
            return null;

        ArrayList<Character> chList = new ArrayList<>();

        for (int i = 0; i < input.length(); i++)
            if (Character.isLetter(input.charAt(i)))
                chList.add(input.charAt(i));

        return  resMap(chList);
    }

    public static Map words(String input) {

        ArrayList<String> strList = checkWords(input);

        return resMap(strList);
    }

    //метод для создание результирующей Map
    private static <T> Map resMap (ArrayList<T> arrayList) {

        Map<T, Integer> map = new HashMap<>();

        for (int i = 0; i < arrayList.size(); i++) {
            if (!map.containsKey(arrayList.get(i))) {
                map.put(arrayList.get(i), 1);
            } else {
                map.replace(arrayList.get(i), map.get(arrayList.get(i)) + 1);
            }
        }
        return map;
    }

    //метод для создания коллекции из слов входящего стринга
    private static ArrayList<String> checkWords(String input) {

        if (input.isEmpty())
            return null;

        String[] strings = input.trim().split(" ");

        ArrayList<String> checkWords = new ArrayList<>();

        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length(); j++) {
                if (!Character.isLetter(strings[i].charAt(j)))
                    break;
                if (j == strings[i].length() - 1 && strings[i].length() > 2) {
                    checkWords.add(strings[i]);
                }
            }
        }
        if (checkWords.size() == 0)
            return null;
        return checkWords;
    }
}

