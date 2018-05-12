package lesson27.homework.userrepository;

import java.util.ArrayList;

public class UserRepository {
    private ArrayList<User> users = new ArrayList<>();

    public UserRepository(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public User findById(long id) {
        for (User user : users) {
            if (user != null && user.getId() == id)
                return user;
        }
        return null;
    }

    public User save(User user) {
        if (users != null && findById(user.getId()) == null)
            users.add(user);
        return null;
    }

    public User update(User user) {
        if (user == null || findById(user.getId()) == null)
            return null;

        int index = 0;
        for (User userUpd : users) {
            if (userUpd.getId() == user.getId()) {
                users.set(index, user);
                return user;
            }
            index++;
        }
        return null;
    }

    public void delete(long id) {

        int index = 0;
        for (User userDelete : users) {
            if (userDelete != null && userDelete.getId() == id) {
                users.remove(index);
                break;
            }
            index++;
        }
    }
}