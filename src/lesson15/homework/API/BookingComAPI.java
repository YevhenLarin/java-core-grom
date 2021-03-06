package lesson15.homework.API;

public class BookingComAPI implements API {

    private Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {

        int high = price + 100;
        int low = price <= 100 ? 0 : price - 100;

        int count = 0;
        for (Room room : rooms) {
            if (room != null) {
                if (room.getPrice() <= high && room.getPrice() >= low) {
                    if (room.getPersons() == persons && room.getCityName().equals(city) && room.getHotelName().equals(hotel))
                        count++;
                }
            }
        }

        Room[] resultPrice = new Room[count];

        int index = 0;
        for (Room room : rooms) {
            if (room != null) {
                if (room.getPrice() <= high && room.getPrice() >= low) {
                    if (room.getPersons() == persons && room.getCityName().equals(city) && room.getHotelName().equals(hotel)) {
                        resultPrice[index] = room;
                        index++;
                    }
                }
            }
        }
        return resultPrice;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }

}
