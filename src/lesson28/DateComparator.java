package lesson28;

import java.util.Comparator;

public class DateComparator implements Comparator<Capability> {

    @Override
    public int compare(Capability o1, Capability o2) {

        if (o1.getDateCreated() == null)
            return 1;
        if (o2.getDateCreated() == null || o1.getDateCreated().after(o2.getDateCreated()))
            return -1;
        else if (o1.getDateCreated().equals(o2.getDateCreated()))
            return 0;
        else
            return 1;
    }
}
