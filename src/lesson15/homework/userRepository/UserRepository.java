package lesson15.homework.userRepository;

public class UserRepository {
    private User[] users = new User[10];

    public User[] getUsers() {
        return users;
    }

    public User userFindById(long id) {
        for (User user : users) {
            if (user != null && user.getId() == id)
                return user;
        }
        return null;
    }

    public User save(User user) {
        if (users != null && user != null && userFindById(user.getId()) == null) {
            for (int i = 0; i < users.length; i++) {
                if (users[i] == null) {
                    users[i] = user;
                    return user;
                }
            }
        }
        return null;
    }

    public User update(User user) {
        if (user != null && userFindById(user.getId()) != null) {
            for (int i = 0; i < users.length; i++) {
                if (user.getId() == users[i].getId() && !user.equals(users[i]) && user.hashCode() != users[i].hashCode()) {
                    users[i] = user;
                    return user;
                }
            }
        }
        return null;
    }

    public void delete(long id) {
        User userDelete = userFindById(id);
        if (userDelete != null) {
            for (int i = 0; i < users.length; i++) {
                if (userDelete.equals(users[i]) && userDelete.hashCode() == users[i].hashCode())
                    users[i] = null;
            }
        }
    }
}
