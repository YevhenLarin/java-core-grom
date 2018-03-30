package lesson10.homework;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {

        Customer customer1 = new Customer("Денчик", "Днепр", "Мужской");
        Customer customer2 = new Customer("Оля", "Киев", "Женский");
        Customer customer3 = new Customer("Анна", "Киев", "Женский");
        Customer customer4 = new Customer("Тест", "Днепр", "Мужской");

        ElectronicsOrder electronicsOrder1 = new ElectronicsOrder("Car", new Date(), "Киев", "Днепр", 100000, customer1, 60);
        ElectronicsOrder electronicsOrder2 = new ElectronicsOrder("Phone", new Date(), "Хацапетовка", "Киев", 15000, customer2, 24);

        FurnitureOrder furnitureOrder1 = new FurnitureOrder("Chair", new Date(), "Львов", "Киев", 1000, customer3, "Кресло");
        FurnitureOrder furnitureOrder2 = new FurnitureOrder("Table", new Date(), "Киев", "Львов", 4000, customer4, "Стол");

        electronicsOrder1.validateOrder();
        electronicsOrder1.calculatePrice();
        electronicsOrder1.confirmShipping();

        electronicsOrder2.validateOrder();
        electronicsOrder2.calculatePrice();
        electronicsOrder2.confirmShipping();

        furnitureOrder1.validateOrder();
        furnitureOrder1.calculatePrice();
        furnitureOrder1.confirmShipping();

        furnitureOrder2.validateOrder();
        furnitureOrder2.calculatePrice();
        furnitureOrder2.confirmShipping();


        //проверка проверка валидации (по городу, имени коиента) +

        System.out.println(electronicsOrder1.getDateConfirmed());
        System.out.println(electronicsOrder2.getDateConfirmed());
        System.out.println(furnitureOrder1.getDateConfirmed());
        System.out.println(furnitureOrder2.getDateConfirmed());

        //проверка расчета цены +

        System.out.println(electronicsOrder1.getTotalPrice());
        System.out.println(electronicsOrder2.getTotalPrice());
        System.out.println(furnitureOrder1.getTotalPrice());
        System.out.println(furnitureOrder2.getTotalPrice());

    }
}
