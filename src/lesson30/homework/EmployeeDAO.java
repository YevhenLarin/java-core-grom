package lesson30.homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class EmployeeDAO {

    private ArrayList<Employee> employees;
    private ProjectDAO projectDAO;

    public EmployeeDAO(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
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
    public Set<Employee> employeesByTeamLead(Employee lead) {

        Set<Employee> employeesByTeamLead = new HashSet<>();

        if (lead.getPosition().equals(Position.TEAM_LEAD))
            employeesByTeamLead.addAll(employeesByProjectEmployee(lead));
        return employeesByTeamLead;
    }

    //список руководителей для заданного сотрудника (по всем проектам, в которых он участвует)
    public Set<Employee> teamLeadsByEmployee(Employee employee) {

        Set<Employee> employeesByProjectEmployee = new HashSet<>(employeesByProjectEmployee(employee));
        Set<Employee> teamLeadsByEmployee = new HashSet<>();

        for (Employee em : employeesByProjectEmployee) {
            if (em.getPosition().equals(Position.TEAM_LEAD))
                teamLeadsByEmployee.add(em);
        }
        return teamLeadsByEmployee;
    }

    //список сотрудников, участвующих в тех же проектах, что и заданный сотрудник
    public Set<Employee> employeesByProjectEmployee(Employee employee) {

        Set<Employee> employeesByProjectEmployee = new HashSet<>();

        for (Project pr : employee.getProjects()) {
            if (pr != null)
                employeesByProjectEmployee.addAll(employeesByProject(pr.getName()));
        }
        return employeesByProjectEmployee;
    }

    //список сотрудников, участвующих в проектах, выполняемых для заданного заказчика
    public Set<Employee> employeeByCustomerProjects(Customer customer) {

        Set<Employee> employeeByCustomerProjects = new HashSet<>();

        for (Project pr : projectDAO.projectsByCustomer(customer)) {
            employeeByCustomerProjects.addAll(employeesByProject(pr.getName()));
        }
        return employeeByCustomerProjects;
    }
}
