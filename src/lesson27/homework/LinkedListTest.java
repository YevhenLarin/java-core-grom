package lesson29.homework;

import java.util.LinkedList;

public class LinkedListTest {

    public static void main(String[] args) {
        useHashSet();
    }

    public static LinkedList<Order> useHashSet() {
        LinkedList<Order> list = new LinkedList<>();

        Order order1 = new Order(1001, 40, "UAH", "milk", "supermarket");
        Order order2 = new Order(1002, 20, "UAH", "bread", "supermarket");
        Order order3 = new Order(1003, 2000, "USD", "TV", "TV shop");
        Order order4 = new Order(1004, 300, "UAH", "cheese", "supermarket");
        Order order5 = new Order(1005, 100, "EUR", "watch", "watch shop");
        Order order6 = new Order(1006, 400, "USD", "", "supermarket");
        Order order7 = new Order(1007, 35000, "EUR", "car", "car showroom");
        Order order8 = new Order(1008, 270, "EUR", "something", "internet shop");
        Order order9 = new Order(1009, 150, "UAH", "meat", "market");

        list.add(order1);
        list.add(order2);
        System.out.println(list.toString());

        list.add(0,order3);
        list.add(1,order4);
        System.out.println(list.toString());

        list.clear();
        System.out.println(list.toString());

        list.add(order1);
        list.add(order2);
        list.add(0,order3);
        list.add(1,order4);
        System.out.println(list.toString());

        list.addAll(list);
        System.out.println(list.toString());

        list.remove(0);
        list.remove(order4);
        list.remove(order3);
        System.out.println(list.toString());

        System.out.println(list.subList(1, 3));

        list.set(0, order5);
        System.out.println(list.toString());

        if (list.contains(order6))
            System.out.println("YES");
        else
            System.out.println("NO");

        list.toArray();

        return list;
    }
}
