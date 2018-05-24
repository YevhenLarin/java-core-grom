package lesson30.homework;

import java.util.ArrayList;
import java.util.Set;

public class Controller {

    private EmployeeDAO employeeDAO;
    private ProjectDAO projectDAO;

    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public void setProjectDAO(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    //список сотрудников, работающих над заданным проектом
    public ArrayList<Employee> employeesByProject(String projectName){
        return employeeDAO.employeesByProject(projectName);
    }

    //список проектов, в которых участвует заданный сотрудник
    public ArrayList<Project> projectsByEmployee(Employee employee) {
        return employeeDAO.projectsByEmployee(employee);
    }

    //список сотрудников из заданного отдела, не участвующих ни в одном проекте
    public ArrayList<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) {
        return employeeDAO.employeesByDepartmentWithoutProject(departmentType);
    }

    //список сотрудников, не участвующих ни в одном проекте
    public ArrayList<Employee> employeesWithoutProject() {
        return employeeDAO.employeesWithoutProject();
    }

    //список подчиненных для заданного руководителя (по всем проектам, которыми он руководит)
    public Set<Employee> employeesByTeamLead(Employee lead){
        return employeeDAO.employeesByTeamLead(lead);
    }

    //список руководителей для заданного сотрудника (по всем проектам, в которых он участвует)
    public Set<Employee> teamLeadsByEmployee(Employee employee){
        return employeeDAO.teamLeadsByEmployee(employee);
    }

    //список сотрудников, участвующих в тех же проектах, что и заданный сотрудник
    public Set<Employee> employeesByProjectEmployee(Employee employee){
        return employeeDAO.employeesByProjectEmployee(employee);
    }

    //список проектов, выполняемых для данного заказчика
    public ArrayList<Project> projectsByCustomer(Customer customer) {
        return projectDAO.projectsByCustomer(customer);
    }

    //список сотрудников, участвующих в проектах, выполняемых для заданного заказчика
    public Set<Employee> employeeByCustomerProjects(Customer customer){
        return employeeDAO.employeeByCustomerProjects(customer);
    }
}
