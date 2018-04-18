package lesson18.exercise2;

public class Converter {
    public static void main(String[] args) {
        System.out.println(intToString(111231));
        System.out.println(StringToInt("11"));

        System.out.println(StringToInt("1050a"));

        System.out.println(intToString(111231));
        System.out.println(StringToInt("11"));

        System.out.println(intToString(111231));
        System.out.println(StringToInt("11"));
    }

    public static String intToString(int input){
        return String.valueOf(input);
    }

    public static int StringToInt(String input){
        int res;
        try {
            return Integer.parseInt(input);
        }catch (Exception e){
            System.out.println(input + " can not be converted to int");
            return 0;
        }
    }
}
