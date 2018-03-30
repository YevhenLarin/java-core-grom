package lesson9.homework;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        User user1 = new User(111, "Denis", "d111");
        User user2 = new User(222, "Ann", "d222");
        User user3 = new User(333, "Ann", "d333");
        User user4 = new User(444, "Yevhen", "d333");
        User user5 = new User(111, null, "d555");
        User user7 = new User(777, "Pavel", "d777");
        User user8 = new User(777, "Oleg", "d777");
        User user9 = new User(999, "Oleg", "d777");

        User[] users = {user1, user2, user3, user4, user5, null};
        User[] usersEmpty = {};

        UserRepository userRepository = new UserRepository(users);
        UserRepository empty = new UserRepository(usersEmpty);

        //getUserNames()--------------------------------------------------
        //проверка +
        //если поле имени у студента пустое -
        //если массив пустой+

        System.out.println("getUserNames");
        System.out.println(Arrays.toString(userRepository.getUserNames()));
        System.out.println(Arrays.toString(empty.getUserNames()));


        //getUserIds()----------------------------------------------------
        //проверка +
        //если массив пустой+

        System.out.println();
        System.out.println("getUserIds");
        System.out.println(Arrays.toString(userRepository.getUserIds()));
        System.out.println(Arrays.toString(empty.getUserIds()));


        //getUserNameById()-----------------------------------------------
        //существующий id +
        //не существующий id +
        //если есть одинаковые id +-
        //если массив пустой +

        System.out.println();
        System.out.println("getUserNameById");
        System.out.println(userRepository.getUserNameById(222));
        System.out.println(userRepository.getUserNameById(666));
        System.out.println(userRepository.getUserNameById(111));
        System.out.println(empty.getUserNameById(222));


        //getUserByName()-------------------------------------------------
        //существующее имя +
        //не существующее имя +
        //если есть одинаковые имена +
        //если массив пустой +

        System.out.println();
        System.out.println("getUserByName");
        System.out.println(userRepository.getUserByName("Denis"));
        System.out.println(userRepository.getUserByName("Igor"));
        System.out.println(userRepository.getUserByName("Ann"));
        System.out.println(empty.getUserByName("Denis"));

        //findById()------------------------------------------------------
        //существующий id +
        //не существующий id +
        //если есть одинаковые id +
        //если массив пустой +

        System.out.println();
        System.out.println("findById");
        System.out.println(userRepository.findById(222));
        System.out.println(userRepository.findById(666));
        System.out.println(userRepository.findById(111));
        System.out.println(empty.findById(222));

        //getUserBySessionId()--------------------------------------------
        //существующий sessionId +
        //не существующий sessionId +
        //если есть одинаковые sessionId +
        //если массив пустой +

        System.out.println();
        System.out.println("getUserBySessionId");
        System.out.println(userRepository.getUserBySessionId("d111"));
        System.out.println(userRepository.getUserBySessionId("d666"));
        System.out.println(userRepository.getUserBySessionId("d333"));
        System.out.println(empty.getUserBySessionId("d444"));

        //save()-----------------------------------------------------------
        //добавление нового юзера +
        //если юзер уже существует +
        //если массив заполнен +

        System.out.println();
        System.out.println("save");
        System.out.println(userRepository.save(user7));
        System.out.println(userRepository.save(user7));
        System.out.println(userRepository.save(user7));

        //update()----------------------------------------------------------
        //обновление юзера +
        //если юзера нет +

        System.out.println();
        System.out.println("update");
        System.out.println(userRepository.update(user8));
        System.out.println(userRepository.update(user9));
        System.out.println(Arrays.toString(users));


        //delete()------------------------------------------------------------
        //удаление юзера +
        //если юзера нет +

        System.out.println();
        System.out.println("delete");
        userRepository.delete(777);
        System.out.println(Arrays.toString(users));
        userRepository.delete(777);

    }
}
