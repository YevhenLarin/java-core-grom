package lesson29.homework;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

    public static void main(String[] args) {
        useHashSet();
    }

    public static Set<Order> useHashSet() {

        Set<Order> set = new HashSet<>();
        Set<Order> set2 = new HashSet<>();

        Order order1 = new Order(1001, 40, "UAH", "milk", "supermarket");
        Order order2 = new Order(1002, 20, "UAH", "bread", "supermarket");
        Order order3 = new Order(1003, 2000, "USD", "TV", "TV shop");
        Order order4 = new Order(1004, 300, "UAH", "cheese", "supermarket");
        Order order5 = new Order(1005, 100, "EUR", "watch", "watch shop");
        Order order6 = new Order(1006, 400, "USD", "", "supermarket");
        Order order7 = new Order(1007, 35000, "EUR", "car", "car showroom");
        Order order8 = new Order(1008, 270, "EUR", "something", "internet shop");
        Order order9 = new Order(1009, 150, "UAH", "meat", "market");

        set.add(order1);
        set.add(order2);
        System.out.println(set.toString());

        set.clear();
        System.out.println(set.toString());

        set.add(order1);
        set.add(order2);
        set.add(order3);
        System.out.println(set.toString());

        set2.add(order4);
        set2.add(order5);
        set2.add(order6);
        set2.add(order1);

        set.addAll(set2);
        System.out.println(set.toString());

        set.remove(order3);
        set.remove(order4);
        set.remove(order5);
        set.remove(order6);
        System.out.println(set.toString());

        set.retainAll(set2);
        System.out.println(set.toString());

        System.out.println(set.size());

        set.toArray();
        System.out.println(set);

        return set;
    }
}
