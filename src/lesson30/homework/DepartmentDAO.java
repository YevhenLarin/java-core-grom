package lesson30.homework;

import java.util.ArrayList;

public class DepartmentDAO {

    private static ArrayList<Department> departments = new ArrayList<>();

    public DepartmentDAO(){

        Department department1 = new Department(DepartmentType.MANAGEMENT, EmployeeDAO.getManagement());
        Department department2 = new Department(DepartmentType.SOFTWARE,EmployeeDAO.getSoftware());
        Department department3 = new Department(DepartmentType.SUPPORT, null);
        Department department4 = new Department(DepartmentType.ANALYTICS, EmployeeDAO.getAnalytics());
        Department department5 = new Department(DepartmentType.QUALITY_CONTROL, null);
        Department department6 = new Department(DepartmentType.SECURITY, null);
        Department department7 = new Department(DepartmentType.ACCOUNTING, EmployeeDAO.getAccounting());
    }

    public static ArrayList<Department> getDepartments() {
        return departments;
    }

}
