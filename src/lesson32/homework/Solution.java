package lesson32.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static int readNumbers() throws Exception {

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        int n = 2;
        String[] str = null;

        while (n >= 0) {
            str = br.readLine().split(" ");
            if (!validateNumbers(str))
                if (n == 0)
                    throw new Exception("Your numbers are wrong. Number of attempts exceeded");
                else
                    System.out.println("Your numbers are wrong. You have " + n + " attempts to try again");
            else
                break;
            n--;
        }
        return sumNumbers(str);
    }

    private static int sumNumbers(String[] input) {

        int sum = 0;
        for (String str : input) {
            sum += Integer.parseInt(str);
        }
        return sum;
    }

    private static boolean validateNumbers(String[] input) {

        if (input == null || input.length != 10)
            return false;

        for (String str : input) {
            if (!numberIsDigit(str) || Integer.parseInt(str) > 100)
                return false;
        }
        return true;
    }

    private static boolean numberIsDigit(String input) {

        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch))
                return false;
        }
        return true;
    }
}
