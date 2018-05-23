package lesson30.homework;

import java.util.ArrayList;

public class DepartmentDAO {

    private ArrayList<Department> departments = new ArrayList<>();

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(ArrayList<Department> departments) {
        this.departments = departments;
    }
}
