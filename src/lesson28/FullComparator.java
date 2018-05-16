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

//        if (o1.getChannelName() != null && o2.getChannelName() != null && !o1.getChannelName().equals(o2))
//            return o1.getChannelName().compareTo(o2.getChannelName());
//        else if (o1.getFingerprint() != null && o2.getFingerprint() != null && !o1.getFingerprint().equals(o2))
//            return o1.getFingerprint().compareTo(o2.getFingerprint());
//        else if (o1.getDateCreated() != null && o2.getDateCreated() != null && !o1.getDateCreated().equals(o2))
//            return o1.getDateCreated().compareTo(o2.getDateCreated());
//        return 0;


        if (o1.getChannelName() == null)
            return 1;
        if (o2.getChannelName() == null)
            return -1;
        if (!o1.getChannelName().equals(o2))
            return o1.getChannelName().compareTo(o2.getChannelName());

        if (o1.getFingerprint() == null)
            return 1;
        if (o2.getFingerprint() == null)
            return -1;
        if (!o1.getFingerprint().equals(o2))
            return o1.getFingerprint().compareTo(o2.getFingerprint());

        if (o1.getDateCreated() == null)
            return 1;
        if (o2.getDateCreated() == null)
            return -1;
        if (!o1.getDateCreated().equals(o2.getDateCreated()))
            return o1.getDateCreated().compareTo(o2.getDateCreated());

        return 0;
    }
}
