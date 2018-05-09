package lesson25.homework;

public class Car extends IdEntity {
    private long id;

    public Car(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                '}';
    }
}
