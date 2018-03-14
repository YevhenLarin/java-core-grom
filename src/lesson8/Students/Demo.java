package lesson8.Students;

import java.util.Date;

public class Demo {
    Student createHighestParent(){
        Student obj = new Student("Yevhen", "Larin", 0302, new Course[]{});
        return obj;
    }

    SpecialStudent createLowestChild(){
        SpecialStudent obj = new SpecialStudent("Vasya", "Pupkin", 42, new Course[]{}, 78542994, "email");
        return obj;
    }
}
