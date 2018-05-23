package lesson30.homework;

import java.util.ArrayList;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {

        ArrayList<Customer> customers = new ArrayList<>();

        Customer customer1 = new Customer("Bill", "USA", 10000);
        Customer customer2 = new Customer("Ivan", "Ukraine", 100);
        Customer customer3 = new Customer("Arnold", "Austria", 8000);
        Customer customer4 = new Customer("Test", "Test", 0);

        customers.add(customer1);
        customers.add(customer1);
        customers.add(customer1);
        customers.add(customer1);

        ArrayList<Project> projects = new ArrayList<>();

        Project project1 = new Project("space", customer1);
        Project project2 = new Project("car", customer2);
        Project project3 = new Project("test", customer4);
        Project project4 = new Project("strong", customer3);

        projects.add(project1);
        projects.add(project2);
        projects.add(project3);
        projects.add(project4);

        ArrayList<Employee> employees = new ArrayList<>();

        Employee employee1 = new Employee("Vasya", "Pupkin", new Date(), Position.DEVELOPER, null, null);
        Employee employee2 = new Employee("Petya", "Vasichkin", new Date(), Position.TEAM_LEAD, null, null);
        Employee employee3 = new Employee("Kolya", "Ivanov", new Date(), Position.MANAGER, null, null);
        Employee employee4 = new Employee("Anna", "Borsch", new Date(), Position.DESIGNER, null, null);

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);

        System.out.println(customers);
        System.out.println(projects);
        System.out.println(employees);

        Department department1 = new Department(DepartmentType.SOFTWARE, null);

    }
}
