package lesson7;

import lesson6.Order;

import java.util.Date;

public class DemoHomeWork {
    public static void main(String[] args) {

        //createOrder()--------------------------------------------------
        //проверка метода +

        System.out.println("createOrder");
        System.out.println(createOrder());

        //createOrderAndCallMethods()------------------------------------
        //проверка метода +

        System.out.println("createOrderAndCallMethods");
        System.out.println(createOrderAndCallMethods());

    }

    static Order createOrder() {
        Order deal = new Order(100, new Date(), false, null, "Dnepr", "Ukraine", "Buy");
        return deal;
    }

    static Order createOrderAndCallMethods() {
        Order deal = new Order(100, new Date(), true, new Date(), "Kiev", "Ukraine", "SomeValue");
        deal.confirmOrder();
        deal.checkPrice();
        deal.isValidType();
        return deal;
    }

}
