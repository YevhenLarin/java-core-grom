package lesson30.homework;

import java.util.ArrayList;

public class FirmDAO {

    private ArrayList<Firm> firms = new ArrayList<>();

    public ArrayList<Firm> getFirms() {
        return firms;
    }

    public void setFirms(ArrayList<Firm> firms) {
        this.firms = firms;
    }
}
