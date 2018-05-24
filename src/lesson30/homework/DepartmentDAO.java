package lesson30.homework;

import java.util.ArrayList;

public class DepartmentDAO {

    private ArrayList<Department> departments;

    public DepartmentDAO(ArrayList<Department> departments) {
        this.departments = departments;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

}
