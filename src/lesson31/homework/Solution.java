package lesson31.homework;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static Map<Character, Integer> countSymbols(String input) {

        if (input.isEmpty())
            return null;

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch))
                resMap(ch, map);
        }
        return map;
    }

    //метод для создания коллекции из слов входящего стринга
    public static Map<String, Integer> words(String input) {

        if (input.isEmpty())
            return null;

        String[] strings = input.trim().split(" ");

        Map<String, Integer> map = new HashMap<>();

        for (String str : strings) {
            if (wordValidation(str)) {
                resMap(str, map);
            }
        }
        return map;
    }

    //метод для создания результирующей Map
    private static <T> Map resMap(T el, Map<T, Integer> map) {

        if (!map.containsKey(el)) {
            map.put(el, 1);
        } else {
            map.replace(el, map.get(el) + 1);
        }
        return map;
    }

    //метод для валидации слова
    private static boolean wordValidation(String input) {

        if (input.length() <= 2)
            return false;

        for (char ch : input.toCharArray()) {
            if (!Character.isLetter(ch))
                return false;
        }
        return true;
    }
}

