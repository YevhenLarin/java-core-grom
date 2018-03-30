package lesson13;

public class UserRepository {
    private User[] users = new User[10];

//    public UserRepository(User[] users) {
//        this.users = users;
//    }

    public User[] getUsers() {
        return users;
    }

    public String[] getUserNames() {
        String[] usersName = new String[users.length];
        int i = 0;
        for (User user : users) {
            if (user != null)
                usersName[i] = user.getName();
            i++;
        }
        return usersName;
    }

    public long[] getUserIds() {
        long[] userIds = new long[this.amount(users)];
        int i = 0;
        for (User user : users) {
            if (user != null)
                userIds[i] = user.getId();
            i++;
        }
        return userIds;
    }

    public String getUserNameById(long id) {
        for (User user : this.users) {
            if (user != null && user.getId() == id)
                return user.getName();
        }
        return null;

    }

    private int amount(User[] users) {
        int amount = 0;
        for (User user : users) {
            if (user != null)
                amount++;
        }
        return amount;
    }

    public User getUserByName(String name) {
        for (User user : users) {
            if (user.getName() == name)
                return user;
            break;
        }
        return null;
    }

    private User findById(long id) {
        for (User user : users) {
            if (user != null && user.getId() == id)
                return user;
        }
        return null;
    }

    public User getUserBySessionId(String sessionId) {
        for (User user : users) {
            if (user.getSessionId() == sessionId)
                return user;
            break;
        }
        return null;
    }

    public User save(User user) {
        if (users != null && user != null && findById(user.getId()) == null) {
            int i = 0;
            for (User saveUser : users) {
                if (saveUser == null) {
                    users[i] = user;
                    return user;
                }
                i++;
            }
        }
        return null;
    }

    public User update(User user) {
        if (user == null || findById(user.getId()) == null)
            return null;

        int i = 0;
        for (User userUpd : users) {
            if (userUpd.getId() == user.getId()) {
                users[i] = user;
                return user;
            }
            i++;
        }
        return null;
    }

    public void delete(long id) {
        int i = 0;
        for (User userDelete : users) {
            if (userDelete != null && userDelete.getId() == id)
                users[i] = null;
            i++;
        }
    }
}