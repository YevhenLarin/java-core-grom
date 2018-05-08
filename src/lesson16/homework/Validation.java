package lesson16.homework;

import java.util.Arrays;

public class Validation {
    public static void main(String[] args) {
        //Sys.out.println("true - " + validate("https://www.gmail.com"));
//        Sys.out.println("true - " + validate("http://www.gmail.com"));
//        Sys.out.println("false - " + validate("https://.com"));
//        Sys.out.println("false - " + validate("https://com"));
//        Sys.out.println("false - " + validate("https://www.gmail.ua"));
//        Sys.out.println("false - " + validate("www.gmail.com"));
//        Sys.out.println("false - " + validate("gmail.com"));
//        Sys.out.println("true - " + validate("https://gmail.com"));
//        Sys.out.println("true - " + validate("https://www.com"));
//        Sys.out.println("true - " + validate("https://www.www.com"));
//        Sys.out.println("false - " + validate(""));
//        Sys.out.println("false - " + validate("                  "));
//        Sys.out.println("false - " + validate("(*&%*$*%*"));
//        Sys.out.println("false - " + validate("https://www . gmail  .  com"));
//        Sys.out.println("false - " + validate(null));
        //Sys.out.println("false - " + validate("https://https://https://www.www.com"));
//        Sys.out.println("false - " + validate("https://www.gmail.com.org.net"));
              System.out.println("false - " + validate("https://http://https://www.www.com.com.org.net"));
//        Sys.out.println("false - " + validate("https://https:/https//www.www.com"));
    }

    public static boolean validate(String adress) {

        if (adress == null || adress.isEmpty())
            return false;

        adress = adress.trim();

        if (!adress.startsWith("https://") && !adress.startsWith("http://"))
            return false;

        if (!adress.endsWith(".com") && !adress.endsWith(".org") && !adress.endsWith(".net"))
            return false;

        String[] str1 = adress.split("http://");
        System.out.println(Arrays.toString(str1));
        if (str1.length > 2)
            return false;

        String[] str2 = adress.split("https://");
        System.out.println(Arrays.toString(str2));
        if (str2.length > 2)
            return false;



//        String[] str = adress.split("://");
//        if (str.length > 2)
//            return false;
//
//        Sys.out.println(adress);
//
//        char[] ch = str[1].trim().toCharArray();
//        for (char c : ch){
//            if (!Character.isLetterOrDigit(c))
//                return false;
//        }
//
//        Sys.out.println(adress);


        adress = adress.replace(".com", "");
        adress = adress.replace(".org", "");
        adress = adress.replace(".net", "");


        if (adress.isEmpty())
            return false;

        if (adress.trim().split("").length == 1) ;
        return true;
    }
}

