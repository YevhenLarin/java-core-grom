package lesson17.homework;

public class Validation {
    public static void main(String[] args) {
        System.out.println("true - " + validate("https://www.gmail.com"));
        System.out.println("true - " + validate("http://www.gmail.com"));
        System.out.println("false - " + validate("https://.com"));
        System.out.println("false - " + validate("https://com"));
        System.out.println("false - " + validate("https://www.gmail.ua"));
        System.out.println("false - " + validate("www.gmail.com"));
        System.out.println("false - " + validate("gmail.com"));
        System.out.println("true - " + validate("https://gmail.com"));
        System.out.println("true - " + validate("https://www.com"));
        System.out.println("true - " + validate("https://www.www.com"));
        System.out.println("false - " + validate(""));
        System.out.println("false - " + validate("                  "));
        System.out.println("false - " + validate("(*&%*$*%*"));
        System.out.println("false - " + validate("https://www . gmail  .  com"));
        System.out.println("false - " + validate(null));
        System.out.println("false - " + validate("https://https://https://www.www.com"));
        System.out.println("false - " + validate("https://www.gmail.com.org.net"));
        System.out.println("false - " + validate("https://http://https://www.www.com.com.org.net"));
        System.out.println("false - " + validate("http://www.com.com.com"));
        System.out.println("false - " + validate("http://"));
        System.out.println("false - " + validate("http://www.www.com.com.org.net"));
        System.out.println("false - " + validate("https://https:/https//www.www.com"));
        System.out.println("true - " + validate("https://www.org.com"));
    }

    public static boolean validate(String adress) {

        if (adress == null || adress.isEmpty())
            return false;

        adress = adress.trim();

        if (!adress.startsWith("https://") && !adress.startsWith("http://"))
            return false;

//        Sys.out.println("1 " + adress);

        String[] str1 = adress.split("://");

//        Sys.out.println("2 " + Arrays.toString(str1));

        if (str1.length > 2 || str1.length == 1)
            return false;

        adress = str1[1];

//        Sys.out.println("3 " + adress);

        String[] str2 = adress.split("\\.");

//        Sys.out.println("4 " + Arrays.toString(str2));

        if (str2.length > 3 || str2.length == 1)
            return false;

        if (str2[0].isEmpty())
            return false;

//        Sys.out.println("5 " + Arrays.toString(str2));

        for (int i = 0; i < str2.length; i++) {
            adress.concat(str2[i]);
        }

//        Sys.out.println("6 " + adress);

        if (adress.startsWith("www."))
            adress = adress.substring(4);

//        Sys.out.println("7 " + adress);

        if (!adress.endsWith("com") && !adress.endsWith("org") && !adress.endsWith("net"))
            return false;

//        Sys.out.println("8 " + adress);

        adress = adress.replace(".com", "");
        adress = adress.replace(".org", "");
        adress = adress.replace(".net", "");
        adress = adress.replace("com", "");
        adress = adress.replace("org", "");
        adress = adress.replace("net", "");

//        Sys.out.println("9 " + adress);

        for (int i = 0; i < adress.length(); i++) {
            if (!Character.isLetter(adress.charAt(i)) & !Character.isDigit(adress.charAt(i))) {
                return false;
            }
        }

        if (adress.split("").length == 1) ;
        return true;
    }
}

