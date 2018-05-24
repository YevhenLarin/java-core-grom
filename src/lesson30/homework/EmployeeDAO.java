package lesson30.homework;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class EmployeeDAO {

    private static ArrayList<Employee> employees;
    private static ArrayList<Employee> management;
    private static ArrayList<Employee> software;
    private static ArrayList<Employee> analytics;
    private static ArrayList<Employee> accounting;

    public EmployeeDAO() {
        Employee employee1 = new Employee("1", "1", new Date(), Position.DEVELOPER, DepartmentDAO.getDepartments().get(1), ProjectDAO.getProjects1());
        Employee employee2 = new Employee("2", "2", new Date(), Position.TEAM_LEAD, DepartmentDAO.getDepartments().get(0), ProjectDAO.getProjects1());
        Employee employee3 = new Employee("3", "3", new Date(), Position.MANAGER, DepartmentDAO.getDepartments().get(0), ProjectDAO.getProjects());
        Employee employee4 = new Employee("4", "4", new Date(), Position.DESIGNER, DepartmentDAO.getDepartments().get(1), ProjectDAO.getProjects1());
        Employee employee5 = new Employee("5", "5", new Date(), Position.ANALYST, DepartmentDAO.getDepartments().get(3), ProjectDAO.getProjects());
        Employee employee6 = new Employee("6", "6", new Date(), Position.FINANCE, DepartmentDAO.getDepartments().get(6), ProjectDAO.getProjects());
        Employee employee7 = new Employee("7", "7", new Date(), Position.TEAM_LEAD, DepartmentDAO.getDepartments().get(0), ProjectDAO.getProjects2());
        Employee employee8 = new Employee("8", "8", new Date(), Position.DESIGNER, DepartmentDAO.getDepartments().get(1), ProjectDAO.getProjects2());
        Employee employee9 = new Employee("9", "9", new Date(), Position.DEVELOPER, DepartmentDAO.getDepartments().get(1), ProjectDAO.getProjects2());
        Employee employee10 = new Employee("10", "10", new Date(), Position.LEAD_DESIGNER, DepartmentDAO.getDepartments().get(0), ProjectDAO.getProjects2());
        Employee employee11 = new Employee("11", "11", new Date(), Position.TEAM_LEAD, DepartmentDAO.getDepartments().get(6), ProjectDAO.getProjects3());
        Employee employee12 = new Employee("12", "12", new Date(), Position.DEVELOPER, DepartmentDAO.getDepartments().get(1), ProjectDAO.getProjects3());
        Employee employee13 = new Employee("13", "13", new Date(), Position.TEAM_LEAD, DepartmentDAO.getDepartments().get(0), ProjectDAO.getProjects4());
        Employee employee14 = new Employee("14", "14", new Date(), Position.DEVELOPER, DepartmentDAO.getDepartments().get(1), ProjectDAO.getProjects4());
        Employee employee15 = new Employee("15", "15", new Date(), Position.DESIGNER, DepartmentDAO.getDepartments().get(1), ProjectDAO.getProjects4());

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
    }

    public static ArrayList<Employee> getEmployees() {
        return employees;
    }

    public static ArrayList<Employee> getManagement() {
        return management;
    }

    public static ArrayList<Employee> getSoftware() {
        return software;
    }

    public static ArrayList<Employee> getAnalytics() {
        return analytics;
    }

    public static ArrayList<Employee> getAccounting() {
        return accounting;
    }

    //список сотрудников, работающих над заданным проектом
    public ArrayList<Employee> employeesByProject(String projectName) {
        ArrayList<Employee> employeesByProject = new ArrayList<>();
        for (Employee em : employees) {
            if (em != null)
                for (Project pr : em.getProjects()) {
                    if (pr != null && pr.getName().equals(projectName))
                        employeesByProject.add(em);
                }
        }
        return employeesByProject;
    }

    //список проектов, в которых участвует заданный сотрудник
    public ArrayList<Project> projectsByEmployee(Employee employee) {
        return new ArrayList<>(employee.getProjects());
    }

    //список сотрудников из заданного отдела, не участвующих ни в одном проекте
    public ArrayList<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) {
        ArrayList<Employee> employeesByDepartmentWithoutProject = new ArrayList<>();
        for (Employee em : employees) {
            if (em != null && em.getDepartment() != null && em.getDepartment().getType().equals(departmentType) && em.getProjects() == null)
                employeesByDepartmentWithoutProject.add(em);
        }
        return employeesByDepartmentWithoutProject;
    }

    //список сотрудников, не участвующих ни в одном проекте
    public ArrayList<Employee> employeesWithoutProject() {
        ArrayList<Employee> employeesWithoutProject = new ArrayList<>();
        for (Employee em : employees) {
            if (em != null && em.getProjects().isEmpty())
                employeesWithoutProject.add(em);
        }
        return employeesWithoutProject;
    }
    //список подчиненных для заданного руководителя (по всем проектам, которыми он руководит)
    public Set<Employee> employeesByTeamLead(Employee lead){
        Set<Employee> employeesByTeamLead = new HashSet<>();
        if (lead.getPosition().equals(Position.TEAM_LEAD))
            employeesByTeamLead.addAll(employeesByProjectEmployee(lead));
        return employeesByTeamLead;
    }

    //список руководителей для заданного сотрудника (по всем проектам, в которых он участвует)
    public Set<Employee> teamLeadsByEmployee(Employee employee){
        Set<Employee> teamLeadsByEmployee = new HashSet<>(employeesByProjectEmployee(employee));
        for (Employee em : teamLeadsByEmployee) {
            if (!em.getPosition().equals(Position.TEAM_LEAD))
                teamLeadsByEmployee.remove(em);
        }
        return teamLeadsByEmployee;
    }

    //список сотрудников, участвующих в тех же проектах, что и заданный сотрудник
    public Set<Employee> employeesByProjectEmployee(Employee employee){
        Set<Employee> employeesByProjectEmployee = new HashSet<>();
        for (Project pr : employee.getProjects()) {
            if (pr != null)
                employeesByProjectEmployee.addAll(employeesByProject(pr.getName()));
        }
        for (Employee em : employeesByProjectEmployee) {
            if (em.equals(employee))
                employeesByProjectEmployee.remove(em);
        }
        return employeesByProjectEmployee;
    }

    //список сотрудников, участвующих в проектах, выполняемых для заданного заказчика
    public Set<Employee> employeeByCustomerProjects(Customer customer){
        Set<Employee> employeeByCustomerProjects = new HashSet<>();
        for (Project pr : ProjectDAO.projectsByCustomer(customer)) {
            employeeByCustomerProjects.addAll(employeesByProject(pr.getName()));
        }
        return employeeByCustomerProjects;
    }

    @Override
    public String toString() {
        return "EmployeeDAO{" +
                "employees=" + employees +
                '}';
    }
}
