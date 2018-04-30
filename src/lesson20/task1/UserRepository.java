package lesson20.task1;

import lesson20.task1.exception.BadRequestException;
import lesson20.task1.exception.InternalServerException;
import lesson20.task1.exception.UserNotFoundException;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

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
            if (user != null && user.getName() == name)
                return user;
        }
        return null;
    }

    public User findById(long id) throws Exception {
        for (User user : users) {
            if (user != null && user.getId() == id)
                return user;
        }
        throw new UserNotFoundException("User with id: " + id + " not found");
    }

    public User getUserBySessionId(String sessionId) {
        for (User user : users) {
            if (user != null && user.getSessionId() == sessionId)
                return user;
        }
        return null;
    }

    public User save(User user) throws Exception {
        if (users == null && user == null)
            throw new BadRequestException("Can't save null user");

        try {
            findById(user.getId());
            throw new BadRequestException("User with id: " + user.getId() + " already exist");
        } catch (UserNotFoundException e) {
            System.out.println("User with id: " + user.getId() + " not found. Will be saved");
        }

        int index = 0;
        for (User us : users) {
            if (us == null) {
                users[index] = user;
                return users[index];
            }
            index++;
        }
        throw new InternalServerException("Not enough space to save user with id: " + user.getId());
    }

    public User update(User user) throws Exception {
        if (users == null && user == null)
            throw new BadRequestException("Can't save null user");

        findById(user.getId());

        int index = 0;
        for (User us : users) {
            if (us != null && us.getId() == user.getId()) {
                users[index] = user;
                return users[index];
            }
            index++;
        }
        throw new InternalServerException("Unexpected error");
    }

    public void delete(long id) throws Exception{

        findById(id);

        int index = 0;
        for (User us : users) {
            if (us != null && us.getId() == id) {
                users[index] = null;
                break;
            }
            index++;
        }
    }
}