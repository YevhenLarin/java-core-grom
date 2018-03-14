package lesson7;

import lesson6.Order;

import java.util.Date;

public class DemoHomeWork {

    Order createOrder() {
        Order deal = new Order(100, new Date(), false, null, "Dnepr", "Ukraine", "Buy");
        return deal;
    }

    Order createOrderAndCallMethods() {
        Order deal = new Order(100, new Date(), true, new Date(), "Kiev", "Ukraine", "SomeValue");
        deal.confirmOrder();
        deal.checkPrice();
        deal.isValidType();
        return deal;
    }

}
