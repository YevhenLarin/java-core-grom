package lesson30.homework;

import java.util.ArrayList;

public class CustomerDAO {

    private ArrayList<Customer> customers;

    public CustomerDAO(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    @Override
    public String toString() {
        return "CustomerDAO{" +
                "customers=" + customers +
                '}';
    }
}
