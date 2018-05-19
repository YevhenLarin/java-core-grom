package lesson28;

import java.util.*;

public class DemoComparator {
    public static void main(String[] args) {
        Capability capability1 = new Capability(1001, "test", "rrrr", true, new Date());
        Capability capability2 = new Capability(1005, null, "rrrr", false, new Date());
        Capability capability3 = new Capability(900, "test", "rrrr", true, null);
        Capability capability4 = new Capability(700, "test", null, false, null);
        Capability capability5 = new Capability(800, "test", "rrrr", true, null);

        ArrayList<Capability> capabilities = new ArrayList<>();
        capabilities.add(capability1);
        capabilities.add(capability2);
        capabilities.add(capability3);
        capabilities.add(capability4);
        capabilities.add(capability5);

        System.out.println(capabilities);
        System.out.println();

//        //IsActiveComparator
//        System.out.println("IsActiveComparator");
//        capabilities.sort(new IsActiveComparator());
//        System.out.println(capabilities);
//        System.out.println();
//
//        //DateComparator
//        System.out.println("DateComparator");
//        capabilities.sort(new DateComparator());
//        System.out.println(capabilities);
//        System.out.println();

        //FullComparator
        System.out.println("FullComparator");
        capabilities.sort(new FullComparator());
        System.out.println(capabilities);
        System.out.println();

    }
}
