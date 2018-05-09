package lesson25.homework;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws Exception{

        GeneralDAO generalDAO = new GeneralDAO();

        Car car = new Car(1);
        generalDAO.save(car);
        System.out.println(Arrays.deepToString(generalDAO.getAll()));

        Order order = new Order(2);
        generalDAO.save(order);
        System.out.println(Arrays.deepToString(generalDAO.getAll()));

        User user = new User(3);
        generalDAO.save(user);
        System.out.println(Arrays.deepToString(generalDAO.getAll()));

        generalDAO.save(car);
        System.out.println(Arrays.deepToString(generalDAO.getAll()));

    }
}
