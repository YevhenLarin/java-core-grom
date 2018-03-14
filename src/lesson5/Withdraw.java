package lesson5;

import java.util.Arrays;

public class Withdraw {
    public static void main(String[] args) {
        String[] names = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"};
        int[] balances = {100, 500, 8432, -99, 12000, -54, 0};
        System.out.println(Arrays.toString(balances));

        System.out.println(withdraw(names, balances, "Nikolay", 3000));
    }

    static int withdraw(String[] clients, int[] balances, String client, int amount) {
        int clientIndex = 0;
        for (String cl : clients) {
            if (cl == client) {
                if (balances[clientIndex] < amount){
                    balances[clientIndex] = -1;
                }else{
                    balances[clientIndex] -= amount;
                }
                break;
            }
            clientIndex++;
        }
        return balances[clientIndex];
    }

}
