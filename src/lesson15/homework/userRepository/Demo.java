package lesson15.homework.userRepository;

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

        //TODO
        UserRepository userRepository = new UserRepository(/*users*/);
        UserRepository empty = new UserRepository(/*usersEmpty*/);


        //findById()------------------------------------------------------
        //существующий id +
        //не существующий id +
        //если есть одинаковые id +
        //если массив пустой +

        System.out.println();
        System.out.println("userFindById");
        System.out.println(userRepository.userFindById(222));
        System.out.println(userRepository.userFindById(666));
        System.out.println(userRepository.userFindById(111));
        System.out.println(empty.userFindById(222));

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
