package lesson15.homework.API;

public class GoogleAPI implements API {

    private Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {

        int count = 0;
        for (Room room : rooms) {
            if (room != null) {
                if (room.getPrice() == price && room.getPersons() == persons && room.getCityName().equals(city) && room.getHotelName().equals(hotel))
                    count++;
            }
        }

        Room[] resultGoogle = new Room[count];

        int index = 0;
        for (Room room : rooms) {
            if (room != null) {
                if (room.getPrice() == price && room.getPersons() == persons && room.getCityName().equals(city) && room.getHotelName().equals(hotel)){
                    resultGoogle[index] = room;
                    index++;
                }
            }
        }
        return resultGoogle;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }
}
