package lesson35.model;

public class Hotel {
    private long id;
    private String name;
    private String country;
    private String city;
    private String street;

    public Hotel(long id, String country, String city, String street) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.street = street;
    }
}
