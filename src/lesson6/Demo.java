package lesson6;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Car carObject = new Car(1000, 2015, "Anton");

        System.out.println(carObject.color);
        System.out.println(carObject.horsePower);

        System.out.println(carObject.ownerName);

        carObject.horsePower = 100;

        System.out.println(carObject.horsePower);

        carObject.startRun();
        carObject.stopRun();

        carObject.changeOwner("Test");
        System.out.println(carObject.ownerName);

        Car carObject2 = null;
        System.out.println(carObject2);

//------------------------------------------------------------------------------------------------------------------

        Order order1 = new Order(5000, new Date(), false, null, "Dnepr", "Ukraine", "Buy");
        Order order2 = new Order(100, new Date(), false, null, "Dnepr", "Ukraine", "Sale");
        Order order3 = new Order(0, new Date(), false, null, "Dnepr", "Ukraine", null);

        //confirmOrder()-----------------------------------
        //изменение статуса на true +
        //изменение даты конфирма на текущую +

        System.out.println("confirmOrder");
        order1.confirmOrder();
        System.out.println(order1.isConfirmed);
        System.out.println(order1.dateConfirmed);

        //checkPrice()-------------------------------------
        //возвращение true если цена > 1000 и false в другом случае +
        //возвращение false в другом случае +

        System.out.println("checkPrice");
        System.out.println(order1.checkPrice());
        System.out.println(order2.checkPrice());
        System.out.println(order3.checkPrice());


        //isValidType()------------------------------------
        //возвращение true если type = "Buy"
        //возвращение true если type = "Sale"
        //возвращение false в остальных случаях

        System.out.println("isValidType");
        System.out.println(order1.isValidType());
        System.out.println(order2.isValidType());
        System.out.println(order3.isValidType());




    }
}
