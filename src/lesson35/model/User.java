package lesson35.model;

import java.util.List;

public class User {
    private long id;
    private String userName;
    private String password;
    private String country;
    private UserType type;

    public User(long id, String userName, String password, String country, UserType type) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.country = country;
        this.type = type;
    }
}
