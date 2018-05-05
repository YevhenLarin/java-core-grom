package lesson22.repository;

public class UserRepository {
    private static User[] users = new User[10];

    public static String[] getUserNames() {
        String[] usersName = new String[users.length];
        int i = 0;
        for (User user : users) {
            if (user != null)
                usersName[i] = user.getName();
            i++;
        }
        return usersName;
    }

    public static long[] getUserIds() {
        long[] userIds = new long[amount(users)];
        int i = 0;
        for (User user : users) {
            if (user != null)
                userIds[i] = user.getId();
            i++;
        }
        return userIds;
    }

    public static String getUserNameById(long id) {
        for (User user : users) {
            if (user != null && user.getId() == id)
                return user.getName();
        }
        return null;

    }

    private static int amount(User[] users) {
        int amount = 0;
        for (User user : users) {
            if (user != null)
                amount++;
        }
        return amount;
    }

    public static User getUserByName(String name) {
        for (User user : users) {
            if (user != null && user.getName() == name)
                return user;
        }
        return null;
    }

    public static User findById(long id) {
        for (User user : users) {
            if (user != null && user.getId() == id)
                return user;
        }
        return null;
    }

    public static User getUserBySessionId(String sessionId) {
        for (User user : users) {
            if (user != null && user.getSessionId() == sessionId)
                return user;
        }
        return null;
    }

    public static User save(User user) {
        if (user != null && findById(user.getId()) == null) {
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

    public static User update(User user) {
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

    public static void delete(long id) {

        int index = 0;
        for (User userDelete : users) {
            if (userDelete != null && userDelete.getId() == id) {
                users[index] = null;
                break;
            }
            index++;
        }
    }

    public static User[] getUsers() {
        return users;
    }
}