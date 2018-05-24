package lesson30.homework;

import java.util.ArrayList;

public class CustomerDAO {

    private static ArrayList<Customer> customers = new ArrayList<>();

    public CustomerDAO() {

        Customer customer1 = new Customer("Bill", "USA", 10000);
        Customer customer2 = new Customer("Ivan", "Ukraine", 100);
        Customer customer3 = new Customer("Arnold", "Austria", 8000);
        Customer customer4 = new Customer("Test1", "Test1", 5000);
        Customer customer5 = new Customer("Test2", "Test2", 1000);
        Customer customer6 = new Customer("Test3", "Test3", 7000);
        Customer customer7 = new Customer("Test4", "Test4", 3000);

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);
        customers.add(customer6);
        customers.add(customer7);
    }

    public static ArrayList<Customer> getCustomers() {
        return customers;
    }

    @Override
    public String toString() {
        return "CustomerDAO{" +
                "customers=" + customers +
                '}';
    }
}
