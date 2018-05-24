package lesson30.homework;

import java.util.ArrayList;

public class ProjectDAO {

    private static ArrayList<Project> projects = new ArrayList<>();
    private static ArrayList<Project> projects1 = new ArrayList<>();
    private static ArrayList<Project> projects2 = new ArrayList<>();
    private static ArrayList<Project> projects3 = new ArrayList<>();
    private static ArrayList<Project> projects4 = new ArrayList<>();

    public ProjectDAO() {
        Project project1 = new Project("space", CustomerDAO.getCustomers().get(0));
        Project project2 = new Project("car", CustomerDAO.getCustomers().get(1));
        Project project3 = new Project("test", CustomerDAO.getCustomers().get(2));
        Project project4 = new Project("strong", CustomerDAO.getCustomers().get(3));
        Project project5 = new Project("5", CustomerDAO.getCustomers().get(4));
        Project project6 = new Project("6", CustomerDAO.getCustomers().get(5));
        Project project7 = new Project("7", CustomerDAO.getCustomers().get(6));

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
    }

    public static ArrayList<Project> getProjects() {
        return projects;
    }

    public static ArrayList<Project> getProjects1() {
        return projects1;
    }

    public static ArrayList<Project> getProjects2() {
        return projects2;
    }

    public static ArrayList<Project> getProjects3() {
        return projects3;
    }

    public static ArrayList<Project> getProjects4() {
        return projects4;
    }

    //список проектов, выполняемых для данного заказчика
    public static ArrayList<Project> projectsByCustomer(Customer customer) {
        ArrayList<Project> projectsByCustomer = new ArrayList<>();
        for (Project pr : projects) {
            if (pr != null && pr.getCustomer().equals(customer))
                projectsByCustomer.add(pr);
        }
        return projectsByCustomer;
    }
}

