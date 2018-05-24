package lesson30.homework;

import java.util.ArrayList;

public class ProjectDAO {

    private ArrayList<Project> projects;

    public ProjectDAO(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    //список проектов, выполняемых для данного заказчика
    public ArrayList<Project> projectsByCustomer(Customer customer) {
        ArrayList<Project> projectsByCustomer = new ArrayList<>();
        for (Project pr : projects) {
            if (pr != null && pr.getCustomer().equals(customer))
                projectsByCustomer.add(pr);
        }
        return projectsByCustomer;
    }
}

