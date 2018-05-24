package lesson30.homework;

public class Demo {
    public static void main(String[] args) {

        System.out.println(EmployeeDAO.getEmployees());
        System.out.println(ProjectDAO.getProjects());
        System.out.println(CustomerDAO.getCustomers());
        System.out.println(DepartmentDAO.getDepartments());
    }
}
