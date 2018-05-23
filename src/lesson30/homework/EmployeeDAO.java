package lesson30.homework;

import java.util.ArrayList;

public class EmployeeDAO {

    private ArrayList<Employee> employees = new ArrayList<>();

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }


}
