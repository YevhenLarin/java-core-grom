package lesson10.homework;

import java.util.Date;

public class ElectronicsOrder extends Order {
    private int guaranteeMonths;

    public ElectronicsOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, int guaranteeMonths) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.guaranteeMonths = guaranteeMonths;
    }

    @Override
    public void validateOrder() {
        if (getShipFromCity() == "Киев" || getShipFromCity() == "Одесса" || getShipFromCity() == "Днепр" || getShipFromCity() == "Харьков") {
            if (getShipToCity() == "Киев" || getShipToCity() == "Одесса" || getShipToCity() == "Днепр" || getShipToCity() == "Харьков") {
                if (getBasePrice() >= 100)
                    setDateConfirmed(new Date());
            }
        }
    }

    @Override
    public void calculatePrice() {
        double delivery = getShipToCity() == "Киев" || getShipToCity() == "Одесса" ? getBasePrice() * 0.10 : getBasePrice() * 0.15;
        setTotalPrice(getBasePrice() > 1000 ? (getBasePrice() + delivery) * 0.95 : getBasePrice()+ delivery);
    }

}
