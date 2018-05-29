package lesson31.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static Map<Character, Integer> countSymbols(String input) {

        Map<Character, Integer> map = new HashMap<>();

        char[] chArray = input.trim().toCharArray();

//        ArrayList<Character> chArrayList = new ArrayList<>();
//
//        for (Character ch : chArray)
//            if (Character.isLetter(ch))
//                chArrayList.add(ch);
//
//        for (int i = 0; i < chArrayList.size(); i++) {
//            if (!map.containsKey(chArrayList.get(i))) {
//                map.put(chArrayList.get(i), 1);
//            } else {
//                map.replace(chArrayList.get(i), map.get(chArrayList.get(i)) + 1);
//            }
//        }
//        return map;
//    }

        char ch;
        for (int i = 0; i < chArray.length; i++) {
            int index = 0;
            if (Character.isLetter(chArray[i])) {
                index++;
                ch = chArray[i];
                chArray[i] = 0;
                for (int j = i + 1; j < chArray.length; j++) {
                    if (chArray[j] == ch) {
                        index++;
                        chArray[j] = 0;
                    }
                }
                map.put(ch, index);
            }
        }
        return map;
    }

    public static Map words(String input) {

        Map<String, Integer> map = new HashMap<>();

        String[] words = strWords(input);

        String str;
        for (int i = 0; i < words.length; i++) {
            if (words[i] != null) {
                str = words[i];
                int index = 1;
                words[i] = null;

                for (int j = i + 1; j < words.length; j++) {
                    if (words[j].equals(str)) {
                        index++;
                        words[j] = null;
                    }
                }
                map.put(str, index);
            }
        }
        return map;
    }

    //метод для создания массива стрингов из слов входящего стринга
    public static String[] strWords(String input) {
        if (input.isEmpty())
            return null;

        String[] strings = input.trim().split(" ");

        int count = 0;

        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length(); j++) {
                if (!Character.isLetter(strings[i].charAt(j)))
                    break;
                if (j == strings[i].length() - 1 && strings[i].length() > 2)
                    count++;
            }
        }

        String[] words = new String[count];
        int index = 0;

        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length(); j++) {
                if (!Character.isLetter(strings[i].charAt(j)))
                    break;
                if (j == strings[i].length() - 1 && strings[i].length() > 2) {
                    words[index] = strings[i];
                    index++;
                }
            }
        }
        if (index == 0)
            return null;
        return words;
    }
}

