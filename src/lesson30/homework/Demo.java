package lesson30.homework;

import java.util.ArrayList;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {

        ArrayList<Customer> customers = new ArrayList<>();
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

        ArrayList<Project> projects = new ArrayList<>();
        ArrayList<Project> projects1 = new ArrayList<>();
        ArrayList<Project> projects2 = new ArrayList<>();
        ArrayList<Project> projects3 = new ArrayList<>();
        ArrayList<Project> projects4 = new ArrayList<>();

        Project project1 = new Project("space", customer1);
        Project project2 = new Project("car", customer2);
        Project project3 = new Project("test", customer3);
        Project project4 = new Project("strong", customer4);
        Project project5 = new Project("5", customer5);
        Project project6 = new Project("6", customer6);
        Project project7 = new Project("7", customer1);
        projects1.add(project1);
        projects1.add(project5);
        projects2.add(project2);
        projects3.add(project3);
        projects3.add(project4);
        projects4.add(project6);
        projects4.add(project7);
        projects.addAll(projects1);
        projects.addAll(projects2);
        projects.addAll(projects3);
        projects.addAll(projects4);

        ArrayList<Employee> employees = new ArrayList<>();
        ArrayList<Employee> management = new ArrayList<>();
        ArrayList<Employee> software = new ArrayList<>();
        ArrayList<Employee> analytics = new ArrayList<>();
        ArrayList<Employee> accounting = new ArrayList<>();

        ArrayList<Department> departments = new ArrayList<>();
        Department department1 = new Department(DepartmentType.MANAGEMENT, management);
        Department department2 = new Department(DepartmentType.SOFTWARE,software);
        Department department3 = new Department(DepartmentType.SUPPORT, null);
        Department department4 = new Department(DepartmentType.ANALYTICS, analytics);
        Department department5 = new Department(DepartmentType.QUALITY_CONTROL, null);
        Department department6 = new Department(DepartmentType.SECURITY, null);
        Department department7 = new Department(DepartmentType.ACCOUNTING, accounting);
        departments.add(department1);
        departments.add(department2);
        departments.add(department3);
        departments.add(department4);
        departments.add(department5);
        departments.add(department6);
        departments.add(department7);

        Employee employee1 = new Employee("1", "1", new Date(), Position.DEVELOPER, department2, projects1);
        Employee employee2 = new Employee("2", "2", new Date(), Position.TEAM_LEAD, department1, projects1);
        Employee employee3 = new Employee("3", "3", new Date(), Position.MANAGER, department1, projects);
        Employee employee4 = new Employee("4", "4", new Date(), Position.DESIGNER, department2, projects1);
        Employee employee5 = new Employee("5", "5", new Date(), Position.ANALYST, department4, projects);
        Employee employee6 = new Employee("6", "6", new Date(), Position.FINANCE, department7, projects);
        Employee employee7 = new Employee("7", "7", new Date(), Position.TEAM_LEAD, department1, projects2);
        Employee employee8 = new Employee("8", "8", new Date(), Position.DESIGNER, department2, projects2);
        Employee employee9 = new Employee("9", "9", new Date(), Position.DEVELOPER, department2, projects2);
        Employee employee10 = new Employee("10", "10", new Date(), Position.LEAD_DESIGNER, department1, projects2);
        Employee employee11 = new Employee("11", "11", new Date(), Position.TEAM_LEAD, department1, projects3);
        Employee employee12 = new Employee("12", "12", new Date(), Position.DEVELOPER, department2, projects3);
        Employee employee13 = new Employee("13", "13", new Date(), Position.TEAM_LEAD, department1, projects4);
        Employee employee14 = new Employee("14", "14", new Date(), Position.DEVELOPER, department2, projects4);
        Employee employee15 = new Employee("15", "15", new Date(), Position.DESIGNER, department2, projects4);
        management.add(employee2);
        management.add(employee3);
        management.add(employee7);
        management.add(employee10);
        management.add(employee13);
        software.add(employee1);
        software.add(employee4);
        software.add(employee8);
        software.add(employee9);
        software.add(employee12);
        software.add(employee14);
        software.add(employee15);
        analytics.add(employee5);
        accounting.add(employee6);
        accounting.add(employee11);
        employees.addAll(management);
        employees.addAll(software);
        employees.addAll(analytics);
        employees.addAll(accounting);

        EmployeeDAO employeeDAO = new EmployeeDAO(employees);
        ProjectDAO projectDAO = new ProjectDAO(projects);
        Controller controller = new Controller();
        controller.setEmployeeDAO(employeeDAO);
        controller.setProjectDAO(projectDAO);

//        System.out.println(customers);
//        System.out.println(projects);
//        System.out.println(employees);
//        System.out.println(departments);

        //список сотрудников, работающих над заданным проектом
        System.out.println(controller.employeesByProject("space"));

        //список проектов, в которых участвует заданный сотрудник
        System.out.println(controller.projectsByEmployee(employee1));

        //список сотрудников из заданного отдела, не участвующих ни в одном проекте
        System.out.println(controller.employeesByDepartmentWithoutProject(DepartmentType.SOFTWARE));

        //список сотрудников, не участвующих ни в одном проекте
        System.out.println(controller.employeesWithoutProject());

        //список подчиненных для заданного руководителя (по всем проектам, которыми он руководит)
        System.out.println(controller.employeesByTeamLead(employee2));

        //список руководителей для заданного сотрудника (по всем проектам, в которых он участвует)
        System.out.println(controller.teamLeadsByEmployee(employee4));

        //список сотрудников, участвующих в тех же проектах, что и заданный сотрудник
        System.out.println(controller.employeesByProjectEmployee(employee1));

        //список проектов, выполняемых для данного заказчика
        System.out.println(controller.projectsByCustomer(customer1));

        //список сотрудников, участвующих в проектах, выполняемых для заданного заказчика
        System.out.println(controller.employeeByCustomerProjects(customer1));
    }
}