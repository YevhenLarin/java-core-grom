package lesson25.homework;

public class User extends IdEntity{
    private long id;

    public User(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                '}';
    }
}
