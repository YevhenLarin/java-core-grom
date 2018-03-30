package lesson8.students;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        //createHighestParent()------------------------------------------------------
        //проверка +
        System.out.println("createHighestParent");
        System.out.println(createHighestParent());


        //createLowestChild()--------------------------------------------------------
        //проверка +
        System.out.println("createLowestChild");
        System.out.println(createLowestChild());
    }

    static Student createHighestParent(){
        Student obj = new Student("Yevhen", "Larin", 0302, new Course[]{});
        return obj;
    }

    static SpecialStudent createLowestChild(){
        SpecialStudent obj = new SpecialStudent("Vasya", "Pupkin", 42, new Course[]{}, 78542994, "email");
        return obj;
    }
}
