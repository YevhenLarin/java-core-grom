package lesson28;

import java.util.Comparator;

public class FullComparator implements Comparator<Capability> {

    @Override
    public int compare(Capability o1, Capability o2) {

        //если channelName не равно - сравниваю по нему
        //если равно - перехожу к fingerprint
        //если fingerprint не равно - сравниваю по нему
        //если равно - перехожу к dateCreated
        //если dateCreated не равно - сравниваю по нему
        //если равно - объекты равны

        System.out.println("FullComparator is used");

        if (commonCompare(o1.getChannelName(), o2.getChannelName()) != 0)
            return commonCompare(o1.getChannelName(), o2.getChannelName());

        if (commonCompare(o1.getFingerprint(), o2.getFingerprint()) != 0)
            return commonCompare(o1.getFingerprint(), o2.getFingerprint());

        return commonCompare(o1.getDateCreated(), o2.getDateCreated());
    }

    private <T extends Comparable> int commonCompare(T t1, T t2) {
        if (t1 == null)
            return 1;
        else if (t2 == null)
            return -1;
        else if (t1.equals(t2))
            return 0;
        else
            return t1.compareTo(t2);
    }
}
