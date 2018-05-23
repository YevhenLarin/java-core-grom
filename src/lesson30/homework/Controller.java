package lesson30.homework;

import java.util.ArrayList;

public class Controller {

    private EmployeeDAO employeeDAO;
    private ProjectDAO projectDAO;
    private CustomerDAO customerDAO;

    //список сотрудников, работающих над заданным проектом
    public ArrayList<Employee> employeesByProject(String projectName) {
        ArrayList<Employee> employeesByProject = new ArrayList<>();
        for (Employee em : employeeDAO.getEmployees()) {
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
        ArrayList<Project> projectsByEmployee = new ArrayList<>();
        for (Employee em : employeeDAO.getEmployees()) {
            if (em != null && em.getProjects() != null && em.equals(employee))
                projectsByEmployee.addAll(em.getProjects());
        }
        return projectsByEmployee;
    }

    //список сотрудников из заданного отдела, не участвующих ни в одном проекте
    public ArrayList<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) {
        ArrayList<Employee> employeesByDepartmentWithoutProject = new ArrayList<>();
        for (Employee em : employeeDAO.getEmployees()) {
            if (em != null && em.getDepartment().getType().equals(departmentType) && em.getProjects() == null)
                employeesByDepartmentWithoutProject.add(em);
        }
        return employeesByDepartmentWithoutProject;
    }

    //список сотрудников, не участвующих ни в одном проекте
    public ArrayList<Employee> employeesWithoutProject() {
        ArrayList<Employee> employeesWithoutProject = new ArrayList<>();
        for (Employee em : employeeDAO.getEmployees()) {
            if (em != null && em.getProjects() == null)
                employeesWithoutProject.add(em);
        }
        return employeesWithoutProject;
    }

    //список подчиненных для заданного руководителя (по всем проектам, которыми он руководит)
    public ArrayList<Employee> employeesByTeamLead(Employee lead) {
        ArrayList<Employee> employeesByTeamLead = new ArrayList<>();
        if (lead.getPosition().equals(Position.TEAM_LEAD))
            employeesByTeamLead.addAll(employeesByProjectEmployee(lead));
        return employeesByTeamLead;
    }

    //список руководителей для заданного сотрудника (по всем проектам, в которых он участвует)
    public ArrayList<Employee> teamLeadsByEmployee(Employee employee) {
        ArrayList<Employee> teamLeadsByEmployee = new ArrayList<>();
        teamLeadsByEmployee.addAll(employeesByProjectEmployee(employee));
        for (Employee em : teamLeadsByEmployee) {
            if (!em.getPosition().equals(Position.TEAM_LEAD))
                teamLeadsByEmployee.remove(em);
        }
        return teamLeadsByEmployee;
    }

    //список сотрудников, участвующих в тех же проектах, что и заданный сотрудник
    public ArrayList<Employee> employeesByProjectEmployee(Employee employee) {
        ArrayList<Employee> employeesByProjectEmployee = new ArrayList<>();
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

    //список проектов, выполняемых для данного заказчика
    public ArrayList<Project> projectsByCustomer(Customer customer) {
        ArrayList<Project> projectsByCustomer = new ArrayList<>();
        for (Project pr : projectDAO.getProjects()) {
            if (pr != null && pr.getCustomer().equals(customer))
                projectsByCustomer.add(pr);
        }
        return projectsByCustomer;
    }

    //список сотрудников, участвующих в проектах, выполняемых для заданного заказчика
    public ArrayList<Employee> employeeByCustomerProjects(Customer customer) {
        ArrayList<Employee> employeeByCustomerProjects = new ArrayList<>();
        for (Project pr : projectsByCustomer(customer)) {
            employeeByCustomerProjects.addAll(employeesByProject(pr.getName()));
        }
        return employeeByCustomerProjects;
    }
}
